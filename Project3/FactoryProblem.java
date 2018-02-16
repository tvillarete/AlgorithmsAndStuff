/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 2/2/18
 * Project 2
 */

import java.io.*;
import java.util.Scanner;

public class FactoryProblem {
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
      int[] e = new int[2];
      int[] x = new int[2];
      int[] a1 = new int[n];
      int[] a2 = new int[n];
      int[] t1 = new int[n];
      int[] t2 = new int[n];
      setupAssemblyLine(file, n, e, x, a1, a2, t1, t2);

      int T1[] = new int[n];
      int T2[] = new int[n];

      T1[0] = e[0] + a1[0];
      T2[0] = e[1] + a2[0];

      for (int i=1; i<n; ++i) {
         T1[i] = min(T1[i-1] + a1[i], T2[i-1] + t2[i] + a1[i]);
         T2[i] = min(T2[i-1] + a2[i], T1[i-1] + t1[i] + a2[i]);
      }

      int fastestTime = min(T1[n-1] + x[0], T2[n-1] + x[1]);
      System.out.println("Fastest time: "+ fastestTime);
      //printStation(station);
   }

   private static int min(int a, int b) {
      return a < b ? a : b;
   }

   private static void printStation(int[] arr) {
      for (int i=0;i<arr.length;i++) {
         System.out.println("station " + (i+1) + ", line " + arr[i]);
      }
   }

   private static void setupAssemblyLine(Scanner file, int n, int[] e, int[] x, int[] a1, int[] a2, int[] t1, int[] t2) {
      for (int i=0;i<2;i++) {
         e[i] = file.nextInt();
      }

      for (int i=0;i<2;i++) {
         x[i] = file.nextInt();
      }

      for (int i=0;i<n;i++) {
         a1[i] = file.nextInt();
      }

      for (int i=0;i<n;i++) {
         a2[i] = file.nextInt();
      }

      t1[0] = 0;
      for (int i=1;i<n;i++) {
         t1[i] = file.nextInt();
      }

      t2[0] = 0;
      for (int i=1;i<n;i++) {
         t2[i] = file.nextInt();
      }
   }

   private static void printArr(int[] arr) {
      int n = arr.length;
      for (int i=0;i<n;i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}
