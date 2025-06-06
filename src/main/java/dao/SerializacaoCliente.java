package dao;

import model.Cliente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoCliente {
    public static void main(String[] args) {
        // Criando a lista de clientes
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(new Cliente("Ana Silva", "Rua das Flores, 123, São Paulo", "10/05/1985"));
        listaClientes.add(new Cliente("Bruno Costa", "Avenida Principal, 456, Rio de Janeiro", "22/11/1990"));
        listaClientes.add(new Cliente("Carlos Dias", "Travessa das Palmeiras, 789, Belo Horizonte", "15/03/1978"));
        // Adicione os outros 7 clientes...
        listaClientes.add(new Cliente("Daniela Rocha", "Praça da Sé, 101, Salvador", "01/07/2000"));
        listaClientes.add(new Cliente("Eduardo Lima", "Rua dos Girassóis, 212, Curitiba", "30/09/1995"));
        listaClientes.add(new Cliente("Fernanda Alves", "Alameda dos Anjos, 313, Porto Alegre", "12/01/1982"));
        listaClientes.add(new Cliente("Gustavo Borges", "Rodovia Castelo Branco, km 50, Campinas", "05/06/1998"));
        listaClientes.add(new Cliente("Helena Martins", "Estrada Velha, 707, Recife", "25/12/1970"));
        listaClientes.add(new Cliente("Igor Santos", "Rua Nova, 808, Fortaleza", "18/08/1992"));
        listaClientes.add(new Cliente("Juliana Pereira", "Avenida Beira Mar, 909, Florianópolis", "09/04/1988"));


        String nomeArquivo = "clientes.ser"; // Ou .ser

        try (FileOutputStream fos = new FileOutputStream(nomeArquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(listaClientes); // Salva a lista inteira de uma vez
            System.out.println("Lista de clientes salva em " + nomeArquivo);

        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
