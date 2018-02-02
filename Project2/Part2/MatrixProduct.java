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
      try {
         checkValid(A, B);
         int n = A.length;
         matrixProduct_Strassen(A, B, 0, 0, 0, 0, n);
      } catch (IllegalArgumentException e) {
         System.out.println("Requirements not satisfied");
         System.exit(1);
      }
   }

   private static int[][] matrixProduct_Strassen(int[][] A, int[][] B,
    int rowA, int colA, int rowB, int colB, int n) {
      int[][] C = new int[n][n];   // Product matrix to return
      int[][] S1, S2, S3, S4, S5, S6, S7, S8, S9, S10 = new int[n/2][n/2];
      int[][] P1, P2, P3, P4, P5, P6, P7 = new int[n/2][n/2];

      S1 = strassSub(B, B, 0, 1, 1, 1, n); // Need to substitute with rowA, colA, etc.
      S2 = strassAdd(A, A, 0, 0, 0, 1, n); // Also don't know size of n
      S3 = strassAdd(A, A, 1, 0, 1, 1, n);
      S4 = strassSub(B, B, 1, 0, 0, 0, n);
      S5 = strassAdd(A, A, 0, 0, 1, 1, n);
      S6 = strassAdd(B, B, 0, 0, 1, 1, n);
      S7 = strassSub(A, A, 0, 1, 1, 1, n);
      S8 = strassAdd(B, B, 1, 0, 1, 1, n);
      S9 = strassSub(A, A, 0, 0, 1, 0, n);
      S10 = strassAdd(B, B, 0, 0, 0, 1, n);

      P1 = matrixProduct_Strassen(A, S1, 0, 0, 0, 0, n);
      P2 = matrixProduct_Strassen();
      P3 = matrixProduct_Strassen();
      P4 = matrixProduct_Strassen();
      P5 = matrixProduct_Strassen();
      P6 = matrixProduct_Strassen();
      P7 = matrixProduct_Strassen();

      C[0][0] = //P5 + P4 - P2 + P6;
      C[0][1] = // P1 + P2;
      C[1][0] = // P3 + P4;;
      C[1][1] = //P5 + P1 - P3 - P7;

      return C;
   }

   private static void strassAdd(int[][] S, int[][] A, int[][] B, int rowA, int colA,
    int rowB, int colB, int n) {
      for (int i=0; i<n; i++) {
         for (int j=0; j<n; j++) {
            S[i + rowC][j + colC] = A[i][j] + B[i][j];
         }
      }

   }

   private static void strassSub(int[][] S, int[][] A, int[][] B, int rowA, int colA,
    int rowB, int colB, int n) {

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
