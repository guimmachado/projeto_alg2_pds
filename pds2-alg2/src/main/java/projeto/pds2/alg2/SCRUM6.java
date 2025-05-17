package projeto.pds2.alg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SCRUM6 {
    // Como lojista, quero visualizar um ranking dos produtos mais vendidos.
    public static void main(String[] args) {
        // TC001 - Realizar de fato a ordenação por quantidade de produtos mais vendidos.
        System.out.println("TC001 - Realizar de fato a ordenação por quantidade de produtos mais vendidos.");

        // - PREPARAÇÃO

       // Lista de produtos 
        ArrayList<Produtos> produtos = new ArrayList<>(Arrays.asList(
            new Produtos("Belly", 1200, 1, "Animal"),
            new Produtos("Celular", 3500, 200, "Eletrônico"),
            new Produtos("Pulseira", 200, 1000, "Bijuteria")
        ));

        // Lista de clientes
        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("Caio", "Rua X", "1992-08-24"),
            new Cliente("Guilherme", "Rua Y", "1987-05-14"),
            new Cliente("Gabriel", "Rua Z", "2001-04-19")
        ));

        // Lista pré ordenação
        System.out.println("Lista pré ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

        // Criando HashMap com produtos e suas quantidades
        // Cliente 1
        HashMap<Produtos, Integer> produtosComprados1 = new HashMap<>();
        produtosComprados1.put(produtos.get(0), 1);
        produtosComprados1.put(produtos.get(1), 2);

        // Cliente 2
        HashMap<Produtos, Integer> produtosComprados2 = new HashMap<>();
        produtosComprados2.put(produtos.get(1), 1);
        produtosComprados2.put(produtos.get(2), 1);

        // Cliente 3
        HashMap<Produtos, Integer> produtosComprados3 = new HashMap<>();
        produtosComprados3.put(produtos.get(2), 3);
    

        // Realizando as compras
        Compras c1 = new Compras(clientes.get(0), produtosComprados1);
        Compras c2 = new Compras(clientes.get(1), produtosComprados2);
        Compras c3 = new Compras(clientes.get(2), produtosComprados3);

        // - AÇÃO

        TimSort.timSort(produtos, (p1, p2) -> Integer.compare(p1.getQtdVendida(), p2.getQtdVendida())); // Para o Comparator, utilizar métodos lambda

        // - RESULTADO

        System.out.println("Lista após ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

        // - ESPERADO X REALIZADO

        // - Esperado
        // Ordenar

        // - Realizado
        // Ordenar

        // - CONCLUSÃO
        // Teste OK
        System.out.println("Teste OK");



        // TC002 - Verificar se o ranking está de acordo.
        System.out.println("TC002 - Verificar se o ranking está de acordo.");

        // - PREPARAÇÃO
        // As mesmas que o TC001
        // Como já está preparado, pularei essa parte, exceto apenas pelo trecho abaixo

        // Lista pré ordenação
        System.out.println("Lista pré ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

        // - AÇÃO

        TimSort.timSort(produtos, (p1, p2) -> Integer.compare(p1.getQtdVendida(), p2.getQtdVendida())); // Para o Comparator, utilizar métodos lambda

        // - RESULTADO

        System.out.println("Lista após ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

         // - ESPERADO X REALIZADO

        // - Esperado
        // Ordenar em ordem decrescente

        // - Realizado
        // Ordenar em ordem crescente

        // - CONCLUSÃO
        // Teste não OK - Corrigir
        System.out.println("Teste não OK - Corrigir");

        // - CORREÇÃO
        // Invertida a ordem de comparação
        //TimSort.timSort(produtos, (p1, p2) -> Integer.compare(p2.getQtdVendida(), p1.getQtdVendida())); // Para o Comparator, utilizar métodos lambda

        // - AÇÃO (Novamente)
        TimSort.timSort(produtos, (p1, p2) -> Integer.compare(p2.getQtdVendida(), p1.getQtdVendida())); // Para o Comparator, utilizar métodos lambda

        // - RESULTADO

        System.out.println("Lista após ordenação DECRESCENTE: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

         // - ESPERADO X REALIZADO

        // - Esperado
        // Ordenar em ordem decrescente

        // - Realizado
        // Ordenar em ordem descrescente

        // - CONCLUSÃO
        // Teste OK
        System.out.println("Teste OK");



        // TC003 - Verificar se é possível ordenar por outro parâmetro desejado.
        System.out.println("TC003 - Verificar se é possível ordenar por outro parâmetro desejado.");

        // - PREPARAÇÃO
        // As mesmas que o TC001
        // Como já está preparado, pularei essa parte, exceto apenas pelo trecho abaixo

        // Lista pré ordenação
        System.out.println("Lista pré ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

        // Como eu quero ordenar utilizando diferentes parâmetros, necessito trocar o Comparator (segundo argumento da função)
        // Atualmente ele está da seguinte forma:
        // (p1, p2) -> Integer.compare(p2.getQtdVendida(), p1.getQtdVendida())
        // Assim, ele ordena pela quantidade vendida.
        // Para ordenar por nome, preço ou quantidade em estoque, ficará das seguintes maneiras:
        // NOME - (p1, p2) -> p1.getNomeProd().compareTo(p2.getNomeProd()) (crescente)
        // PREÇO - (p1, p2) -> Double.compare(p2.getPrecoProd(), p1.getPrecoProd()) (decrescente)
        // QUANTIDADE EM ESTOQUE - (p1, p2) -> Integer.compare(p2.getQtdProd(), p1.getQtdProd()) (decrescente)

        // - AÇÃO

        // Ordenando por nome
        TimSort.timSort(produtos, (p1, p2) -> p1.getNomeProd().compareTo(p2.getNomeProd())); // Para o Comparator, utilizar métodos lambda

        System.out.println("Lista após ordenação por NOME (CRESCENTE): ");
        for(Produtos p : produtos) {
            System.out.println(p);
            System.out.println("Quantidade em estoque: " + p.getQtdProd());
        }

        // Ordenando por preço
        TimSort.timSort(produtos, (p1, p2) -> Double.compare(p2.getPrecoProd(), p1.getPrecoProd())); // Para o Comparator, utilizar métodos lambda

        System.out.println("Lista após ordenação por PREÇO (DECRESCENTE): ");
        for(Produtos p : produtos) {
            System.out.println(p);
            System.out.println("Quantidade em estoque: " + p.getQtdProd());
        }

        // Ordenando por quantidade em estoque
        TimSort.timSort(produtos, (p1, p2) -> Integer.compare(p2.getQtdProd(), p1.getQtdProd())); // Para o Comparator, utilizar métodos lambda

        System.out.println("Lista após ordenação por QUANTIDADE EM ESTOQUE (DECRESCENTE): ");
        for(Produtos p : produtos) {
            System.out.println(p);
            System.out.println("Quantidade em estoque: " + p.getQtdProd());
        }

        // - RESULTADO
        // Mostrados acima

        // - ESPERADO X REALIZADO

        // - Esperado
        // Ordenar por diferentes parâmetros.
        // No caso, foram escolhido 3: nome, preço e quantidade em estoque

        // - Realizado
        // Ordenar por diferentes parâmetros.
        // No caso, foram escolhido 3: nome, preço e quantidade em estoque

        // - CONCLUSÃO
        // Teste OK
        System.out.println("Teste OK");
        // OBS: é possível trocar o parâmetro de comparação, porém é necessário modificar o código,
        // ou seja, é necessário fazer um Comparator para cada caso específico.
        // Isso acaba sendo mais fácil do que fazer um método de ordenação para cada parâmetro,
        // visto que para comparar por outros métodos, é necessário somente mudar um argumento da função de ordenação

    }
}
