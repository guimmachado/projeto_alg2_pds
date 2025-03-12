public class No {
    private Produtos produto;
    private No proxNo;
    private No antNo;

    public No(Produtos produto) {
        this.produto= produto;
        this.proxNo = null;
        this.antNo = null;
    }

    public void setProdutos(Produtos produto) {
        this.produto = produto;
    }

    public Produtos getProdutos() {
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