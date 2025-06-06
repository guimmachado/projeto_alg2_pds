package service;

import model.Produto;
import model.Cliente;
import model.Carrinho;
import service.HistoricoCompras;
import util.TabelaHash;
import util.Entrada;
import util.NoAVL;
import util.TimSort;

import java.util.ArrayList;
import java.util.List;


// Árvore AVL para ordenar produtos pela quantidade vendida (qtdVendida) e recomendar produtos,
// utilizando as classes TabelaHash e TimSort

public class AVL {
    // Atributos
    private NoAVL raiz;

    // Métodos

    // Método construtor
    public AVL() {
        this.raiz = null;
    }

    // Função que retorna a altura de um nó
    private int altura(NoAVL no) {
        if(no == null) {
            return -1;
        }

        return no.getAltura();
    }

    // Calcula o fator de balanceamento de um nó (altura nóEsquerdo - altura getDireito())
    private int fatorBalanceamento(NoAVL no) {
        if(no == null) {
            return 0;
        }

        return altura(no.getEsquerdo()) - altura(no.getDireito());
    }

    // Rotação à direita
    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.getEsquerdo();
        NoAVL T2 = x.getDireito();

        // Realiza a rotação
        x.setDireito(y);
        y.setEsquerdo(T2);

        // Atualiza as alturas
        y.setAltura(Math.max(altura(y.getEsquerdo()), altura(y.getDireito())) + 1);
        x.setAltura(Math.max(altura(x.getEsquerdo()), altura(x.getDireito())) + 1);

        return x; // Nova raiz após rotação
    }

    // Rotação à esquerda
    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.getDireito();
        NoAVL T2 = y.getEsquerdo();

        // Realiza a rotação
        y.setEsquerdo(x);
        x.setDireito(T2);

        // Atualiza as alturas
        x.setAltura(Math.max(altura(x.getEsquerdo()), altura(x.getDireito())) + 1);
        y.setAltura(Math.max(altura(y.getEsquerdo()), altura(y.getDireito())) + 1);

        return y; // Nova raiz após rotação
    }

    // Compara dois produtos
    // Primeiro por qtdVendida (maior primeiro)
    // Em empate menor codProd primeiro
    private int compararProdutos(Produto p1, Produto p2) {
        if(p1.getQtdVendida() != p2.getQtdVendida()) {
            return Integer.compare(p2.getQtdVendida(), p1.getQtdVendida());
        }
        return Integer.compare(p1.getCodProd(), p2.getCodProd());
    }

    // Inserção pública
    public void inserir(Produto produto) {
        raiz = inserirRecursivo(raiz, produto);
    }

    private NoAVL inserirRecursivo(NoAVL no, Produto produto) {
        if(no == null) {
            return new NoAVL(produto);
        }

        int comparacao = compararProdutos(produto, no.getProduto());
        if(comparacao < 0) {
            no.setDireito(inserirRecursivo(no.getDireito(), produto));
        } else if(comparacao > 0) {
            no.setEsquerdo(inserirRecursivo(no.getEsquerdo(), produto));
        } else {
            return no; // Não permite valores duplicados
        }

        // Atualiza a altura do nó pai
        no.setAltura(1 + Math.max(altura(no.getEsquerdo()), altura(no.getDireito())));
        
        // Calcula o fator de balanceamento
        int fatorBalanceamento = fatorBalanceamento(no);

        // Caso LL
        if(((fatorBalanceamento > 1)) && (compararProdutos(produto, no.getEsquerdo().getProduto()) > 0)) {
            return rotacaoDireita(no);
        }

        // Caso RR
        if(((fatorBalanceamento < -1)) && (compararProdutos(produto, no.getDireito().getProduto()) < 0)) {
            return rotacaoEsquerda(no);
        }

        // Caso LR
        if(((fatorBalanceamento > 1)) && (compararProdutos(produto, no.getEsquerdo().getProduto()) < 0)) {
            no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
            return rotacaoDireita(no);
        }

        // Caso RL
        if(((fatorBalanceamento < -1)) && (compararProdutos(produto, no.getDireito().getProduto()) > 0)) {
            no.setDireito(rotacaoDireita(no.getDireito()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Remoção pública
    public void remover(Produto produto) {
        raiz = removerRecursivo(raiz, produto);
    }

    private NoAVL removerRecursivo(NoAVL no, Produto produto) {
        if(no == null) {
            return no; // Nada a remover, returno null
        }

        int comparacao = compararProdutos(produto, no.getProduto());
        if(comparacao < 0) {
            no.setDireito(removerRecursivo(no.getDireito(), produto));
        } else if(comparacao > 0) {
            no.setEsquerdo(removerRecursivo(no.getEsquerdo(), produto));
        } else {
            // Encontrou o nó a remover
            // Nó com um ou nenhum filho
            if((no.getEsquerdo() == null) || no.getDireito() == null) {
                NoAVL noTemporario = (no.getEsquerdo() != null) ? no.getEsquerdo() : no.getDireito();
                if(noTemporario == null) { // Caso de nó sem filhos
                    no = null;
                } else {
                    no = noTemporario; // Nó com um filho
                }
            } else { // Nó com dois filhos
                NoAVL noSucessor = menorValorNo(no.getDireito()); // Encontra o menor valor
                no.setProduto(noSucessor.getProduto());
                no.setDireito(removerRecursivo(no.getDireito(), noSucessor.getProduto())); // Remove o nó substituto
            }
        }

        // Se o nó foi removido e agora é NULL, retornar
        if(no == null) {
            return no;
        }

        // Atualiza a altura do nó atual
        no.setAltura(Math.max(altura(no.getEsquerdo()), altura(no.getDireito())) + 1);
        
        // Calcula o fator de balanceamento
        int fatorBalanceamento = fatorBalanceamento(no);

        // Caso LL
        if((fatorBalanceamento > 1) && (fatorBalanceamento(no.getEsquerdo()) >= 0)) {
            return rotacaoDireita(no);
        }

        // Caso LR
        if((fatorBalanceamento > 1) && (fatorBalanceamento(no.getEsquerdo()) < 0)) {
            no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
            return rotacaoDireita(no);
        }

        // Caso RR
        if((fatorBalanceamento < -1) && (fatorBalanceamento(no.getDireito()) <= 0)) {
            return rotacaoEsquerda(no);
        }

        // Caso RL
        if((fatorBalanceamento < -1) && (fatorBalanceamento(no.getDireito()) > 0)) {
            no.setDireito(rotacaoDireita(no.getDireito()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private NoAVL menorValorNo(NoAVL no) {
        NoAVL noCorrente = no;
        while (noCorrente.getEsquerdo() != null) {
            noCorrente = noCorrente.getEsquerdo();
        }
        return noCorrente;
    }

    // Gera recomendações para um dado cliente, com base em seu histórico.
    // Utiliza TabelaHash para identificar produtos já comprados
    // Utiliza TimSort para ordenar categorias
     
    public List<Produto> recomendarProdutos(Cliente cliente, HistoricoCompras historicoCompras, int quantidadeMaximaRecomendacoes) {
        // TabelaHash para registrar produtos já comprados pelo cliente
        TabelaHash produtosComprados = new TabelaHash(100);
        
        // Listas paralelas para categorias e suas frequências
        ArrayList<String> listaCategorias = new ArrayList<>();
        ArrayList<Integer> listaFrequencias = new ArrayList<>();

        // Percorre todos os Carrinhos no histórico
        for(Carrinho carrinho : historicoCompras.getListaDeCompras()) {
            // Filtra apenas as compras do cliente em questão
            if(carrinho.getCliente().getCodCliente() == cliente.getCodCliente()) {
                // Obtém a tabela de produtos deste carrinho
                TabelaHash produtosCarrinho = carrinho.getProdutosMap();

                if((produtosCarrinho != null) && (produtosCarrinho.getTabela() != null)) {
                    // Para cada bucket na tabela hash de produtos comprados
                    for(ArrayList<Entrada> bucket : produtosCarrinho.getTabela()) {
                        if(bucket != null) {
                            for(Entrada entrada : bucket) {
                                Produto produtoComprado = entrada.getChave();
                                int quantidadeComprada = entrada.getQuantidade();
                                String categoria = produtoComprado.getCategoriaProd();

                                // Marca produtoComoComprado na produtosComprados
                                produtosComprados.adicionar(produtoComprado, 1);

                                // Atualiza contagem de categoria nas listas paralelas
                                if (!listaCategorias.contains(categoria)) {
                                    listaCategorias.add(categoria);
                                    listaFrequencias.add(quantidadeComprada);
                                } else {
                                    int indice = listaCategorias.indexOf(categoria);
                                    int frequenciaAtual = listaFrequencias.get(indice);
                                    listaFrequencias.set(indice, frequenciaAtual + quantidadeComprada);
                                }
                            }
                        }
                    }
                }
            }
        }

        // Ordena listaCategorias por frequência decrescente usando TimSort
        TimSort.timSort(listaCategorias, (categoria1, categoria2) -> {
            int indice1 = listaCategorias.indexOf(categoria1);
            int indice2 = listaCategorias.indexOf(categoria2);
            int freq1 = listaFrequencias.get(indice1);
            int freq2 = listaFrequencias.get(indice2);
            return Integer.compare(freq2, freq1);
        });

        // Lista de recomendações vazia
        List<Produto> listaRecomendacoes = new ArrayList<>();
        // Percorre a árvore em "em ordem reverso"
        // para coletar produtos que não foram comprados
        // e cuja categoria esteja em listaCategorias
        coletar(raiz, listaCategorias, produtosComprados, listaRecomendacoes, quantidadeMaximaRecomendacoes);

        return listaRecomendacoes;
    }

    // Percorre a árvore em ordem decrescente de qtdVendida (em ordem reverso):
    // 1. Visita subárvore direita (produtos mais populares)
    // 2. Processa o nó atual (verifica se produto não foi comprado e se categoria está na lista)
    // 3. Visita subárvore esquerda (produtos menos populares)
    //
    // Cada vez que encontra um produto que: não está em produtosComprados
    // e a sua categoria está em listaCategorias, 
    // adiciona à lista de recomendações até atingir o limite.
    private void coletar(NoAVL no, ArrayList<String> listaCategoriasOrdenadas, TabelaHash produtosComprados, List<Produto> listaSaida, int limite) {
        if((no == null) || (listaSaida.size() >= limite)) {
            return;
        }
        // 1. Visita subárvore direita (produtos com qtdVendida maior)
        coletar(no.getDireito(), listaCategoriasOrdenadas, produtosComprados, listaSaida, limite);
        if (listaSaida.size() >= limite) {
            return;
        }
        // 2. Processa o nó atual
        Produto produtoAtual = no.getProduto();
        int jaComprou = produtosComprados.buscar(produtoAtual);
        String categoriaProdutoAtual = produtoAtual.getCategoriaProd();
        boolean categoriaEhValida = listaCategoriasOrdenadas.contains(categoriaProdutoAtual);
        if((jaComprou == 0) && (categoriaEhValida)) {
            listaSaida.add(produtoAtual);
            
            if(listaSaida.size() >= limite) {
                return;
            }
        }
        // 3. Visita subárvore esquerda (produtos com qtdVendida menor)
        coletar(no.getEsquerdo(), listaCategoriasOrdenadas, produtosComprados, listaSaida, limite);
    }
    
    // Percurso em ordem
    public void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.getEsquerdo());
            System.out.println(no.getProduto() + " | qtdVendida=" + no.getProduto().getQtdVendida());
            emOrdem(no.getDireito());
        }
    }

    // getRaiz
    public NoAVL getRaiz() {
        return raiz;
    }


}
