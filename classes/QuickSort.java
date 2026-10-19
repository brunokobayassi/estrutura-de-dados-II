package classes;

public class QuickSort {

    public void quickSort(int[] vetor) {
        quickSort(vetor, 0, vetor.length - 1);
    }

    private void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particionar(vetor, inicio, fim);

            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private int particionar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[fim]; 
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (vetor[j] <= pivo) {
                i++;
                trocar(vetor, i, j);
            }
        }

        trocar(vetor, i + 1, fim);

        return i + 1;
    }

    private void trocar(int[] vetor, int a, int b) {
        int temp = vetor[a];
        vetor[a] = vetor[b];
        vetor[b] = temp;
    }
}