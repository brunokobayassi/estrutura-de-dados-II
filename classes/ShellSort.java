package classes;
import java.util.Random;

public class ShellSort {

    public void shellSort() {

        int[] vetor = { 4, 5, 6, 2, 3, 1 };

        /*
         * Random rand = new Random();
         * int[] vetor = new int[1000];
         * 
         * for (int i = 0; i < vetor.length; i++) {
         * vetor[i] = rand.nextInt(1000);
         * }
         */

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

        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}