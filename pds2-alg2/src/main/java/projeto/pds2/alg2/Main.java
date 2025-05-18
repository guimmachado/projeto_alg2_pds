package projeto.pds2.alg2;

public class Main {
    public static void main(String[] args) {
        // Cliente
        Cliente c1 = new Cliente("Guilherme", "Rua Jaci, 51", "06-08-2003");
        
        // Produto
        Produto p1 = new Produto("Batedeira", 399.90, 23, "Eletrodomesticos");
        
        // Instanciando Tabelha Hash
        TabelaHash th = new TabelaHash(50);

        // Colocando par chave-valor no Mapa
        th.adicionar(p1, 3);
        
        // Status antes da compra
        System.out.println("Antes da compra: ");
        System.out.println("Quantidade de acessos: " + p1.getQtdAcessos());
        System.out.println("Preço do produto: R$ " + p1.getQtdProd());
        System.out.println("Quantidade de vendas: " + p1.getQtdVendida());

        // Realizando a compra
        Carrinho compra1 = new Carrinho(c1, th);

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
