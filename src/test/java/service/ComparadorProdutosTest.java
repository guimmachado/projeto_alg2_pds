
package service;

import model.Produto;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class ComparadorProdutosTest {

    @Test
    void testComparatorPorQtdVendida() {
        Produto p1 = new Produto("A", 10, 10, "Cat");
        Produto p2 = new Produto("B", 20, 10, "Cat");
        Produto p3 = new Produto("C", 30, 10, "Cat");

        p1.incrementarVenda(2);
        p2.incrementarVenda(5);
        p3.incrementarVenda(1);

        ArrayList<Produto> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        Collections.sort(lista, ComparadorProdutos.porQtdVendida());

        assertEquals(p2, lista.get(0));
        assertEquals(p3, lista.get(2));
    }
}
