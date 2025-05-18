package projeto.pds2.alg2;

public class Produto {

    // atributos
    private int codProd;
    private static int contador = 1;
    private String nomeProd;
    private double precoProd;
    private int qtdProd;
    private String categoriaProd;
    private int qtdVendida, qtdAcessos;

    // construtor
    public Produto(String nomeProd, double precoProd, int qtdProd, String categoriaProd) {
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

    // Método equals para comparações
    // Dois produtos são iguais se seus nomes são iguais e se seus códigos de produto (ID) são iguais
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return this.codProd == produto.codProd
           && (this.nomeProd != null ? this.nomeProd.equals(produto.nomeProd) : produto.nomeProd == null);
    }

    // HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + codProd;
        hash = 31 * hash + (nomeProd != null ? nomeProd.hashCode() : 0); // inclui nomeProd
        return hash;
    }
}
