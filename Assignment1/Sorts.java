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

      while (i<middle && j< high) {
         if (helper[i] < helper[j]) {
            arr[k] = helper[i];
            i++;
         }
         else {
            arr[k] = helper[j];
            j++;
         }
         k++;
      }
      while (i< middle) {
         arr[k] = helper[i];
         k++;
         i++;
      }
   }

   public static void quickSort(int[] arr, int N) {
      recurQuickSort(arr, 0, N);
   }

   private static void recurQuickSort(int[] arr, int left, int right) {
      int size = right - left + 1;
      if (size <= 3) {
         manSort(arr, left, right);
      } else {
         double median = medianOfThree(arr, left, right);
         int partition = partition(arr, left, right, median);
         recurQuickSort(arr, left, partition - 1);
         recurQuickSort(arr, partition + 1, right);
      }
   }

   private static int partition(int[] arr, int left, int right, double pivot) {
      int leftPt = left;
      int rightPt = right - 1;

      while (true) {
         while (arr[++leftPt] < pivot)
            ;
         while (arr[--rightPt] > pivot)
            ;
         if (leftPt >= rightPt)
            break;
         else
            swap(arr, leftPt, rightPt);
      }
      swap(arr, leftPt, right - 1);
      return leftPt;
   }

   private static void manSort(int[] arr, int left, int right) {
      int size = right - left + 1;
      if (size <= 1)
         return;
      if (size == 2) {
         if (arr[left] > arr[right])
            swap(arr, left, right);
         return;
      } else {
         if (arr[left] > arr[right - 1])
            swap(arr, left, right - 1);
         if (arr[left] > arr[right])
            swap(arr, left, right);
         if (arr[right - 1] > arr[right])
            swap(arr, right - 1, right);
      }
   }

   private static int medianOfThree(int[] arr, int left, int right) {
      int center = (left + right) / 2;

      if (arr[left] > arr[center])
         swap(arr, left, center);
      if (arr[left] > arr[right])
         swap(arr, left, right);
      if (arr[center] > arr[right])
         swap(arr, center, right);

      swap(arr, center, right-1);
      return arr[right - 1];
   }

   private static void swap(int[] arr, int index1, int index2) {
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
   }

}
