package dao;

import model.Produto;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializacaoProduto {
    public static void main(String[] args) {

        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto("Laptop Pro X1", 7500.99, 15, "Eletrônicos"));
        listaProdutos.add(new Produto("Mouse Gamer Z100", 250.50, 50, "Acessórios"));
        listaProdutos.add(new Produto("Teclado Mecânico K55", 499.90, 30, "Acessórios"));
        listaProdutos.add(new Produto("Monitor LED 27\" QHD", 1890.00, 20, "Monitores"));
        listaProdutos.add(new Produto("SSD SuperFast 1TB", 650.00, 40, "Componentes"));
        listaProdutos.add(new Produto("Cadeira Office Confort", 899.00, 25, "Móveis"));
        listaProdutos.add(new Produto("Headset Hifi Pro", 320.00, 35, "Áudio"));
        listaProdutos.add(new Produto("Webcam HD Crystal", 180.75, 45, "Periféricos"));
        listaProdutos.add(new Produto("Placa de Vídeo UltraX", 4500.00, 10, "Componentes"));
        listaProdutos.add(new Produto("Impressora Multifuncional", 780.00, 18, "Periféricos"));

        String nomeArquivo = "produtos.ser"; // Nome do arquivo de serialização

        try (FileOutputStream fos = new FileOutputStream(nomeArquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(listaProdutos); // Salva a lista inteira
            System.out.println("Lista de produtos de exemplo salva em " + nomeArquivo);

            // Opcional: Imprimir para verificar os IDs gerados

            // System.out.println("Produtos gerados:");
            // for (Produto p : listaProdutos) {
            //     System.out.println(p);
            // }
            // System.out.println("Próximo ID de produto disponível (após geração): " + Produto.getProximoIdDisponivel());


        } catch (IOException e) {
            System.err.println("Erro ao salvar a lista de produtos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
