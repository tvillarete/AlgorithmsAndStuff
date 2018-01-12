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

   public static void mergeSort(int arr[], int N) {
      
      int helper[] = new int[N];
      
      sort(arr,0,N,helper);
   }

   private static void sort(int arr[], int low, int high,int helper[]) {
      if (low < high) {
         int mid = (low+high)/2;

         sort(arr,low,mid,helper);
         sort(arr,mid+1,high,helper);

         merge(low,mid,high,arr,helper);
      }
   }

   private static void merge(int low, int middle, int high,int arr[], int helper[]) {
      for (int i =low;i<high;i++) {
         helper[i] = arr[i];
      }

      int i= low;
      int j = middle+1;
      int k = low;

      while (i<=middle && j<= high) {
         if (helper[i] <= helper[j]) {
            arr[k] = helper[i];
            i++;
         }
         else {
            arr[k] = helper[j];
            j++;
         }
         k++;
      }
      while (i<= middle) {
         arr[k] = helper[i];
         k++;
         i++;
      }
   }

   public static void quickSort(int[] arr, int N) {

   }

}
