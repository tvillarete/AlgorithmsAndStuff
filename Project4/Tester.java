public class Tester {
   //130,72
   public static void main(String[] args) {
      int[] matches = new int[5];

      int[] set1 = {100,50,25,10,5,1};
      int[] set2 = {100,50,20,15,10,5,3,2,1};
      int[] set3 = {64,32,16,8,4,2,1};
      int[] set4 = {100,50,25,10,1};
      int[] set5 = {66,35,27,18,10,1};

      matches[0] = runTests(set1);
      matches[1] = runTests(set2);
      matches[2] = runTests(set3);
      matches[3] = runTests(set5);
      matches[4] = runTests(set5);
      printResults(matches);
   }

   private static int runTests(int[] d) {
      //returns # of matches as int
      int matches = 0;
      for (int i=1;i<=200;i++) {
         int temp1;
         int temp2;
         temp1 = getCount(ChangeMaker.change_DP(i,d));
         temp2 = getCount(ChangeMaker.change_greedy(i,d));
         if (temp1 == temp2)
            matches++;
      }
      return matches;
   }

   private static int getCount(int[] arr) {
      int count = 0;
      for (int i=0;i<arr.length;i++) {
         if (arr[i] != 0) {
            count += arr[i];
         }
      }
      return count;
   }

   private static void printResults(int[] matches) {
      System.out.println("Testing change_DP and change_greedy algorithms");
      for (int i=0;i<matches.length;i++) {
         System.out.println("Testing set" + (i+1) + ": " + matches[i] + " matches in 200 tests");
      }
   }
}
