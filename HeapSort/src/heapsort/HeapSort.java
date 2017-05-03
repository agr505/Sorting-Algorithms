package heapsort;

import java.util.Random;

/**
 *
 * @author Aaron
 */
public class HeapSort {

    public static int heapsize = 0;

    public static void main(String[] args) {

        int[][] C = creatematrix();

        timeevaluate(C);
    }

    public static void maxheapify(int[] A, int i) {

        int temp = 0;
        int largest = 0;

        int l = left(i);
        int r = right(i);

        if (l <= heapsize && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapsize && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            maxheapify(A, largest);
        }

    }

    public static int left(int i) {

        i = 2 * i;
        return i;
    }

    public static int right(int i) {
        i = 2 * i;
        return i + 1;
    }

    public static void buildmaxheap(int[] A) {

        for (int i = heapsize / 2; i >= 1; i--) {
            maxheapify(A, i);
        }

    }

    public static void heapsort(int[] A) {
        heapsize = A.length - 1;
        int temp;
        buildmaxheap(A);
        for (int i = A.length - 1; i >= 2; i--) {
            temp = A[1];

            A[1] = A[i];
            A[i] = temp;

            heapsize = heapsize - 1;
            maxheapify(A, 1);
        }
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
                heapsort(B);
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
