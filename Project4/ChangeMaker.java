import java.util.Scanner;

public class ChangeMaker {
   public static void main(String args[]) {
      int numCoins;
      int[] coins;
      int n;
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the number of coins and the denomination: ");
      numCoins = s.nextInt();
      coins = new int[numCoins];
      for (int i=0; i<numCoins; i++) {
         coins[i] = s.nextInt();
      }
      System.out.println("Enter n: ");
      n = s.nextInt();
      if (n == 0) {
         System.exit(0);
      }
      int DPres[] = change_DP(n, coins);
      int GRres[] = change_greedy(n, coins);
      System.out.println("\nDP algorithm results");
      printRes(n,DPres,coins);
      System.out.println("\nGreedy algorithm results");
      printRes(n,GRres,coins);
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
      int[] coins = new int[d.length];
      int centsLeft = n;

      for (int i=0; i<d.length; i++) {
         int count = 0, numCoins = 0, total = 0;
         int prevNumCoins = numCoins;

         while (count <= centsLeft) {
            prevNumCoins = numCoins;
            count += d[i];
            numCoins++;
         }
         coins[i] = prevNumCoins;
         centsLeft -= (coins[i] * d[i]);
      }
      return coins;
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
