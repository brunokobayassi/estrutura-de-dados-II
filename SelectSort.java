public class SelectSort {
    public static void main(String[] args) {
        int[] vetor = { 10, 5, 8, 2, 7 };
        int tam = vetor.length;

        for (int p1 = 0; p1 < (tam - 1); p1++) {
            for (int p2 = 1; p2 < tam; p2++) {

                int flag = 0;
                int back = p1;

                if (vetor[p1] < vetor[p2]) {
                    int aux = vetor[p1];
                    vetor[p1] = vetor[p2];
                    vetor[p2] = aux;
                }
            }
        }

        for (int i : vetor) {
            System.out.println(i);
        }
    }
}

/*
 * if (vetor[i] < vetor[i + 1]) {
 * int aux = vetor[i];
 * vetor[i] = vetor[i + 1];
 * vetor[i + 1] = aux;
 * flag = 1;
 * }
 */
