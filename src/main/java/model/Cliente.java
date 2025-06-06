package model;

import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {
    // Atributos
    private static final long serialVersionUID = 1L;
    private int codCliente;
    private static int contadorIdGlobal = 1; // Contador para gerar novos IDs
    private static int contador = 1;
    private String nomeCliente;
    private String enderecoCliente;
    private String dataNascimento;
    private int nmrPedidos;

    // Métodos

    // Método construtor
    public Cliente(String nomeCliente, String enderecoCliente, String dataNascimento) {
        this.codCliente = contadorIdGlobal++;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.dataNascimento = dataNascimento;

        if (codCliente >= contadorIdGlobal) {
            contadorIdGlobal = codCliente + 1;
        }
    }

    // Método que incrementa o número de pedidos em 1
    public void incrementarNmrPedidos() {
        this.nmrPedidos++;
    }

    // Getters e Setters
    public int getCodCliente() {
        return codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getNmrPedidos() {
        return nmrPedidos;
    }

    public void setNmrPedidos(int nmrPedidos) {
        this.nmrPedidos = nmrPedidos;
    }

    // toString()
    @Override
    public String toString() {
        return "Cliente{" +
                "codCliente=" + codCliente +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", enderecoCliente='" + enderecoCliente + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", nmrPedidos=" + nmrPedidos +
                '}';
    }

    public static void ajustarContadorAposCarregamento(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) return;
        int maxId = 0;
        for (Cliente c : clientes) {
            if (c.getCodCliente() > maxId) {
                maxId = c.getCodCliente();
            }
        }
        contadorIdGlobal = maxId + 1;
    }

    // Método para obter o próximo ID a ser usado, caso necessário externamente.
    public static int getProximoIdDisponivel() {
        return contadorIdGlobal;
    }
}