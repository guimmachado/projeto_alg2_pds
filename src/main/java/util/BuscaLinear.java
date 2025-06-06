package util;

import model.Produto;

import java.util.ArrayList;

public class BuscaLinear {
    public static int buscaLinear(ArrayList<Produto> lista, Produto elemento) {
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

}