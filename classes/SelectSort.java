package classes;

public class SelectSort {
    public void selectSort(int[] vetor) {
        for (int p1 = 0; p1 < vetor.length - 1; p1++) {
            int posMenor = p1;

            for (int p2 = p1 + 1; p2 < vetor.length; p2++) {
                if (vetor[p2] < vetor[posMenor]) {
                    posMenor = p2;
                }
            }

            if (posMenor != p1) {
                int aux = vetor[p1];
                vetor[p1] = vetor[posMenor];
                vetor[posMenor] = aux;
            }
        }
    }
}
