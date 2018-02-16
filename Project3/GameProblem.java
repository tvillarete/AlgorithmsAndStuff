/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 2/2/18
 * Project 2
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
      System.out.println("n: "+n+" m: " +m);
      printBoard(A);
      game(n, m, A);
   }

   public static void game(int n, int m, int[][] A) {
      int S[][] = new int[n][m];

      // 𝑖𝑓𝑖=𝑛,𝑗=𝑚 (𝑡ℎ𝑖𝑠 𝑖𝑠 𝑡ℎ𝑒 𝑏𝑜𝑡𝑡𝑜𝑚−𝑟𝑖𝑔ℎ𝑡 𝑠𝑞𝑢𝑎𝑟𝑒: 𝑦𝑜𝑢 𝑐𝑎𝑛 𝑜𝑛𝑙𝑦 𝑒𝑥𝑖𝑡)
      // A[n, m]
      //
      // 𝑖𝑓 𝑗=𝑚 (𝑡ℎ𝑖𝑠 𝑖𝑠 𝑡ℎ𝑒 𝑙𝑎𝑠𝑡 𝑐𝑜𝑙𝑢𝑚𝑛: 𝑚𝑜𝑣𝑒 𝑑𝑜𝑤𝑛 𝑜𝑟 𝑒𝑥𝑖𝑡)
      // max{S[i+1, m], 0} + A[i, m]
      //
      // 𝑖𝑓 𝑖=𝑛 (𝑡ℎ𝑖𝑠 𝑖𝑠 𝑡ℎ𝑒 𝑙𝑎𝑠𝑡 𝑟𝑜𝑤: 𝑚𝑜𝑣𝑒 𝑟𝑖𝑔ℎ𝑡 𝑜𝑟 𝑒𝑥𝑖𝑡)
      // max{S[n, j+1], 0} + A[n, j]
      //
      // 𝑜𝑡ℎ𝑒𝑟𝑤𝑖𝑠𝑒 (𝑐ℎ𝑒𝑐𝑘 𝑡ℎ𝑒 𝑏𝑒𝑡𝑡𝑒𝑟: 𝑚𝑜𝑣𝑒 𝑑𝑜𝑤𝑛 𝑜𝑟 𝑟𝑖𝑔ℎ𝑡)
      // max{S[i+1, j], S[i, j+1]} + A[i, j]
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

   private static void printBoard(int[][] A) {
      for (int i=0; i<A.length; i++) {
         for (int j=0; j<A[0].length; j++) {
            System.out.print(A[i][j] + " ");
         }
         System.out.println();
      }

   }
}
