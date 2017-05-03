package insertionsort;

import java.util.Random;

/**
 *
 * @author Aaron
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[][] C = creatematrix();
        timeevaluate(C);

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
                insertionsort(B, n);
                finishTime = System.nanoTime() / 1000;
                t[i][n / 1000] = finishTime - startTime;

            }

        }
        long sum = 0;
        for (int q = 1; q <= 20; q++) {

            sum = t[1][q] + t[2][q] + t[3][q] + t[4][q] + t[5][q] + t[6][q] + t[7][q] + t[8][q] + t[9][q] + t[10][q];
            ave[q] = sum / 10;

            System.out.println(ave[q]);
        }
    }

    public static void insertionsort(int[] A, int n) {
        int key = 0;
        int i = 0;

        for (int j = 2; j < n; j++) {
            key = A[j];
            i = j - 1;

            while (i > 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;

            }
            A[i + 1] = key;

        }

    }

}
