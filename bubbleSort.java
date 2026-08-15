import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] vetor = new int[1000];

        // int[] vetor = {10, 5, 8, 2, 7, 1, 9, 3, 6, 4};

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(1000);
        }

        int flag = 1;

        while (flag == 1) {
            flag = 0;
            for (int i = 0; i < (vetor.length - 1); i++) {
                if (vetor[i] < vetor[i + 1]) {
                    int aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    flag = 1;
                }
            }
        }

        for (int i : vetor) {
            System.out.println(i);
        }
    }
}
