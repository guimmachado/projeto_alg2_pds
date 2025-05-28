package service;

import model.Carrinho;
import model.Produto;
import util.Entrada;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HistoricoCompras {
    // Atributos
    private ArrayList<Carrinho> compras;

    // Metodos

    // Metodo construtor padrão do Java

    // Metodo que efetiva a compra de um determinado carrinho
    // O carrinho pode ser selecionado
    // Pois é um Array de carrinhos
    public boolean comprarCarrinho(int indice) {
        if (compras.get(indice - 1) != null) {
            // Calculando o valor total do carrinho
            Carrinho carrinhoSelecionado = compras.get(indice - 1);
            double valorTotal = carrinhoSelecionado.calcularValorTotal();

            // Incrementando número de pedidos do cliente
            carrinhoSelecionado.getCliente().incrementarNmrPedidos();

            // Dando baixa na quantidade vendida de cada produto
            for (ArrayList<Entrada> bucket : carrinhoSelecionado.getProdutosMap().getTabela()) {
                if (bucket != null) {
                    for (Entrada entrada : bucket) {
                        Produto produto = entrada.getChave();
                        int quantidade = entrada.getQuantidade();
                        produto.incrementarVenda(quantidade);
                    }
                }
            }

            // Registro de data e hora da compra
            LocalDateTime dataCompra = LocalDateTime.now();

            StringBuilder sb = new StringBuilder();
            sb.append("Carrinho comprado com sucesso!").append("\n");
            sb.append("Cliente: ").append(carrinhoSelecionado.getCliente().getNomeCliente()).append("\n");
            sb.append("Valor total do carrinho: R$ ").append(valorTotal).append("\n");
            sb.append("Compra realizada em: ").append(dataCompra);
            sb.toString();

            return true;

        } else {
            System.out.println("Opção inválida.");
            return false;
        }
    }
}