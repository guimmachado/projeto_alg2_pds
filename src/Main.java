import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cliente
        Cliente c1 = new Cliente("Guilherme", "Rua Jaci, 51", "06-08-2003");
        
        // Produto
        Produtos p1 = new Produtos("Batedeira", 399.90, 23, "Eletrodomesticos");
        
        // Mapa<Produtos, Integer> vazio
        // Onde Produtos é o produto em si
        // Integer é a quantidade
        HashMap<Produtos, Integer> produtosEQuantidade = new HashMap<>();

        // Colocando par chave-valor no Mapa
        produtosEQuantidade.put(p1, 3);
        
        // Status antes da compra
        System.out.println("Antes da compra: ");
        System.out.println("Quantidade de acessos: " + p1.getQtdAcessos());
        System.out.println("Preço do produto: R$ " + p1.getQtdProd());
        System.out.println("Quantidade de vendas: " + p1.getQtdVendida());

        // Realizando a compra
        Compras compra1 = new Compras(c1, produtosEQuantidade);

        System.out.println("Após a compra: ");
        System.out.println("Quantidade de acessos: " + p1.getQtdAcessos());
        System.out.println("Preço do produto: R$ " + p1.getQtdProd());
        System.out.println("Quantidade de vendas: " + p1.getQtdVendida());
        
        // Adicionando gerenciadores
        GerenciamentoClientes listaClientes = new GerenciamentoClientes();
        GerenciamentoProdutos listaProdutos = new GerenciamentoProdutos();
        GerenciamentoCompras listaCompras = new GerenciamentoCompras();

        listaClientes.adicionarCliente(c1);
        System.out.println(listaClientes.listarClientes());

        listaProdutos.adicionarProdutos(p1);
        System.out.println(listaProdutos.listarProdutos());

        listaCompras.adicionarCompra(compra1);
        System.out.println(listaCompras.listarCompras());

    }
}
