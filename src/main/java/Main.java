import model.Cliente;
import model.Produto;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String arquivoClientes = "clientes.ser";
        List<Cliente> listaClientes = null;

        try (FileInputStream fisClientes = new FileInputStream(arquivoClientes);
             ObjectInputStream oisClientes = new ObjectInputStream(fisClientes)) {
            listaClientes = (ArrayList<Cliente>) oisClientes.readObject();
            System.out.println("Clientes carregados de " + arquivoClientes + ":");
            if (listaClientes != null && !listaClientes.isEmpty()) {
                for (Cliente cliente : listaClientes) {
                    System.out.println(cliente);
                }
                Cliente.ajustarContadorAposCarregamento(listaClientes); //
                System.out.println("Próximo ID de cliente disponível: " + Cliente.getProximoIdDisponivel()); //
            } else {
                System.out.println("Nenhum cliente carregado ou arquivo vazio.");
                listaClientes = new ArrayList<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            listaClientes = new ArrayList<>();
        }

        String arquivoProdutos = "produtos.ser";
        List<Produto> listaProdutos = null;

        try (FileInputStream fisProdutos = new FileInputStream(arquivoProdutos);
             ObjectInputStream oisProdutos = new ObjectInputStream(fisProdutos)) {

            listaProdutos = (ArrayList<Produto>) oisProdutos.readObject();
            System.out.println("\nProdutos carregados de " + arquivoProdutos + ":");
            if (listaProdutos != null && !listaProdutos.isEmpty()) {
                for (Produto produto : listaProdutos) {
                    System.out.println(produto);
                }
                Produto.ajustarContadorAposCarregamento(listaProdutos);
                System.out.println("Próximo ID de produto disponível: " + Produto.getProximoIdDisponivel());
            } else {
                System.out.println("Nenhum produto carregado ou arquivo vazio.");
                listaProdutos = new ArrayList<>();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar produtos: " + e.getMessage());

            listaProdutos = new ArrayList<>();
        }
        
        if (listaProdutos != null && !listaProdutos.isEmpty()) {
            System.out.println("\nExistem " + listaProdutos.size() + " produtos disponíveis.");
        }
        if (listaClientes != null && !listaClientes.isEmpty()) {
            System.out.println("Existem " + listaClientes.size() + " clientes cadastrados.");
        }
    }
}