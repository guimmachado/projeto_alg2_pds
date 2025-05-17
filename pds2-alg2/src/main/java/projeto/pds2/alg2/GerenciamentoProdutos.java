package projeto.pds2.alg2;

import java.util.ArrayList;

// Lista de Produtos
public class GerenciamentoProdutos {
    private ArrayList<Produtos> produtos;

    public GerenciamentoProdutos(){
        this.produtos = new ArrayList<>();
    }

    public String adicionarProdutos(Produtos produto){
        this.produtos.add(produto);
        return "Produto Adicionado!";
    }

    public String removerProdutos(Produtos produto){
        this.produtos.remove(produto);
        return "Produto removido!";
    }

    public String listarProdutos(){
        for(Produtos produto : produtos){
            return produto.toString();
        }
        return "";
    }
}
