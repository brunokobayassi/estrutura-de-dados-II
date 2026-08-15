import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] vetor = new int[1000];

        // int[] vetor = {10, 5, 8, 2, 7, 1, 9, 3, 6, 4};

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(1000);
        }

        int tam = vetor.length;
        int aux;

        for (int p1 = 1; p1 < tam; p1++) {
            aux = vetor[p1];
            int j = p1 - 1;

            while (j >= 0 && vetor[j] > aux) {
                vetor[j + 1] = vetor[j]; // empurra
                j--;
            }

            vetor[j + 1] = aux; 
        }

        for (int v : vetor) {
            System.out.println(v);
        }
    }
}