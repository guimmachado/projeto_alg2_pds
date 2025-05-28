package model;

import util.Entrada;
import util.TabelaHash;

import java.util.ArrayList;

public class Carrinho {
    // Atributos
    private int codCompra;
    private static int contador = 1;
    private Cliente cliente;
    private TabelaHash produtosMap;
    private double totalPedido;

    // Métodos

    // Método construtor
    // Para realizar a compra, é necessário o Cliente e um HashMap
    // Pois é necessário mapear quais produtos foram comprados e suas quantidades
    // para determinado cliente para realizar a venda
    public Carrinho(Cliente cliente, TabelaHash produtosMap) {
        if(cliente == null || produtosMap == null || produtosMap.estaVazia()) {
            throw new IllegalArgumentException("Cliente e produtos não podem ser nulos ou vazios.");
        }

        this.codCompra = contador++;
        this.cliente = cliente;
        this.produtosMap = produtosMap;
    }

    // Método que calcula o valor total do carrinho
    public double calcularValorTotal() {
        double total = 0.0;

        for(ArrayList<Entrada> bucket : produtosMap.getTabela()) {
            for(Entrada entrada : bucket) {
                double precoProduto = entrada.getChave().getPrecoProd();
                int quantidade = entrada.getQuantidade();
                total += precoProduto * quantidade;
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