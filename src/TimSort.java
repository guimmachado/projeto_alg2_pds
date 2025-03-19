import java.util.*;

public class TimSort {

    private static final int TAMANHO_MIN_RUN = 32;

    // Função para ordenar uma ArrayList usando TimSort
    public static <T> void timSort(ArrayList<T> lista, Comparator<? super T> comparator) {

        // Passo 1: Ordenar sublistas com InsertionSort
        for(int inicio = 0; inicio < lista.size(); inicio += TAMANHO_MIN_RUN) {
            insertionSort(lista, inicio, Math.min((inicio + TAMANHO_MIN_RUN - 1), (lista.size() - 1)), comparator);
        }

        // Passo 2: Fusão (merge) dos subarrays ordenados
        for(int tamanhoRun = TAMANHO_MIN_RUN; tamanhoRun < lista.size(); tamanhoRun *= 2) {
            for(int esquerda = 0; esquerda < lista.size(); esquerda += 2 * tamanhoRun) {
                int meio = Math.min((lista.size() - 1), (esquerda + tamanhoRun - 1));
                int direita = Math.min((esquerda + 2 * tamanhoRun - 1), (lista.size() - 1));

                if(meio < direita) {
                    merge(lista, esquerda, meio, direita, comparator);
                }
            }
        }
    }

    // Função que implementa o Insertion Sort em uma ArrayList
    private static <T> void insertionSort(ArrayList<T> lista, int esquerda, int direita, Comparator<? super T> comparator) {
        for(int i = (esquerda + 1); i <= direita; i++) {
            T chave = lista.get(i);
            int j = i - 1;

            while(j >= esquerda && comparator.compare(lista.get(j), chave) > 0) {
                lista.set((j + 1), lista.get(j));
                j--;
            }
            lista.set((j + 1), chave);
        }
    }

    // Função que implementa a fusão (merge) de dois subarrays em uma ArrayList
    private static <T> void merge(ArrayList<T> lista, int esquerda, int meio, int direita, Comparator<? super T> comparator) {
    // Usando diretamente as expressões ao invés de variáveis intermediárias
      ArrayList<T> arrayEsquerdo = new ArrayList<>(lista.subList(esquerda, (meio + 1)));
      ArrayList<T> arrayDireito = new ArrayList<>(lista.subList((meio + 1), (direita + 1)));

      int contadorEsquerdo = 0, contadorDireito = 0, contador = esquerda;
      // Mescla as duas listas temporárias na lista original
      while (contadorEsquerdo < arrayEsquerdo.size() && contadorDireito < arrayDireito.size()) {
          if(comparator.compare(arrayEsquerdo.get(contadorEsquerdo), arrayDireito.get(contadorDireito)) <= 0) {
                lista.set(contador++, arrayEsquerdo.get(contadorEsquerdo++));
          } else {
                lista.set(contador++, arrayDireito.get(contadorDireito++));
          }
      }

      // Copiar os elementos restantes, se houver
      while(contadorEsquerdo < arrayEsquerdo.size()) {
          lista.set(contador++, arrayEsquerdo.get(contadorEsquerdo++));
      }

      while(contadorDireito < arrayDireito.size()) {
          lista.set(contador++, arrayDireito.get(contadorDireito++));
      }

    }

}
