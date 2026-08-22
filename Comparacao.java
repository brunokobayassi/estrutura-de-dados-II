import classes.BubbleSort;
import classes.InsertionSort;
import classes.SelectSort;
import classes.ShellSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Comparacao {
    private static final int TAMANHO_VETOR = 1000;
    private static final int VALOR_MAXIMO = 1000;

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        InsertionSort insertionSort = new InsertionSort();
        SelectSort selectSort = new SelectSort();
        ShellSort shellSort = new ShellSort();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;

            do {
                exibirMenu();
                opcao = lerOpcao(scanner);

                switch (opcao) {
                    case 1:
                        compararAlgoritmos(bubbleSort, insertionSort, selectSort, shellSort);
                        break;
                    case 2:
                        executarAlgoritmo("Bubble Sort", bubbleSort::bubbleSort);
                        break;
                    case 3:
                        executarAlgoritmo("Insertion Sort", insertionSort::insertionSort);
                        break;
                    case 4:
                        executarAlgoritmo("Selection Sort", selectSort::selectSort);
                        break;
                    case 5:
                        executarAlgoritmo("Shell Sort", shellSort::shellSort);
                        break;
                    case 0:
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            } while (opcao != 0);
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Comparacao de Algoritmos ===");
        System.out.println("1 - Comparacao");
        System.out.println("2 - Bubble Sort");
        System.out.println("3 - Insertion Sort");
        System.out.println("4 - Selection Sort");
        System.out.println("5 - Shell Sort");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static int lerOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Digite uma opcao numerica.");
            scanner.next();
            System.out.print("Escolha uma opcao: ");
        }
        return scanner.nextInt();
    }

    private static void executarAlgoritmo(String nome, Ordenador ordenador) {
        int[] vetor = gerarVetor();
        long inicio = System.nanoTime();
        ordenador.ordenar(vetor);
        long fim = System.nanoTime();

        exibirResultado(nome, fim - inicio);
    }

    private static void compararAlgoritmos(BubbleSort bubbleSort,
            InsertionSort insertionSort, SelectSort selectSort, ShellSort shellSort) {
        int[] vetorOriginal = gerarVetor();
        Resultado[] resultados = {
            medir("Bubble Sort", bubbleSort::bubbleSort, vetorOriginal),
            medir("Insertion Sort", insertionSort::insertionSort, vetorOriginal),
            medir("Selection Sort", selectSort::selectSort, vetorOriginal),
            medir("Shell Sort", shellSort::shellSort, vetorOriginal)
        };
        Arrays.sort(resultados, Comparator.comparingLong(resultado -> resultado.tempoNanos));

        System.out.println("\nTempos para o mesmo vetor de " + TAMANHO_VETOR + " elementos:");
        for (Resultado resultado : resultados) {
            exibirResultado(resultado.nome, resultado.tempoNanos);
        }
    }

    private static Resultado medir(String nome, Ordenador ordenador, int[] vetorOriginal) {
        int[] vetor = Arrays.copyOf(vetorOriginal, vetorOriginal.length);
        long inicio = System.nanoTime();
        ordenador.ordenar(vetor);
        long fim = System.nanoTime();

        return new Resultado(nome, fim - inicio);
    }

    private static void exibirResultado(String nome, long tempoNanos) {
        double tempoMilissegundos = tempoNanos / 1_000_000.0;
        System.out.printf("%-18s: %.3f ms%n", nome, tempoMilissegundos);
    }

    private static int[] gerarVetor() {
        Random random = new Random();
        int[] vetor = new int[TAMANHO_VETOR];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(VALOR_MAXIMO);
        }

        return vetor;
    }

    @FunctionalInterface
    private interface Ordenador {
        void ordenar(int[] vetor);
    }

    private static class Resultado {
        private final String nome;
        private final long tempoNanos;

        private Resultado(String nome, long tempoNanos) {
            this.nome = nome;
            this.tempoNanos = tempoNanos;
        }
    }
}
