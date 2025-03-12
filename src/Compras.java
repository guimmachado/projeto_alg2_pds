import java.util.List;
import java.time.LocalDateTime;

public class Compras {
    private int codCompra;
    private Cliente cliente;
    private List<Produtos> produtos;
    private double totalPedido;
    private LocalDateTime dataCompra;

    public Compras(int codCompra, Cliente cliente, List<Produtos> produtos) {
        this.codCompra = codCompra;
        this.cliente = cliente;
        this.produtos = produtos;
        this.totalPedido = produtos.stream().mapToDouble(Produtos::getPrecoProd).sum();
        this.dataCompra = LocalDateTime.now();
    }

    private double calcularTotal(){
        return produtos.stream().mapToDouble(Produtos::getPrecoProd).sum();
    }

    public int getCodCompra() {
        return codCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "codCompra=" + codCompra +
                ", cliente=" + cliente.getNomeCliente() +
                ", produtos=" + produtos.stream().map(Produtos::getNomeProd).toList().toString() +
                ", totalPedido=" + totalPedido +
                ", dataCompra=" + dataCompra +
                '}';
    }
}
