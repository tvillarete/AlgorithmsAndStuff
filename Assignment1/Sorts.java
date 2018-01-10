public class Sorts {
   public static void selectionSort(int[] arr, int N) {
      int min;
      for (int i=0;i<N;i++) {
         min = i;
         for (int j=i+1;j<N;j++) {
            if (arr[j] < arr[i])
               min = j;
         }  
         int temp = arr[min];
         arr[min] = arr[i];
         arr[i] = temp;
      }
   }

   public static void mergeSort(int[] arr, int N) {

   }

   public static void quickSort(int[] arr, int N) {

   }

}
