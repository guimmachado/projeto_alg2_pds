package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codProd;
    private static int contador = 1;
    private String nomeProd;
    private double precoProd;
    private int qtdProd;
    private String categoriaProd;
    private int qtdVendida;
    private int qtdAcessos;

    // Construtor original para criar NOVOS produtos
    public Produto(String nomeProd, double precoProd, int qtdProd, String categoriaProd) {
        this.codProd = contador++;
        this.nomeProd = nomeProd;
        this.precoProd = precoProd;
        this.qtdProd = qtdProd;
        this.categoriaProd = categoriaProd;
        this.qtdVendida = 0;
        this.qtdAcessos = 0;
    }

    // Construtor para recriar produtos a partir de dados existentes (ex: de um arquivo)
    public Produto(int codProd, String nomeProd, double precoProd, int qtdProd, String categoriaProd, int qtdVendida, int qtdAcessos) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
        this.precoProd = precoProd;
        this.qtdProd = qtdProd;
        this.categoriaProd = categoriaProd;
        this.qtdVendida = qtdVendida;
        this.qtdAcessos = qtdAcessos;
        // Garante que o próximo ID gerado seja maior que qualquer ID carregado
        if (this.codProd >= contador) {
            contador = this.codProd + 1;
        }
    }

    // metodos
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
        Produto produto = (Produto) obj;
        return this.codProd == produto.codProd
                && (Objects.equals(this.nomeProd, produto.nomeProd));
    }

    // HashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + codProd;
        hash = 31 * hash + (nomeProd != null ? nomeProd.hashCode() : 0); // inclui nomeProd
        return hash;
    }

    // Metodo para ajustar o contador estático após carregar uma lista de produtos
    public static void ajustarContadorAposCarregamento(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            return;
        }
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getCodProd() > maxId) {
                maxId = p.getCodProd();
            }
        }
        contador = maxId + 1;
    }

    // Metodo para obter o próximo ID a ser usado
    public static int getProximoIdDisponivel() {
        return contador;
    }
}