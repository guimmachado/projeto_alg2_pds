package util;

import model.Produto;

import java.util.ArrayList;

public class BuscaBinaria {
    public static int buscaLinear(ArrayList<Produto> lista, Produto elemento) {
        int esquerda = 0;
        int direita = lista.size() - 1;
        int codProd = elemento.getCodProd(); // ID do produto

        while(esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2; // Índice do produto
            int codProdMeio = lista.get(meio).getCodProd(); // ID do produto do meio

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