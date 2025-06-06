package util;

import model.Produto;

public class ListaChavada {

    // atributos
    private No primeiroNo;
    private No ultimoNo;
    private int tamanho;

    // construtor
    public ListaChavada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    // métodos
    public boolean isEmpty() {
        return this.primeiroNo == null;
    }

    public void inserir(Produto produto) {
        No novoNo = new No(produto);
        if (isEmpty()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
        } else {
            this.ultimoNo.setProxNo(novoNo);
            novoNo.setAntNo(this.ultimoNo);
            this.ultimoNo = novoNo;
        }
        this.tamanho++;
    }

    public void remover(Produto produto) {
        No noAtual = this.primeiroNo;
        while (noAtual != null) {
            if (noAtual.getProdutos().equals(produto)) {
                if (noAtual == this.primeiroNo) {
                    this.primeiroNo = noAtual.getProxNo();
                    if (this.primeiroNo != null) {
                        this.primeiroNo.setAntNo(null);
                    }
                } else if (noAtual == this.ultimoNo) {
                    this.ultimoNo = noAtual.getAntNo();
                    this.ultimoNo.setProxNo(null);
                } else {
                    noAtual.getAntNo().setProxNo(noAtual.getProxNo());
                    noAtual.getProxNo().setAntNo(noAtual.getAntNo());
                }
                this.tamanho--;
                return;
            }
            noAtual = noAtual.getProxNo();
        }
    }

    public void imprimir() {
        No noAtual = this.primeiroNo;
        while (noAtual != null) {
            System.out.println(noAtual.getProdutos());
            noAtual = noAtual.getProxNo();
        }
    }

    // getters e setters
    public int getTamanho() {
        return this.tamanho;
    }
}