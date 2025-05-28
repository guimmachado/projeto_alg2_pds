package util;

import model.Produto;

public class Entrada {
    private Produto chave;
    private int quantidade;

    public Entrada(Produto chave, int quantidade) {
        this.chave = chave;
        this.quantidade = quantidade;
    }

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

    @Override
    public String toString() {
        return "{" + chave + " = " + quantidade + "}";
    }


}