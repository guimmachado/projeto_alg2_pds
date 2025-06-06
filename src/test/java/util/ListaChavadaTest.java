
package util;

import model.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaChavadaTest {

    @Test
    void testInserirRemoverTamanho() {
        ListaChavada lista = new ListaChavada();
        assertEquals(0, lista.getTamanho());

        Produto p1 = new Produto("Item 1", 10, 1, "Cat");
        Produto p2 = new Produto("Item 2", 20, 1, "Cat");

        lista.inserir(p1);
        lista.inserir(p2);
        assertEquals(2, lista.getTamanho());

        lista.remover(p1);
        assertEquals(1, lista.getTamanho());

        lista.remover(p2);
        assertEquals(0, lista.getTamanho());
    }
}
