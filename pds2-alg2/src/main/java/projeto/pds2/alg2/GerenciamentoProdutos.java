package projeto.pds2.alg2;

import java.util.ArrayList;

// Lista de Produtos
public class GerenciamentoProdutos {
    private ArrayList<Produto> produtos;

    public GerenciamentoProdutos(){
        this.produtos = new ArrayList<>();
    }

    public String adicionarProdutos(Produto produto){
        this.produtos.add(produto);
        return "Produto Adicionado!";
    }

    public String removerProdutos(Produto produto){
        this.produtos.remove(produto);
        return "Produto removido!";
    }

    public String listarProdutos(){
        for(Produto produto : produtos){
            return produto.toString();
        }
        return "";
    }
}
