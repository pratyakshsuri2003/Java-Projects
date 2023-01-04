import java.util.*;
import java.util.Collection;

public class matrix_multiplicatio {
    public static void main(String[] args) {
        // creating two matrices
        // random number generator
        Random r = new Random();
        int n = 0;
        // int n = 0;
        for (int i = 0; i <= 100; i++) {
            n += 100;
            System.out.print("Value of n is: "+n+'\n');
            int a[][] = new int[n][n];
            int b[][] = new int[n][n];
            // int c[][] = new int[n][n];
            for (int f = 0; f < n; f++) {
                for (int j = 0; j < n; j++) {
                    a[f][j] = r.nextInt();
                }
            }
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    b[k][l] = r.nextInt();
                }
            }
            // Mutliplying Two matrices
            double start = System.nanoTime(); 
            int[][] product = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    for (int z = 0; z < n; z++) {
                        product[x][y] += a[x][z] * b[z][y];
                    }
                }
            }
            double end = System.nanoTime();
            double execution = (end - start)/1000000;
            System.out.println("Matrix on "+ n + '*' + n + " = " + execution + " ms");
        }
    }
}
