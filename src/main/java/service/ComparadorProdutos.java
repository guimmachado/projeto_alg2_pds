package service;

import model.Produto;

import java.util.Comparator;

public class ComparadorProdutos {

    // ordena por quantidade vendida
    public static Comparator<Produto> porQtdVendida(){
        return (p1, p2) -> Integer.compare(p2.getQtdVendida(), p1.getQtdVendida());
    }

}
