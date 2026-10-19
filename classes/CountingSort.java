
package classes;

public class CountingSort {

    public void countingSort(int[] vetor) {
        if (vetor == null || vetor.length <= 1) {
            return;
        }

        int minimo = vetor[0];
        int maximo = vetor[0];

        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < minimo) {
                minimo = vetor[i];
            }

            if (vetor[i] > maximo) {
                maximo = vetor[i];
            }
        }

        int[] contagem = new int[maximo - minimo + 1];

        for (int i = 0; i < vetor.length; i++) {
            contagem[vetor[i] - minimo]++;
        }

        int indice = 0;

        for (int i = 0; i < contagem.length; i++) {
            while (contagem[i] > 0) {
                vetor[indice] = i + minimo;
                indice++;
                contagem[i]--;
            }
        }
    }
}
