package projeto.pds2.alg2;

public class Cliente {
    // Atributos
    private int codCliente;
    private static int contador = 1;
    private String nomeCliente;
    private String enderecoCliente;
    private String dataNascimento;
    private int nmrPedidos;

    // Métodos

    // Método construtor
    public Cliente(String nomeCliente, String enderecoCliente, String dataNascimento) {
        this.codCliente = contador++;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.dataNascimento = dataNascimento;
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
}
