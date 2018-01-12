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
      for (int k = 0; k<N; k++) {
         System.out.println(arr[k]);
      }
   }

   public static void mergeSort(int[] arr, int N) {
      if (1<N) {
         int mid = N/2;

         sort(arr,
      }
      int n1 = N/2;
      int n2 = N - n1;

      int arr1[] = new int[n1];
      int arr2[] = new int[n2];

      for (int i=0;i<n1;++i)
         arr1[i] = arr[i];
      for (int j=n1;j<n2;++j) 
         arr2[j] = arr[j];

   }

   private void sort(int arr[], int N) {

   }

   private void merge(int low, int middle, int high) {
      for (int i =low;i<high;i++) {
         helper
      }
   }

   public static void quickSort(int[] arr, int N) {

   }

}
