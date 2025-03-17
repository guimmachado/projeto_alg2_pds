import java.util.ArrayList;

// Lista de Clientes
public class GerenciamentoClientes {
    private ArrayList<Cliente> clientes;

    public GerenciamentoClientes(){
        this.clientes = new ArrayList<>();
    }

    public String adicionarCliente(Cliente cliente){
        this.clientes.add(cliente);
        return "Cliente adicionado!";
    }

    public String removerCliente(Cliente cliente){
        this.clientes.remove(cliente);
        return "Cliente removido!";
    }

    public String listarClientes(){
        for(Cliente cliente : clientes){
            return cliente.toString();
        }
        return "";
    }
}
