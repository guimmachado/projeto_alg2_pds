package projeto.pds2.alg2;

public class No {

    // atributos
    private Produto produto;
    private No proxNo;
    private No antNo;

    // construtor
    public No(Produto produto) {
        this.produto= produto;
        this.proxNo = null;
        this.antNo = null;
    }

    // getters e setters
    public void setProdutos(Produto produto) {
        this.produto = produto;
    }

    public Produto getProdutos() {
        return this.produto;
    }

    public void setProxNo(No proxNo) {
        this.proxNo = proxNo;
    }

    public No getProxNo() {
        return this.proxNo;
    }

    public No getAntNo() {
        return antNo;
    }

    public void setAntNo(No antNo) {
        this.antNo = antNo;
    }
}