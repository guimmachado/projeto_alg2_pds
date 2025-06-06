
package util;

import model.Produto;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BuscaLinearTest {

    @Test
    void testBuscaLinear() {
        ArrayList<Produto> lista = new ArrayList<>();
        Produto p1 = new Produto("A", 10, 1, "Cat");
        Produto p2 = new Produto("B", 20, 1, "Cat");
        Produto p3 = new Produto("C", 30, 1, "Cat");
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        assertEquals(1, BuscaLinear.buscaLinear(lista, p2));
        assertEquals(-1, BuscaLinear.buscaLinear(lista, new Produto("X", 5, 1, "Cat")));
    }
}
