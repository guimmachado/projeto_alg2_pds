import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "Guilherme", "Rua Jaci, 51", "06-08-2003");
        Produtos p1 = new Produtos(1, "Batedeira", 399.90, 23, "Eletrodomesticos");
        Compras compra1 = new Compras(1, c1, new ArrayList<Produtos>());
        compra1.getProdutos().add(p1);
        GerenciamentoClientes listaClientes = new GerenciamentoClientes();
        GerenciamentoProdutos listaProdutos = new GerenciamentoProdutos();
        GerenciamentoCompras listaCompras = new GerenciamentoCompras();

//        listaClientes.adicionarCliente(c1);
//        System.out.println(listaClientes.listarClientes());
//
//        listaProdutos.adicionarProdutos(p1);
//        System.out.println(listaProdutos.listarProdutos());

        listaCompras.adicionarCompra(compra1);
        System.out.println(listaCompras.listarCompras());

    }
}
