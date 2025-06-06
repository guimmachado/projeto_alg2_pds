
package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    void testConstructorAndGetters() {
        Cliente c = new Cliente("Gabriel", "Rua A, 100", "10/10/2000");
        assertAll(
            () -> assertEquals("Gabriel", c.getNomeCliente()),
            () -> assertEquals("Rua A, 100", c.getEnderecoCliente()),
            () -> assertEquals("10/10/2000", c.getDataNascimento())
        );
    }

    @Test
    void testIncrementarNumeroPedidos() {
        Cliente c = new Cliente("Maria", "Av. B, 200", "05/05/1995");
        c.incrementarNmrPedidos();
        c.incrementarNmrPedidos();
        assertEquals(2, c.getNmrPedidos());
    }
}
