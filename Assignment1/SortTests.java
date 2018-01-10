public class SortTests {
   public static void main(String[] args) {
      int arr[] = {1, 3, 2};
      Sorts.selectionSort(arr, 3);
   }

   public static void testMergeSort() {

   }

   public static void printOutput(long N, long T_ss, long T_ms, long T_qs) {
      System.out.println("N="+N+": T_Sss="+T_ss+", T_ms="+T_ms+", T_qs="+T_qs);
   }
}
