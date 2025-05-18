package projeto.pds2.alg2;

import java.util.ArrayList;

public class TabelaHash {
    // Atributos
    private final int capacidade;
    private ArrayList<Entrada>[] tabela;

    // Métodos

    // Método construtor
    @SuppressWarnings("unchecked")
    public TabelaHash(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new ArrayList[capacidade];

        for(int i = 0; i < capacidade; i++) {
            tabela[i] = new ArrayList<>();
        }
    }

    private int funcaoHash(Produto chave) {
        int hashCode = chave.hashCode();
        return Math.abs(hashCode) % this.capacidade;
    }

    public void adicionar(Produto chave, int valor) {
        int indice = funcaoHash(chave);
        ArrayList<Entrada> lista = tabela[indice];

        for(Entrada entrada : lista) {
            if(entrada.getChave() == chave) {
                entrada.setQuantidade(valor);
            }
        }

        lista.add(new Entrada(chave, valor));

    }

    public int buscar(Produto chave) {
        int indice = funcaoHash(chave);
        ArrayList<Entrada> lista = tabela[indice];

        for(Entrada entrada : lista) {
            if(entrada.getChave() == chave) {
                return entrada.getQuantidade();
            }
        }

        return -1;
    }

    public boolean remover(Produto chave) {
        int indice = funcaoHash(chave);
        ArrayList<Entrada> lista = tabela[indice];
        Entrada removerEntrada = null;

        for(Entrada entrada : lista) {
            if(entrada.getChave() == chave) {
                removerEntrada = entrada;
                break;
            }
        }

        if(removerEntrada != null) {
            lista.remove(removerEntrada);
            return true;
        }

        return false;
    }

    public void exibir() {
        for(int i = 0; i < capacidade; i++) {
            System.out.println("Índice " + i + ": ");
            ArrayList<Entrada> lista = tabela[i];

            if(lista.isEmpty()) {
                System.out.println("[]");
            } else {
                for(Entrada entrada : lista) {
                    System.out.println(entrada.toString());
                }
            }
        }
    }

    public boolean estaVazia() {
        for(ArrayList<Entrada> bucket : tabela) {
            if(!bucket.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public ArrayList<Entrada>[] getTabela() {
        return tabela;
    }
}
