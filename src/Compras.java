import java.util.HashMap;
import java.time.LocalDateTime;

public class Compras {
    private int codCompra;
    private static int contador = 1;
    private Cliente cliente;
    private HashMap<Produtos, Integer> produtosMap;
    private double totalPedido;
    private LocalDateTime dataCompra;

    // Para realizar a compra, é necessário o Cliente e um HashMap
    // Pois é necessário mapear quais produtos foram comprados e suas quantidades
    // para realziar a venda
    public Compras(Cliente cliente, HashMap<Produtos, Integer> produtosMap) {
        if (cliente == null || produtosMap == null || produtosMap.isEmpty()) {
            throw new IllegalArgumentException("Cliente e produtos não podem ser nulos ou vazios.");
        }
        
        this.codCompra = contador++;
        this.cliente = cliente;
        this.produtosMap = produtosMap;
        this.totalPedido = produtosMap.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrecoProd() * entry.getValue()).sum();
        this.dataCompra = LocalDateTime.now();
        
        for(Produtos p : produtosMap.keySet()) {
            int quantidade = produtosMap.get(p);
            p.incrementarVenda(quantidade);
        }

    }

    public int getCodCompra() {
        return codCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public HashMap<Produtos, Integer> getProdutosMap() {
        return produtosMap;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "codCompra=" + codCompra +
                ", cliente=" + cliente.getNomeCliente() +
                ", produtos=" + produtosMap.keySet().stream().map(Produtos::getNomeProd).toList().toString() +
                ", totalPedido=" + totalPedido +
                ", dataCompra=" + dataCompra +
                '}';
    }
}
