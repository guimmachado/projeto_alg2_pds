package util;

import model.Produto;

import java.util.ArrayList;

public class BuscaBinaria {
    public static int buscaLinear(ArrayList<Produto> lista, Produto elemento) {
        int esquerda = 0;
        int direita = lista.size() - 1;
        int codProd = elemento.getCodProd();

        while(esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int codProdMeio = lista.get(meio).getCodProd();

            if(codProdMeio == codProd) {
                return meio;
            } else if(codProdMeio < codProd) {
                esquerda = meio++;
            } else {
                direita = meio--;
            }
        }

        return -1;
    }
}