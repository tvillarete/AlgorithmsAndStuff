import java.util.Random;

public class SortCounts {
   public static void main(String args[]) {
      int counts[] = new int[3];
      int count1 = 0, count2 = 0, count3 = 0;

      System.out.println("Running Times of Three Sorting Algorithms:");
      for (int N=100; N<=12800; N*=2) {
         for (int i=0; i<100; i++) {
            counts = runSorts(N);
         }
         count1 += counts[0];
         count2 += counts[1];
         count3 += counts[2];
         System.out.println();
      }

   }

   private static int[] runSorts(int N) {
      int len = 12800;
      Random rand = new Random();

      int arr1[] = new int[len];
      int arr2[] = new int[len];
      int arr3[] = new int[len];
      int ret[] = new int[3];

      int C_ss = 0, C_ms = 0, C_qs = 0;

      for (int i=0; i< len; i++) {
         int num = rand.nextInt(len);
         arr1[i] = num;
         arr2[i] = num;
         arr3[i] = num;
      }

      C_ss = Sorts1.selectionSort(arr1, N);
      C_ms = Sorts1.mergeSort(arr2, N);
      C_qs = Sorts1.quickSort(arr3, N-1);
      ret[0] = C_ss;
      ret[1] = C_ms;
      ret[2] = C_qs;
      return ret;
   }


   private static void print(int N, long C_ss, long C_ms, long C_qs) {
      System.out.println("N="+N+", C_ss="+C_ss+", C_ms="+C_ms+", C_qs="+C_qs);
   }
}
