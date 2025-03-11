public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente(1, "Guilherme", "Rua Jaci, 51", "06-08-2003");
        GerenciamentoClientes listaClientes = new GerenciamentoClientes();

        listaClientes.adicionarCliente(c1);
        System.out.println(listaClientes.listarClientes());
    }
}
