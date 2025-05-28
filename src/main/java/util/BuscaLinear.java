package util;

import model.Produto;

import java.util.ArrayList;

public class BuscaLinear {
    public static int buscaLinear(ArrayList<Produto> lista, Produto elemento) {
        for(int i = 0; i < lista.size(); i++) { // Itera sobre a lista
            if(lista.get(i).equals(elemento)) { // Compara item a item
                return i; // Retorna o índice caso encontre o elemento desejado
            }
        }
        return -1; // Retorno caso não encontre o elemento desejado
    }

}