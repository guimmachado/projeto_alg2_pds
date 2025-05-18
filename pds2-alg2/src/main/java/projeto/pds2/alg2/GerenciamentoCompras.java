package projeto.pds2.alg2;

import java.util.ArrayList;

// Lista de Compras
public class GerenciamentoCompras {
    private final ArrayList<Carrinho> compras;

    public GerenciamentoCompras(){
        this.compras = new ArrayList<>();
    }

    public String adicionarCompra(Carrinho compra){
        this.compras.add(compra);
        return "Compra adicionada!";
    }

    public String removerCompra(Carrinho compra){
        this.compras.remove(compra);
        return "Compra removida!";
    }

    public String listarCompras(){
        for(Carrinho compra : compras){
            return compra.toString();
        }
        return "";
    }
}
