public class SortTests {
   public static void main(String[] args) {
      int arr[] = new int[100];
      int j = 0;
      for (int i=arr.length-1; i>=0; i--) {
         arr[j++] = i;
      }
      for (int i=0; i<arr.length; i++) {
         System.out.print(arr[i] + ", " );
      }
      Sorts.mergeSort(arr, arr.length);
      System.out.println();
      for (int i=0; i<arr.length; i++) {
         System.out.print(arr[i] + ", ");
      }
   }

   public static void testMergeSort() {
   }

   public static void printOutput(long N, long T_ss, long T_ms, long T_qs) {
      System.out.println("N="+N+": T_Sss="+T_ss+", T_ms="+T_ms+", T_qs="+T_qs);
   }
}
