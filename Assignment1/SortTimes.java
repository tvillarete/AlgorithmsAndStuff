import java.util.Random;

public class SortTimes {
   public static void main(String args[]) {
      System.out.println("Running Times of Three Sorting Algorithms:");
      for (int N=5000; N<=160000; N*=2) {
         for (int i=0; i<5; i++) {
            runSorts(N);
         }
         System.out.println();
      }
   }

   private static void runSorts(int N) {
      int len = 160000;
      Random rand = new Random();

      int arr1[] = new int[160000];
      int arr2[] = new int[160000];
      int arr3[] = new int[160000];

      long start = 0;
      long end = 0;
      long T_ss = 0, T_ms = 0, T_qs = 0;

      for (int i=0; i< len; i++) {
         int num = rand.nextInt(len);
         arr1[i] = num;
         arr2[i] = num;
         arr3[i] = num;
      }

      start = System.nanoTime();
      Sorts.selectionSort(arr1, N);
      end = System.nanoTime();
      T_ss = (end-start)/1000000;

      start = System.nanoTime();
      Sorts.mergeSort(arr2, N);
      end = System.nanoTime();
      T_ms = (end-start)/1000000;

      start = System.nanoTime();
      Sorts.quickSort(arr3, N-1);
      end = System.nanoTime();
      T_qs = (end-start)/1000000;

      print(N, T_ss, T_ms, T_qs);
   }

   private static void print(long N, long T_ss, long T_ms, long T_qs) {
      System.out.println("N="+N+", T_ss="+T_ss+", T_ms="+T_ms+", T_qs="+T_qs);
   }
}
