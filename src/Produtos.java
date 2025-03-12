public class Produtos {

    // atributos
    private int codProd;
    private String nomeProd;
    private double precoProd;
    private int qtdProd;
    private String categoriaProd;

    // construtor
    public Produtos(int codProd, String nomeProd, double precoProd, int qtdProd, String categoriaProd) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.precoProd = precoProd;
        this.qtdProd = qtdProd;
        this.categoriaProd = categoriaProd;
    }

    // getters e setters
    public int getCodProd() {
        return codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public double getPrecoProd() {
        return precoProd;
    }

    public int getQtdProd() {
        return qtdProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
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
