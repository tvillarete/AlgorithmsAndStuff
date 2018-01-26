/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 1/19/18
 */

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

   public static void mergeSort(int arr[], int N) {
      sort(0,N-1,arr);
   }

   private static void sort(int low, int high,int arr[]) {
      if (low < high) {
         int mid = (low+high)/2;

         sort(low,mid,arr);
         sort(mid+1,high,arr);

         merge(low,mid,high,arr);
      }
   }

   private static void merge(int low, int middle, int high,int arr[]) {
      int temp;
      temp = (high-low+1);
      int arrB[] = new int[temp];
      int i,j,k;

      i = low;
      j = middle+1;
      k = 0;

      while (i<=middle && j<= high) {
         if (arr[i] < arr[j]) {
            arrB[k] = arr[i];
            i++;
        }
         else {
            arrB[k] = arr[j];
            j++;
         }
         k++;
      }
      while (i <= middle) {
         arrB[k] = arr[i];
         i++;
         k++;
      }
      while (j <= high) {
         arrB[k] = arr[j];
         j++;
         k++;
      }
      k=0;
      for (i=low;i<=high;i++) {
         arr[i] = arrB[k++];
      }
   }

   public static void quickSort(int[] arr, int N) {
      recurQuickSort(arr, 0, N-1);
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
