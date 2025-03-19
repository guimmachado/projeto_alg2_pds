import java.io.FileWriter;
import java.io.IOException;

public class HistoricoProdutos { //ex-listaChavadaProdutos
    
    // atributos
    private No primeiroNo;
    private No ultimoNo;
    private int tamanho;

    // construtor
    public HistoricoProdutos() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    // métodos
    public boolean isEmpty() {
        return this.primeiroNo == null;
    }

    public void inserir(Produtos produto) {
        No novoNo = new No(produto);
        if (isEmpty()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = novoNo;
            System.out.println("Produto inserido" + produto.getNomeProd() +" com sucesso!");
        } else {
            this.ultimoNo.setProxNo(novoNo);
            novoNo.setAntNo(this.ultimoNo);
            this.ultimoNo = novoNo;
            System.out.println("Produto inserido" + produto.getNomeProd() +" com sucesso!");
        }
        this.tamanho++;
    }

    public void removerHistorico(Produtos produto) {
        No noAtual = this.primeiroNo;
        while (noAtual != null) {
            if (noAtual.getProdutos().getCodProd() == produto.getCodProd()) {
                if (noAtual == this.primeiroNo) {
                    this.primeiroNo = noAtual.getProxNo();
                    this.primeiroNo.setAntNo(null);
                    System.out.println("Produto removido" + produto.getNomeProd() +" com sucesso!");
                } else if (noAtual == this.ultimoNo) {
                    this.ultimoNo = noAtual.getAntNo();
                    this.ultimoNo.setProxNo(null);
                    System.out.println("Produto removido" + produto.getNomeProd() +" com sucesso!");
                } else {
                    noAtual.getAntNo().setProxNo(noAtual.getProxNo());
                    noAtual.getProxNo().setAntNo(noAtual.getAntNo());
                    System.out.println("Produto removido" + produto.getNomeProd() +" com sucesso!");
                }
                this.tamanho--;
                break;
            }
            noAtual = noAtual.getProxNo();
        }
    }

    public void imprimirHistorico() {
        No noAtual = this.primeiroNo;
        while (noAtual != null) {
            System.out.println(noAtual.getProdutos());
            noAtual = noAtual.getProxNo();
        }
    }

    public void exportarHistorico() throws IOException {
        try (FileWriter arquivo = new FileWriter("listaProdutos.txt")) {
            No noAtual = this.primeiroNo;
            while (noAtual != null) {
                arquivo.write(noAtual.getProdutos().toString() + "\n");
                noAtual = noAtual.getProxNo();
            }
        }
    }

    // getters e setters
    public int getTamanho() {
        return this.tamanho;
    }
}
