package quicksort;

import java.util.Random;

/**
 *
 * @author Aaron
 */
public class QuickSort {

    public static void main(String[] args) {

        int[][] C = creatematrix();
        timeevaluate(C);
    }

    public static void quicksort(int[] A, int p, int r) {
        int q = 0;
        if (p < r) {
            q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }
    }

    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        int temp;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i = i + 1;
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

        }
        temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;

    }

    public static int[][] creatematrix() {
        int maximum = 1000;
        int minimum = 1;

        Random rand;

        int A[][] = new int[11][30000];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 20000; j++) {

                rand = new Random();
                A[i][j] = minimum + rand.nextInt((maximum - minimum) + 1);
            }
        }
        return A;

    }

    public static void timeevaluate(int[][] A) {
        int ns = 1000;
        int n = 0;
        int delta = 1000;
        int nf = 20000;
        int m = 10;
        long[][] t = new long[11][30000];
        int[] B = new int[100000];
        long startTime = 0;
        long finishTime = 0;
        long[] ave = new long[21];

        for (n = ns; n <= nf; n = n + delta) {
            for (int i = 1; i <= m; i++) {
                for (int k = 0; k <= n; k++) {
                    B[k] = A[i][k];

                }

                startTime = System.nanoTime() / 1000;
                quicksort(B, 0, n);
                finishTime = System.nanoTime() / 1000;
                t[i][n / 1000] = finishTime - startTime;

            }

        }
        long sum = 0;
        for (n = ns; n <= nf; n = n + delta) {

            sum = t[1][n / 1000] + t[2][n / 1000] + t[3][n / 1000] + t[4][n / 1000] + t[5][n / 1000] + t[6][n / 1000] + t[7][n / 1000] + t[8][n / 1000] + t[9][n / 1000] + t[10][n / 1000];
            ave[n / 1000] = sum / 10;
            System.out.println(ave[n / 1000]);
        }
    }
}
