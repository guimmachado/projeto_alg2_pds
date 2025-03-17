import java.util.ArrayList;
import java.util.Arrays;

public class SCRUM6 {
    // Como lojista, quero visualizar um ranking dos produtos mais vendidos.
    public static void main(String[] args) {
        ArrayList<Produtos> produtos = new ArrayList<>(Arrays.asList(
            new Produtos("Belly", 1200, 1, "Animal"),
            new Produtos("Celular", 3500, 200, "Eletrônico"),
            new Produtos("Pulseira", 200, 1000, "Bijuteria")
        ));

        System.out.println("Lista pré ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }

        TimSort.timSort(produtos, (p1, p2) -> Integer.compare(p1.getQtdVendida(), p2.getQtdVendida())); // Para o Comparator, utilizar métodos lambda

        System.out.println("Lista após ordenação: ");
        for(Produtos p : produtos) {
            System.out.println(p);
        }
    }
}
