package classes;

public class CombSort {

    public void combSort(int[] vetor) {
        if (vetor == null || vetor.length <= 1) {
            return;
        }

        int gap = vetor.length;
        boolean trocou = true;

        while (gap > 1 || trocou) {
            gap = (int) (gap / 1.3);

            if (gap < 1) {
                gap = 1;
            }

            trocou = false;

            for (int i = 0; i + gap < vetor.length; i++) {
                if (vetor[i] > vetor[i + gap]) {
                    trocar(vetor, i, i + gap);
                    trocou = true;
                }
            }
        }
    }

    private void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
