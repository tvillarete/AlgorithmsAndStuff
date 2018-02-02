/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 2/2/18
 * Project 2
 */

public class MatrixProduct {
   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
      try {
         checkValid(A, B);
         return matrixProduct_DAC(A, B, 0, 0, 0, 0, A.length);

      } catch (IllegalArgumentException e) {
         System.out.println("Requirements not satisfied");
         System.exit(1);
      }
      return A;
   }

   private static int[][] matrixProduct_DAC(int[][] A, int[][] B,
    int rowA, int colA, int rowB, int colB, int n) {
      int[][] C = new int[n][n];   // Product matrix to return
      if (n == 1) {
         C[0][0] = A[rowA][colA] * B[rowB][colB];
      } else {
         int newSize = n/2;
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA, colA, rowB, colB, newSize),
            matrixProduct_DAC(A, B, rowA, colA + newSize, rowB + newSize, colB, newSize),
            0, 0
         );
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA, colA, rowB, colB + newSize, newSize),
            matrixProduct_DAC(A, B, rowA, colA + newSize, rowB + newSize, colB + newSize, newSize),
            0, newSize
         );
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA + newSize, colA, rowB, colB, newSize),
            matrixProduct_DAC(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB, newSize),
            newSize, 0
         );
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA + newSize, colA, rowB, colB + newSize, newSize),
            matrixProduct_DAC(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB + newSize, newSize),
            newSize, newSize
         );
      }
      return C;
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {

   }

   private static int[][] matrixProduct_Strassen(int[][] A, int[][] B,
    int rowA, int colA, int rowB, int colB, int n) {
      int[][] C = new int[n][n];   // Product matrix to return
      if (n == 1) {
         C[0][0] = A[rowA][colA] * B[rowB][colB];
      } else {
         int newSize = n/2;
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA, colA, rowB, colB, newSize),
            matrixProduct_DAC(A, B, rowA, colA + newSize, rowB + newSize, colB, newSize),
            0, 0
         );
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA, colA, rowB, colB + newSize, newSize),
            matrixProduct_DAC(A, B, rowA, colA + newSize, rowB + newSize, colB + newSize, newSize),
            0, newSize
         );
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA + newSize, colA, rowB, colB, newSize),
            matrixProduct_DAC(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB, newSize),
            newSize, 0
         );
         sumMatrix(
            C,
            matrixProduct_DAC(A, B, rowA + newSize, colA, rowB, colB + newSize, newSize),
            matrixProduct_DAC(A, B, rowA + newSize, colA + newSize, rowB + newSize, colB + newSize, newSize),
            newSize, newSize
         );
      }
      return C;
   }

   private static void strassAdd(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int n) {
   
   }

   private static void strassSub(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int n) {
   
   }

   private static void sumMatrix(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
      int n = A.length;
      for (int i=0; i<n; i++) {
         for (int j=0; j<n; j++) {
            C[i + rowC][j + colC] = A[i][j] + B[i][j];
         }
      }
   }

   private static void diffMatrix(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
      int n = A.length;
      for (int i=0; i<n; i++) {
         for (int j=0; j<n; j++) {
            C[i + rowC][j + colC] = A[i][j] - B[i][j];
         }
      }
   }


   private static void printMatrix(int[][] arr) {
      int row = arr.length;
      int col = arr[0].length;
      System.out.println();
      for (int i=0;i<row;i++) {
         for (int j=0;j<col;j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
      try {
         checkValid(A, B);
      } catch (IllegalArgumentException e) {
         System.out.println("Requirements not satisfied");
         System.exit(1);
      }
      return B;
   }

   private static void checkValid(int[][] A, int[][] B)
    throws IllegalArgumentException{
      int rowA = A.length;
      int colA = A[0].length;
      int rowB = B.length;
      int colB = B[0].length;

      if (rowA != colA || rowB != colB || rowA != rowB ||
          rowA%2 != 0) {
         throw new IllegalArgumentException();
      }
   }
}
