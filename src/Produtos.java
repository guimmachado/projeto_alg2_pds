public class Produtos {

    // atributos
    private int codProd;
    private String nomeProd;
    private double precoProd;
    private int qtdProd;
    private String categoriaProd;
    private int qtdVendida, qtdAcessos;

    // construtor
    public Produtos(int codProd, String nomeProd, double precoProd, int qtdProd, String categoriaProd) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.precoProd = precoProd;
        this.qtdProd = qtdProd;
        this.categoriaProd = categoriaProd;
        this.qtdVendida = 0;
        this.qtdAcessos = 0;
    }

    // métodos
    public void incrementarAcessos() {
        this.qtdAcessos++;
    }

    public void incrementarVenda(int qtd){
        this.qtdVendida += qtd;
        this.qtdProd -= qtd;
    }

    // getters e setters
    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public double getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(double precoProd) {
        this.precoProd = precoProd;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(int qtdProd) {
        this.qtdProd = qtdProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public int getQtdAcessos() {
        return qtdAcessos;
    }

    // toString()
    @Override
    public String toString() {
        return "Produtos{" +
                "codProd=" + codProd +
                ", nomeProd='" + nomeProd + '\'' +
                ", precoProd=" + precoProd +
                ", qtdProd=" + qtdProd +
                ", categoriaProd='" + categoriaProd + '\'' +
                '}';
    }
}
