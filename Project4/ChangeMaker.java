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
      int res[] = change_DP(n, coins);
      printArr(res);
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

   private static void printArr(int[] arr) {
      for (int i=0; i<arr.length; i++) {
         System.out.println(arr[i]);
      }
   }
}
