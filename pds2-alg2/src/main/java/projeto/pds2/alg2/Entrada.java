package projeto.pds2.alg2;

public class Entrada {
    // Atributos
    private Produto chave;
    private int quantidade;

    // Métodos

    // Método construtor
    public Entrada(Produto chave, int quantidade) {
        this.chave = chave;
        this.quantidade = quantidade;
    }
    
    // Getters e Setters
    public Produto getChave() {
        return chave;
    }

    public void setChave(Produto chave) {
        this.chave = chave;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // toString
    @Override
    public String toString() {
        return "{" + chave + " = " + quantidade + "}";
    }

    
}
