
package model;

import org.junit.Test;
import util.TabelaHash;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CarrinhoTest {

    @Test
    public void testCalcularValorTotal() {
        // Arrange
        Cliente cliente = new Cliente("Carlos", "Rua Teste, 123", "12/12/1990");
        TabelaHash tabela = new TabelaHash(10);
        Produto p1 = new Produto("Produto 1", 10.0, 100, "Cat");
        Produto p2 = new Produto("Produto 2", 5.0, 100, "Cat");
        tabela.adicionar(p1, 3); // 30.0
        tabela.adicionar(p2, 4); // 20.0

        Carrinho carrinho = new Carrinho(cliente, tabela);
        assertEquals(50.0, carrinho.calcularValorTotal(), 0.0001);
    }

    @Test
    public void testSetDataCompra() {
        Cliente cliente = new Cliente("Ana", "Av Teste, 500", "01/01/2000");
        TabelaHash tabela = new TabelaHash(5);
        Produto p = new Produto("X", 2.0, 10, "Cat");
        tabela.adicionar(p, 1);

        Carrinho carrinho = new Carrinho(cliente, tabela);
        LocalDateTime now = LocalDateTime.now();
        carrinho.setDataCompra(now);
        assertEquals(now, carrinho.getDataCompra());
    }

    @Test
    public void testConstructorValidation() {
        Cliente cliente = new Cliente("Erro", "Rua", "01/01/2000");
        TabelaHash tabelaVazia = new TabelaHash(5);
        assertThrows(IllegalArgumentException.class, () -> {
            new Carrinho(cliente, tabelaVazia);
        });
    }
}
