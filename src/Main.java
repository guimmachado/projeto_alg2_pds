public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "Guilherme", "Rua Jaci, 51", "06-08-2003");
        Produtos p1 = new Produtos(1, "Batedeira", 399, 23, "Eletrodomesticos");
        GerenciamentoClientes listaClientes = new GerenciamentoClientes();
        GerenciamentoProdutos listaProdutos = new GerenciamentoProdutos();

        listaClientes.adicionarCliente(c1);
        System.out.println(listaClientes.listarClientes());

        listaProdutos.adicionarProdutos(p1);
        System.out.println(listaProdutos.listarProdutos());


    }
}
