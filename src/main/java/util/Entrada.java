package util;

import model.Produto;

import java.io.Serializable;

public class Entrada implements Serializable {
    private static final long serialVersionUID = 5L;
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