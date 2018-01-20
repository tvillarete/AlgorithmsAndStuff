public class Sorts1 {
   public static int selectionSort(int[] arr, int N) {
      int min;
      Counter count = new Sorts1().new Counter();

      for (int i=0;i<N;i++) {
         min = i;
         for (int j=i+1;j<N;j++) {
            count.increment();
            if (arr[j] < arr[i])
               min = j;
         }
         int temp = arr[min];
         arr[min] = arr[i];
         arr[i] = temp;
      }

      return count.getCount();
   }

   public static int mergeSort(int arr[], int N) {
      Counter count = new Sorts1().new Counter();

      sort(0,N-1,arr, count);

      return count.getCount();
   }

   private static void sort(int low, int high,int arr[], Counter count) {
      if (low < high) {
         int mid = (low+high)/2;

         sort(low,mid,arr, count);
         sort(mid+1,high,arr, count);

         merge(low,mid,high,arr, count);
      }
   }

   private static void merge(int low, int middle, int high,int arr[], Counter count) {
      int temp;
      temp = (high-low+1);
      int arrB[] = new int[temp];
      int i,j,k;

      i = low;
      j = middle+1;
      k = 0;

      while (i<=middle && j<= high) {
         count.increment();
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

   public static int quickSort(int[] arr, int N) {
      Counter count = new Sorts1().new Counter();

      recurQuickSort(arr, 0, N-1, count);

      return count.getCount();
   }

   private static void recurQuickSort(int[] arr, int left, int right, Counter count) {
      int size = right - left + 1;
      if (size <= 3) {
         manSort(arr, left, right, count);
      } else {
         double median = medianOfThree(arr, left, right, count);
         int partition = partition(arr, left, right, median, count);
         recurQuickSort(arr, left, partition - 1, count);
         recurQuickSort(arr, partition + 1, right, count);
      }
   }

   private static int partition(int[] arr, int left, int right, double pivot, Counter count) {
      int leftPt = left;
      int rightPt = right - 1;

      while (true) {
         while (arr[++leftPt] < pivot) {
            count.increment();
         }
         while (arr[--rightPt] > pivot) {
            count.increment();
         }
         count.increment();
         if (leftPt >= rightPt)
            break;
         else
            swap(arr, leftPt, rightPt, count);
      }
      swap(arr, leftPt, right - 1, count);
      return leftPt;
   }

   private static void manSort(int[] arr, int left, int right, Counter count) {
      int size = right - left + 1;
      if (size <= 1)
         return;
      if (size == 2) {
         count.increment();
         if (arr[left] > arr[right])
            swap(arr, left, right, count);
         return;
      } else {
         count.increment();
         if (arr[left] > arr[right - 1])
            swap(arr, left, right - 1, count);
         count.increment();
         if (arr[left] > arr[right])
            swap(arr, left, right, count);
         count.increment();
         if (arr[right - 1] > arr[right])
            swap(arr, right - 1, right, count);
      }
   }

   private static int medianOfThree(int[] arr, int left, int right, Counter count) {
      int center = (left + right) / 2;

      count.increment();
      if (arr[left] > arr[center])
         swap(arr, left, center, count);
      count.increment();
      if (arr[left] > arr[right])
         swap(arr, left, right, count);
      count.increment();
      if (arr[center] > arr[right])
         swap(arr, center, right, count);

      swap(arr, center, right-1, count);
      return arr[right - 1];
   }

   private static void swap(int[] arr, int index1, int index2, Counter count) {
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
   }

   private class Counter {
      int count;

      public Counter() {
         count = 0;
      }

      public void resetCount() {
         count = 0;
      }

      public void increment() {
         count += 1;
      }

      public int getCount() {
         return this.count;
      }
   }
}
