package util;

import model.Produto;

public class NoAVL {
    // Atributos
    private Produto produto;
    private NoAVL esquerdo, direito;
    private int altura;

    // Métodos

    // Método construtor
    public NoAVL(Produto produto) {
        this.produto = produto;
        this.altura = 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NoAVL getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(NoAVL esquerdo) {
        this.esquerdo = esquerdo;
    }

    public NoAVL getDireito() {
        return direito;
    }

    public void setDireito(NoAVL direito) {
        this.direito = direito;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Getters e Setters
    
}