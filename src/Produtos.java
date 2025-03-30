public class Produtos {

    // atributos
    private int codProd;
    private static int contador = 1;
    private String nomeProd;
    private double precoProd;
    private int qtdProd;
    private String categoriaProd;
    private int qtdVendida, qtdAcessos;

    // construtor
    public Produtos(String nomeProd, double precoProd, int qtdProd, String categoriaProd) {
        this.codProd = contador++;
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
        this.qtdAcessos++;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produtos produto = (Produtos) obj;
        return nomeProd.equals(produto.nomeProd);
    }
}
