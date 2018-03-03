/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 3/2/18
 * Project 4
 */

import java.util.Scanner;

public class ChangeMaker {
   public static void main(String args[]) {
      int numCoins;
      int[] coins;
      int n;
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the number of coin-denominations and the set of coin values:");
      numCoins = s.nextInt();
      coins = new int[numCoins];
      for (int i=0; i<numCoins; i++) {
         coins[i] = s.nextInt();
      }
      System.out.println("\nEnter a positive amount to be changed (enter 0 to quit): ");
      n = s.nextInt();
      while (n != 0) {
         if (n < 0) {
            System.out.println("You entered a negative number.");
         } else {
            int DPres[] = change_DP(n, coins);
            int GRres[] = change_greedy(n, coins);
            System.out.println("\nDP algorithm results");
            printRes(n,DPres,coins);
            System.out.println("\nGreedy algorithm results");
            printRes(n,GRres,coins);
            System.out.println("\nEnter a positive amount to be changed (enter 0 to quit): ");
            n = s.nextInt();
         }
      }
      System.out.println("Thanks for playing. Good Bye.");
   }

   private static void printRes(int n,int[] res,int[] d) {
      int count=0;
      System.out.println("Amount: " + n);
      System.out.print("Optimal distribution: ");
      for (int i=0; i < res.length;i++) {
         if (res[i] != 0) {
            if (count != 0) {
               System.out.print(" + ");
            }
            System.out.print(res[i]+"*"+d[i]+"c");
            count += res[i];
         }
      }
      System.out.println("\nOptimal coin count: " + count);
   }

   public static int[] change_DP(int n, int[] d) {
      int[] coins = new int[n+1], table = new int[n+1], solution = new int[d.length];
      // Base case
      coins[0] = 0;
      // Iterate through possibilities
      for (int i=1; i<n+1; i++) {
         int j = 0;
         while (d[j] > i)
            j++;
         int min = coins[i - d[j]];
         table[i] = j;
         for (int l=j+1; l<d.length; l++) {
            if (min > coins[i-d[l]]) {
               min = coins[i- d[l]];
               table[i] = l;
            }
         }
         coins[i] = min + 1;
      }

      int count = coins[n], temp = 0, tableSpot = n;
      while (count-- > 0) {
         temp=table[tableSpot];
         solution[temp]++;
         tableSpot = tableSpot-d[temp];
      }
      return solution;
   }

   public static int[] change_greedy(int n, int[] d) {
      int remaining = n, choice = -1, spot = 0, numCoins = 0;
      int prevChoice = -1;
      int prevDenom = -1;
      int[] coins = new int[d.length];

      while (remaining > 0 && spot < d.length) {
         for (int i=0; i<d.length; i++) {
            while (d[i] <= remaining) {
               numCoins++;
               remaining -= d[i];
            }
            coins[i] = numCoins;
            numCoins = 0;
         }
      }
      return coins;
   }

   private static void printArr(int[] arr) {
      for (int i=0; i<arr.length; i++) {
         System.out.println(arr[i]);
      }
   }
}
