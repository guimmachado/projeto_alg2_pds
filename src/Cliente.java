public class Cliente {

//teste

    // atributos
    private int codCliente;
    private String nomeCliente;
    private String enderecoCliente;
    private String dataNascimento;
    private int nmrPedidos;

    // construtor
    public Cliente(int codCliente, String nomeCliente, String enderecoCliente, String dataNascimento) {
        this.codCliente = codCliente;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.dataNascimento = dataNascimento;
    }

    // getters e setters
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
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
