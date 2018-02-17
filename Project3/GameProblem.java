/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 2/16/18
 * Project 3
 */

import java.io.*;
import java.util.Scanner;

public class GameProblem {
   public static void main(String[] args) {
      System.out.println("Please enter the input-file's name");
      Scanner s = new Scanner(System.in);
      String filename = s.next();
      Scanner file = new Scanner(System.in);
      try {
         file = new Scanner(new File(filename));
      }
      catch (Exception exc) {
         System.out.println("oOps\n");
      }
      int n = file.nextInt();
      int m = file.nextInt();
      int A[][] = new int[n][m];

      setupGame(file, n, m, A);
      game(n, m, A);
   }

   public static void game(int n, int m, int[][] A) {
      int S[][] = new int[n][m];
      char R[][] = new char[n][m];

      for (int i=0; i<n; i++) {
         for (int j=0; j<m; j++) {
            if (i == n-1 && j == m-1) {
                        // Exit
               R[i][j] = 'e';
            }
            else if (j == m-1) {
                             // Down     // Exit
               R[i][j] = A[i+1][m-1] >= 0 ? 'd' : 'e';
            }
            else if (i == n-1) {
                             // Right    // Exit
               R[i][j] = A[n-1][j+1] >= 0 ? 'r' : 'e';
            }
            else {
                             // Down     // Right
               R[i][j] = A[i+1][j] >= A[i][j+1] ? 'd' : 'r';
            }
         }
      }
      getBestScore(A, R, S);
      findMaxIndices(R, S);
   }

   private static int getBestScore(int[][] A, char[][] R, int[][] S) {
      for (int i=0; i<A.length; i++) {
         for (int j=0; j<A[0].length; j++) {
            S[i][j] = calculatePathSum(A, R, i, j);
         }
      }
      return 0;
   }

   private static int calculatePathSum(int[][] A, char[][] R, int i, int j) {
      int score = A[i][j];
      int m = i, n = j;

      while (R[m][n] != 'e') {
         switch (R[m][n]) {
            case 'd':
               m++;
               break;
            case 'r':
               n++;
               break;
         }
         score += A[m][n];
      }

      return score;
   }

   private static void findMaxIndices(char[][] R, int[][] S) {
      int max = 0;
      int m = 0, n = 0;
      for (int i=0; i<S.length; i++) {
         for (int j=0; j<S[0].length; j++) {
            if (S[i][j] > max) {
               max = S[i][j];
               m = i;
               n = j;
            }
         }
      }
      System.out.println("Best score: "+S[m][n]);
      printRoute(R, m, n);
   }

   private static void printRoute(char[][] R, int i, int j) {
      int m = i, n = j;
      System.out.print("Best route: ["+(m+1)+","+(n+1)+"] to ");
      while (R[m][n] != 'e') {
         switch (R[m][n]) {
            case 'd':
               m++;
               break;
            case 'r':
               n++;
               break;
         }
         System.out.print("["+(m+1)+","+(n+1)+"] to ");
      }
      System.out.println("exit");

   }

   private static void print2d(int arr[][]) {
      for (int i=0; i<arr.length; i++) {
         for (int j=0; j<arr[0].length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

   private static void print2d(char arr[][]) {
      for (int i=0; i<arr.length; i++) {
         for (int j=0; j<arr[0].length; j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

   private static void setupGame(Scanner file, int n, int m, int[][] A) {
      for (int i=0; i<n; i++) {
         for (int j=0; j<m; j++) {
            A[i][j] = file.nextInt();
         }
      }
   }

   private static void printArr(int[] arr) {
      int n = arr.length;
      for (int i=0;i<n;i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }

   private static int min(int a, int b) {
      return a < b ? a : b;
   }

   private static int max(int a, int b) {
      return a > b ? a : b;
   }


   private static void printBoard(int[][] A) {
      for (int i=0; i<A.length; i++) {
         for (int j=0; j<A[0].length; j++) {
            System.out.print(A[i][j] + " ");
         }
         System.out.println();
      }

   }
}
