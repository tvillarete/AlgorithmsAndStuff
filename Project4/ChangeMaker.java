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
   }

   private static void printArr(int[] arr) {
      for (int i=0; i<arr.length; i++) {
         System.out.println(arr[i]);
      }
   }

   public static int[] change_DP(int n, int[] d) {
      int[] coins = new int[n];

      return coins;
   }
}
