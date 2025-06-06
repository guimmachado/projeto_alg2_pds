
package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void testConstructorAndGetters() {
        Produto p = new Produto("Mouse Gamer", 150.0, 20, "Periféricos");
        assertAll(
            () -> assertEquals("Mouse Gamer", p.getNomeProd()),
            () -> assertEquals(150.0, p.getPrecoProd()),
            () -> assertEquals(20, p.getQtdProd()),
            () -> assertEquals("Periféricos", p.getCategoriaProd())
        );
    }

    @Test
    void testIncrementarVendaEAcessos() {
        Produto p = new Produto("Teclado", 100.0, 50, "Periféricos");
        p.incrementarVenda(5);
        assertAll(
            () -> assertEquals(5, p.getQtdVendida()),
            () -> assertEquals(45, p.getQtdProd()),
            () -> assertEquals(1, p.getQtdAcessos())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        Produto p1 = new Produto("Cadeira", 700.0, 5, "Mobiliário");
        Produto p2 = new Produto(p1.getCodProd(), "Cadeira", 700.0, 5, "Mobiliário", 0, 0);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}
