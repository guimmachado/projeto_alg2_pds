import model.Carrinho;
import model.Cliente;
import model.Produto;
import org.jetbrains.annotations.Nullable;
import service.ComparadorProdutos;
import service.HistoricoCompras;
import util.TabelaHash;
import util.TimSort;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    // instanciacao dos clientes e dos produtos
    private static final String ARQUIVO_CLIENTES = "clientes.ser";
    private static final String ARQUIVO_PRODUTOS = "produtos.ser";
    private static final String ARQUIVO_HISTORICO = "historico_compras.ser";
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static HistoricoCompras historicoCompras = new HistoricoCompras();

    // contém o funcionamento do sistema
    public static void main(String[] args) {
        carregarDados();
        int opcao = 0;
        do {
            menuPrincipal();
            try {
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        menuClientes();
                        break;
                    case 2:
                        menuProdutos();
                        break;
                    case 3:
                        realizarCompra();
                        break;
                    case 4:
                        visualizarHistoricoCompras();
                        break;
                    case 5:
                        menuRecomendacoes();
                        break;
                    case 6:
                        salvarDados();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        salvarDados();
                        break;
                    default:
                        System.out.println("Opcção Inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine();
                opcao = -1;
            }
            System.out.println();
        } while (opcao != 0);
    }

    // contém o funcionamento do menu principal
    public static void menuPrincipal() {
        System.out.println("===== Menu Principal =====");
        System.out.println("1. Gerenciar Clientes");
        System.out.println("2. Gerenciar Produtos");
        System.out.println("3. Realizar Compra");
        System.out.println("4. Visualizar Histórico de Compras");
        System.out.println("5. Recomendações de Produtos");
        System.out.println("6. Salvar Dados");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // contém o funcionamento do menu Gerenciar Clientes
    private static void menuClientes() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Clientes ---");
            System.out.println("1. Cadastrar Novo Cliente");
            System.out.println("2. Listar Todos os Clientes");
            System.out.println("3. Buscar Cliente por Código");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        cadastrarNovoCliente();
                        break;
                    case 2:
                        listarTodosClientes();
                        break;
                    case 3:
                        buscarClientePorCodigo();
                        break;
                    case 0:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    // função cadastrar novo cliente no sistema
    private static void cadastrarNovoCliente() {
        System.out.println("\n--- Cadastrar Novo Cliente ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Data de Nascimento (DD/MM/AAAA): ");
        String dataNasc = sc.nextLine();

        // Validações podem ser adicionadas aqui
        Cliente novoCliente = new Cliente(nome, endereco, dataNasc);
        listaClientes.add(novoCliente);
        System.out.println("Cliente " + novoCliente.getNomeCliente() + " (Cód: " + novoCliente.getCodCliente() + ") cadastrado com sucesso!");
    }

    // função de listar todos os clientes
    private static void listarTodosClientes() {
        System.out.println("\n--- Lista de Clientes ---");
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    // função de buscar o cliente por código
    private static Cliente buscarClientePorCodigo() {
        System.out.print("Digite o código do cliente: ");
        int cod = sc.nextInt();
        sc.nextLine(); // Consumir linha
        for (Cliente c : listaClientes) {
            if (c.getCodCliente() == cod) {
                System.out.println("Cliente encontrado: " + c);
                return c;
            }
        }
        System.out.println("Cliente com código " + cod + " não encontrado.");
        return null;
    }

    // função do menu produtos
    private static void menuProdutos() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Produtos ---");
            System.out.println("1. Cadastrar Novo Produto");
            System.out.println("2. Listar Todos os Produtos");
            System.out.println("3. Listar Produtos por Mais Vendidos");
            System.out.println("4. Buscar Produto por Código");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = sc.nextInt();
                sc.nextLine(); // Consumir nova linha
                switch (opcao) {
                    case 1:
                        cadastrarNovoProduto();
                        break;
                    case 2:
                        listarTodosProdutos(listaProdutos); // Passa a lista original
                        break;
                    case 3:
                        listarProdutosPorMaisVendidos();
                        break;
                    case 4:
                        buscarProdutoPorCodigo();
                        break;
                    case 0:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);
    }

    // função cadastrar novo produto no sistema
    private static void cadastrarNovoProduto() {
        System.out.println("\n--- Cadastrar Novo Produto ---");
        System.out.println("Nome do produto: ");
        String nome = sc.nextLine();
        double preco = -1;
        while (preco < 0) {
            try {
                System.out.println("Preço do Produto: ");
                preco = sc.nextDouble();
                if (preco < 0) System.out.println("Preço não pode ser negativo.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para preço.");
                preco = -1;
            } finally {
                sc.nextLine();
            }
        }
        int qtd = -1;
        while (qtd < 0) {
            try {
                System.out.print("Quantidade em Estoque: ");
                qtd = sc.nextInt();
                if (qtd < 0) System.out.println("Quantidade não pode ser negativa.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para quantidade.");
                qtd = -1; // Reseta
            } finally {
                sc.nextLine(); // Limpa o buffer
            }
        }
        System.out.print("Categoria do Produto: ");
        String categoria = sc.nextLine();

        Produto novoProduto = new Produto(nome, preco, qtd, categoria);
        listaProdutos.add(novoProduto);
        System.out.println("Produto " + novoProduto.getNomeProd() + " (Cód: " + novoProduto.getCodProd() + ") cadastrado com sucesso!");
    }

    // função de listar todos os produtos
    private static void listarTodosProdutos(ArrayList<Produto> listaProdutos) {
        System.out.println("\n--- Lista de Produtos ---");
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return;
        }
        for (Produto produto : listaProdutos) {
            System.out.println(produto + " | Estoque: " + produto.getQtdProd() + " | Vendidos: " + produto.getQtdVendida() + " | Acessos: " + produto.getQtdAcessos());
        }
    }

    // função de listar os produtos ordenados pelos mais vendidos
    private static void listarProdutosPorMaisVendidos() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto para ordenar.");
            return;
        }
        ArrayList<Produto> produtosOrdenados = new ArrayList<>(listaProdutos); // Cria cópia para não alterar a original
        // ordenação dos produtos
        TimSort.timSort(produtosOrdenados, ComparadorProdutos.porQtdVendida());
        System.out.println("Produtos Ordenados por vendas");
        for (Produto produto : produtosOrdenados) {
            System.out.println(produto.getNomeProd() + " - Vendidos: " + produto.getQtdVendida());
        }
    }

    // função de buscar o produto pelo código
    private static Produto buscarProdutoPorCodigo() {
        System.out.print("Digite o código do produto: ");
        int cod = sc.nextInt();
        sc.nextLine();
        for (Produto p : listaProdutos) {
            if (p.getCodProd() == cod) {
                System.out.println("Produto encontrado: " + p);
                p.incrementarAcessos(); // Incrementa acesso ao buscar/visualizar
                System.out.println("(Contador de acessos incrementado para este produto)");
                return p;
            }
        }
        System.out.println("Produto com código " + cod + " não encontrado.");
        return null;
    }

    // função de realizar compra
    private static void realizarCompra() {
        System.out.println("\n--- Realizar Compra ---");
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("Selecione o cliente: ");
        listarTodosClientes();
        System.out.println("Digite o código do cliente: ");
        int codCliente;
        Cliente clienteDaCompra = null;
        try {
            codCliente = sc.nextInt();
            sc.nextLine();
            clienteDaCompra = encontrarClientePorCodigo(codCliente);
            if (clienteDaCompra == null) {
                System.out.println("Cliente não encontrado.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Código de cliente inválido.");
            sc.nextLine();
            return;
        }
        System.out.println("Cliente selecionado: " + clienteDaCompra.getNomeCliente());
        TabelaHash produtosNoCarrinho = new TabelaHash(10);
        String continuarAdicionando = "";
        do {
            System.out.println("\nProdutos disponíveis:");
            listarTodosProdutos(listaProdutos);
            System.out.print("Digite o código do produto para adicionar ao carrinho: ");
            int codProd;
            Produto produtoParaAdicionar = null;
            try {
                codProd = sc.nextInt();
                sc.nextLine();
                produtoParaAdicionar = encontrarProdutoPorCodigo(codProd);

                if (produtoParaAdicionar == null) {
                    System.out.println("Produto não encontrado.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Código de produto inválido.");
                sc.nextLine();
                continue;
            }
            System.out.print("Digite a quantidade desejada: ");
            int quantidadeDesejada;
            try {
                quantidadeDesejada = sc.nextInt();
                sc.nextLine(); // Consumir nova linha

                if (quantidadeDesejada <= 0) {
                    System.out.println("Quantidade deve ser positiva.");
                    continue;
                }
                if (quantidadeDesejada > produtoParaAdicionar.getQtdProd()) {
                    System.out.println("Quantidade em estoque insuficiente. Disponível: " + produtoParaAdicionar.getQtdProd());
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Quantidade inválida.");
                sc.nextLine();
                continue;
            }
            int qtdJaNoCarrinho = produtosNoCarrinho.buscar(produtoParaAdicionar);
            if (qtdJaNoCarrinho != -1) { // Produto já está no carrinho
                produtosNoCarrinho.adicionar(produtoParaAdicionar, qtdJaNoCarrinho + quantidadeDesejada);
            } else {
                produtosNoCarrinho.adicionar(produtoParaAdicionar, quantidadeDesejada);
            }
            produtoParaAdicionar.incrementarAcessos(); // Acessado ao ser adicionado ao carrinho
            System.out.println(produtoParaAdicionar.getNomeProd() + " adicionado ao carrinho.");

            System.out.print("Deseja adicionar mais produtos? (S/N): ");
            continuarAdicionando = sc.nextLine();
        } while (continuarAdicionando.equalsIgnoreCase("S"));
        Carrinho carrinho = new Carrinho(clienteDaCompra, produtosNoCarrinho);
        if (carrinho.getProdutosMap().estaVazia()) {
            System.out.println("Carrinho vazio. Compra não finalizada.");
            return;
        }

        System.out.println("\n--- Resumo do Carrinho ---");
        System.out.println(carrinho);
        System.out.print("Confirmar compra? (S/N): ");
        String confirmar = sc.nextLine();
        if (confirmar.equalsIgnoreCase("s")) {
            boolean sucesso = historicoCompras.adicionarCompra(carrinho);
            if (sucesso) {
                System.out.println("Operação de compra finalizada.");
            } else {
                System.out.println("Houve um problema ao finalizar a compra.");
            }
        } else {
            System.out.println("Compra cancelada.");
        }
    }

    // função de mostrar o histórico de compras completo
    private static void visualizarHistoricoCompras() {
        historicoCompras.listarTodasAsCompras();
    }

    // TODO: fazer os algoritmos de recomendação
    private static void menuRecomendacoes() {
        System.out.println("\n--- Recomendações de Produtos ---");
        System.out.println("Funcionalidade de recomendação ainda não implementada.");
        // Aqui entraria a lógica para chamar os algoritmos de recomendação
        // baseados no histórico de compras, popularidade, etc.
    }

    // --- Métodos Auxiliares (encontrar por código) ---
    private static Cliente encontrarClientePorCodigo(int codigo) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodCliente() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    private static Produto encontrarProdutoPorCodigo(int codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodProd() == codigo) {
                return produto;
            }
        }
        return null;
    }

    // --- Métodos de Persistência ---
    @SuppressWarnings("unchecked") // Para o cast de readObject()
    private static void carregarDados() {
        // Carregar Clientes
        try (FileInputStream fisClientes = new FileInputStream(ARQUIVO_CLIENTES);
             ObjectInputStream oisClientes = new ObjectInputStream(fisClientes)) {
            listaClientes = (ArrayList<Cliente>) oisClientes.readObject();
            System.out.println("Clientes carregados de " + ARQUIVO_CLIENTES + ":");
            if (listaClientes != null && !listaClientes.isEmpty()) {
                Cliente.ajustarContadorAposCarregamento(listaClientes); //
                System.out.println("Próximo ID de cliente disponível: " + Cliente.getProximoIdDisponivel()); //
            } else {
                System.out.println("Nenhum cliente carregado ou arquivo vazio.");
                listaClientes = new ArrayList<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            listaClientes = new ArrayList<>();
        }

        // Carregar Produtos
        try (FileInputStream fisProdutos = new FileInputStream(ARQUIVO_PRODUTOS);
             ObjectInputStream oisProdutos = new ObjectInputStream(fisProdutos)) {

            listaProdutos = (ArrayList<Produto>) oisProdutos.readObject();
            System.out.println("\nProdutos carregados de " + ARQUIVO_PRODUTOS + ":");
            if (listaProdutos != null && !listaProdutos.isEmpty()) {
                Produto.ajustarContadorAposCarregamento(listaProdutos);
                System.out.println("Próximo ID de produto disponível: " + Produto.getProximoIdDisponivel());
            } else {
                System.out.println("Nenhum produto carregado ou arquivo vazio.");
                listaProdutos = new ArrayList<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());

            listaProdutos = new ArrayList<>();
        }

        try (ObjectInputStream oisHistorico = new ObjectInputStream(new FileInputStream(ARQUIVO_HISTORICO))) {
            historicoCompras = (HistoricoCompras) oisHistorico.readObject();
            // Se HistoricoCompras gerencia um contador estático para codCompra, ajuste-o aqui.
            // Carrinho.ajustarContadorAposCarregamento(historicoCompras.getListaDeCompras());
            System.out.println("Histórico de compras carregado de " + ARQUIVO_HISTORICO);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + ARQUIVO_HISTORICO + " não encontrado. Iniciando com histórico vazio.");
            historicoCompras = new HistoricoCompras(); // Cria uma nova instância
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar histórico de " + ARQUIVO_HISTORICO + ": " + e.getMessage());
            historicoCompras = new HistoricoCompras();
        }
    }

    private static void salvarDados() {
        // Salvar Clientes
        try (ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CLIENTES))) {
            oosClientes.writeObject(listaClientes);
            System.out.println("Clientes salvos em " + ARQUIVO_CLIENTES);
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes em " + ARQUIVO_CLIENTES + ": " + e.getMessage());
        }

        // Salvar Produtos
        try (ObjectOutputStream oosProdutos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_PRODUTOS))) {
            oosProdutos.writeObject(listaProdutos);
            System.out.println("Produtos salvos em " + ARQUIVO_PRODUTOS);
        } catch (IOException e) {
            System.err.println("Erro ao salvar produtos em " + ARQUIVO_PRODUTOS + ": " + e.getMessage());
        }

        // Salvar Histórico de Compras
        try (ObjectOutputStream oosHistorico = new ObjectOutputStream(new FileOutputStream(ARQUIVO_HISTORICO))) {
            oosHistorico.writeObject(historicoCompras);
            System.out.println("Histórico de compras salvo em " + ARQUIVO_HISTORICO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar histórico em " + ARQUIVO_HISTORICO + ": " + e.getMessage());
        }
    }
}

