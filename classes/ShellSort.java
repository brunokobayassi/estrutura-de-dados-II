package classes;

public class ShellSort {

    public void shellSort(int[] vetor) {
        int gap = vetor.length / 2;

        while (gap > 0) {

            for (int i = gap; i < vetor.length; i++) {

                int temp = vetor[i];

                int j = i;
                while (j >= gap && vetor[j - gap] > temp) {

                    vetor[j] = vetor[j - gap];

                    j = j - gap;
                }

                vetor[j] = temp;
            }

            gap = gap / 2;
        }
    }
}