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
      System.out.println("Reading from " + filename);
      int n = file.nextInt();
      int[] e = new int[2];
      int[] x = new int[2];
      int[] a1 = new int[n];
      int[] a2 = new int[n];
      int[] t1 = new int[n-1];
      int[] t2 = new int[n-1];

      System.out.println("n is " + n);
      for (int i=0;i<2;i++) {
         e[i] = file.nextInt();
      }
      System.out.println("E array: ");
      printArr(e);

      for (int i=0;i<2;i++) {
         x[i] = file.nextInt();
      }
      System.out.println("X array: ");
      printArr(x);

      for (int i=0;i<n;i++) {
         a1[i] = file.nextInt();
      }
      System.out.println("======a1=======");
      printArr(a1);

      for (int i=0;i<n;i++) {
         a2[i] = file.nextInt();
      }
      System.out.println("======a2=======");
      printArr(a2);

      for (int i=0;i<n-1;i++) {
         t1[i] = file.nextInt();
      }
      System.out.println("======t1=======");
      printArr(t1);

      for (int i=0;i<n-1;i++) {
         t2[i] = file.nextInt();
      }
      System.out.println("======t2=======");
      printArr(t2);
   }

   private static void printArr(int[] arr) {
      int n = arr.length;
      for (int i=0;i<n;i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}
