package service;

import model.Carrinho;
import model.Cliente;
import model.Produto;
import util.Entrada;
import util.TabelaHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistoricoCompras implements Serializable {
    private static final long serialVersionUID = 6L;
    // Atributos
    private ArrayList<Carrinho> compras;

    public HistoricoCompras() {
        this.compras = new ArrayList<>();
    }

    public boolean adicionarCompra(Carrinho carrinho) {
        if(carrinho == null || carrinho.getProdutosMap().estaVazia()){
            System.out.println("Carrinho inválido ou vazio. Não foi possível processar a compra.");
            return false;
        }
        TabelaHash produtosComprados = carrinho.getProdutosMap();
        if(produtosComprados != null && produtosComprados.getTabela() != null){
            for(ArrayList<Entrada> bucket : produtosComprados.getTabela()){
                if(bucket != null){
                    for(Entrada entrada : bucket){
                        Produto produto = entrada.getChave();
                        int qtd = entrada.getQuantidade();
                        if(produto != null){
                            produto.incrementarVenda(qtd);
                        }
                    }
                }
            }
        }
        Cliente cliente = carrinho.getCliente();
        if(cliente != null){
            cliente.incrementarNmrPedidos();
        }
        carrinho.setDataCompra(LocalDateTime.now());
        this.compras.add(carrinho);
        System.out.println("Compra (Cód: " + carrinho.getCodCompra() + ") processada e adicionada ao histórico.");
        System.out.println("Cliente: " + cliente.getNomeCliente()); //
        System.out.println("Valor Total: R$" + String.format("%.2f", carrinho.calcularValorTotal()));
        System.out.println("Data/Hora: " + carrinho.getDataCompra());
        return true;
    }

    public List<Carrinho> getListaDeCompras() {
        return new ArrayList<>(this.compras); // Retorna uma cópia para proteger a lista interna
    }

    public void listarTodasAsCompras() {
        if (this.compras.isEmpty()) {
            System.out.println("Nenhuma compra registrada no histórico.");
            return;
        }
        System.out.println("\n--- Histórico Completo de Compras ---");
        for (Carrinho compra : this.compras) {
            System.out.println(compra); // Usa o toString() do Carrinho
            System.out.println("-----------------------------------");
        }
    }

}