package classes;

public class BubbleSort {
    public void bubbleSort(int[] vetor) {
        int flag = 1;

        while (flag == 1) {
            flag = 0;
            for (int i = 0; i < (vetor.length - 1); i++) {
                if (vetor[i] > vetor[i + 1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    flag = 1;
                }
            }
        }
    }
}
