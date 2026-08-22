package classes;

public class InsertionSort {
    public void insertionSort(int[] vetor) {
        int tam = vetor.length;
        int aux;

        for (int p1 = 1; p1 < tam; p1++) {
            aux = vetor[p1];
            int j = p1 - 1;

            while (j >= 0 && vetor[j] > aux) {
                vetor[j + 1] = vetor[j]; 
                j--;
            }

            vetor[j + 1] = aux; 
        }
    }
}