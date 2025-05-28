package model;

import util.Entrada;
import util.TabelaHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable {
    private static final long serialVersionUID = 3L;
    // Atributos
    private int codCompra;
    private static int contador = 1;
    private Cliente cliente;
    private TabelaHash produtosMap;
    private LocalDateTime dataCompra;
    private double totalPedido;

    // Metodos

    // Metodo construtor
    // Para realizar a compra, é necessário o Cliente e um HashMap
    // Pois é necessário mapear quais produtos foram comprados e suas quantidades
    // para determinado cliente para realizar a venda
    public Carrinho(Cliente cliente, TabelaHash produtosMap) {
        if(cliente == null || produtosMap == null || produtosMap.estaVazia()) {
            throw new IllegalArgumentException("Cliente e produtos não podem ser nulos ou mapa de produtos vazio para criar um carrinho.");
        }
        this.codCompra = contador++;
        this.cliente = cliente;
        this.produtosMap = produtosMap;
        this.totalPedido = calcularValorTotal();
    }

    // Método que calcula o valor total do carrinho
    public double calcularValorTotal() {
        double total = 0.0;

        if(produtosMap != null && produtosMap.getTabela() != null) {
            for (ArrayList<Entrada> bucket : produtosMap.getTabela()) {
                if(bucket != null) {
                    for (Entrada entrada : bucket) {
                        double precoProduto = entrada.getChave().getPrecoProd();
                        int quantidade = entrada.getQuantidade();
                        total += precoProduto * quantidade;
                    }
                }
            }
        }
        return total;
    }

    // Getters
    public int getCodCompra() {
        return codCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public TabelaHash getProdutosMap() {
        return produtosMap;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public static void ajustarContadorAposCarregamento(List<Carrinho> compras) {
        if (compras == null || compras.isEmpty()) {
            return;
        }
        int maxId = 0;
        for (Carrinho c : compras) {
            if (c.getCodCompra() > maxId) {
                maxId = c.getCodCompra();
            }
        }
        contador = maxId + 1;
    }
    public static int getProximoIdDisponivel() {
        return contador;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrinho do cliente: ").append(cliente.getNomeCliente()).append("\n");
        sb.append("Produtos no carrinho:\n");

        for (ArrayList<Entrada> bucket : produtosMap.getTabela()) {
            if (bucket != null) {
                for (Entrada entrada : bucket) {
                    Produto prod = entrada.getChave();
                    int qtd = entrada.getQuantidade();

                    sb.append("- ").append(prod.getNomeProd())
                            .append(" | Quantidade: ").append(qtd)
                            .append(" | Preço: R$").append(prod.getPrecoProd())
                            .append("\n");
                }
            }
        }

        sb.append("Preço total do carrinho: ").append(calcularValorTotal());

        return sb.toString();
    }

}