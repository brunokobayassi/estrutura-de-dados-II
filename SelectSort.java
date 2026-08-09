import java.util.Random;

public class SelectSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] vetor = new int[1000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(1000);
        }

        for (int p1 = 0; p1 < vetor.length - 1; p1++) {
            int posMaior = p1;
            int flag = 0;

            for (int p2 = p1 + 1; p2 < vetor.length; p2++) {
                if (vetor[p2] > vetor[posMaior]) {
                    posMaior = p2;
                    flag = 1;
                }
            }

            if (flag == 1) {
                int aux = vetor[p1];
                vetor[p1] = vetor[posMaior];
                vetor[posMaior] = aux;
            }
        }

        for (int i : vetor) {
            System.out.println(i);
        }
    }
}
