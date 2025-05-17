package projeto.pds2.alg2;

import java.util.ArrayList;

// Lista de Compras
public class GerenciamentoCompras {
    private final ArrayList<Compras> compras;

    public GerenciamentoCompras(){
        this.compras = new ArrayList<>();
    }

    public String adicionarCompra(Compras compra){
        this.compras.add(compra);
        return "Compra adicionada!";
    }

    public String removerCompra(Compras compra){
        this.compras.remove(compra);
        return "Compra removida!";
    }

    public String listarCompras(){
        for(Compras compra : compras){
            return compra.toString();
        }
        return "";
    }
}
