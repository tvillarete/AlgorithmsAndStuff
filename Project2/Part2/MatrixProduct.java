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

   private static void sumMatrix(int[][] C, int[][] A, int[][] B, int rowC, int colC) {
      int n = A.length;
      for (int i=0; i<n; i++) {
         for (int j=0; j<n; j++) {
            C[i + rowC][j + colC] = A[i][j] + B[i][j];
         }
      }
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) {
      try {
         checkValid(A, B);
         int n = A.length;
         int[][] C = strassenRec(A, B);
         return C;
      } catch (IllegalArgumentException e) {
         System.out.println("Requirements not satisfied");
         System.exit(1);
      }
      return B;
   }

    private static int [][] strassenRec(int [][] A, int [][] B) {
      int n = A.length;
      int [][] result = new int[n][n];
      int [][] c = new int[n][n];
      int newSize = n/2;

      if((n%2 != 0 ) && (n !=1)) {
         return getBaseCase(A, B, result, n);
      } if(n == 1) {
         result[0][0] = A[0][0] * B[0][0];
      } else {
         int [][] A11 = new int[newSize][newSize];
         int [][] A12 = new int[newSize][newSize];
         int [][] A21 = new int[newSize][newSize];
         int [][] A22 = new int[newSize][newSize];
         int [][] B11 = new int[newSize][newSize];
         int [][] B12 = new int[newSize][newSize];
         int [][] B21 = new int[newSize][newSize];
         int [][] B22 = new int[newSize][newSize];

         // Perform matrix operations
         strassDiv(A, A11, 0 , 0);
         strassDiv(A, A12, 0 , newSize);
         strassDiv(A, A21, newSize, 0);
         strassDiv(A, A22, newSize, newSize);
         strassDiv(B, B11, 0 , 0);
         strassDiv(B, B12, 0 , newSize);
         strassDiv(B, B21, newSize, 0);
         strassDiv(B, B22, newSize, newSize);

         // Perform 7 multiplications on quadrants
         int [][] P1 = strassenRec(strassAdd(A11, A22), strassAdd(B11, B22));
         int [][] P2 = strassenRec(strassAdd(A21, A22), B11);
         int [][] P3 = strassenRec(A11, strassSubtract(B12, B22));
         int [][] P4 = strassenRec(A22, strassSubtract(B21, B11));
         int [][] P5 = strassenRec(strassAdd(A11, A12), B22);
         int [][] P6 = strassenRec(strassSubtract(A21, A11), strassAdd(B11, B12));
         int [][] P7 = strassenRec(strassSubtract(A12, A22), strassAdd(B21, B22));

         // Compute C quadrants
         int [][] C11 = strassAdd(strassSubtract(strassAdd(P1, P4), P5), P7);
         int [][] C12 = strassAdd(P3, P5);
         int [][] C21 = strassAdd(P2, P4);
         int [][] C22 = strassAdd(strassSubtract(strassAdd(P1, P3), P2), P6);

         getResult(C11, result, 0 , 0);
         getResult(C12, result, 0 , newSize);
         getResult(C21, result, newSize, 0);
         getResult(C22, result, newSize, newSize);
      }
      return result;
   }

   private static int[][] getBaseCase(int[][] A, int[][] B, int[][] result, int n) {
      int[][] A1, B1, C1;
      int n1 = n+1;
      A1 = new int[n1][n1];
      B1 = new int[n1][n1];
      C1 = new int[n1][n1];

      for(int i=0; i<n; i++)
         for(int j=0; j<n; j++) {
            A1[i][j] = A[i][j];
            B1[i][j] = B[i][j];
         }
      C1 = strassenRec(A1, B1);
      for(int i=0; i<n; i++)
         for(int j=0; j<n; j++)
            result[i][j] =C1[i][j];
      return result;

   }

   private static int [][] strassAdd(int [][] A, int [][] B) {
      int n = A.length;
      int [][] matrix = new int[n][n];

      for(int row=0; row<n; row++) {
         for(int col=0; col<n; col++) {
            matrix[row][col] = A[row][col] + B[row][col];
         }
      }
      return matrix;
   }

   private static int [][] strassSubtract(int [][] A, int [][] B) {
      int n = A.length;
      int [][] matrix = new int[n][n];

      for(int row=0; row<n; row++) {
         for(int col=0; col<n; col++) {
            matrix[row][col] = A[row][col] - B[row][col];
         }
      }
      return matrix;
   }

   private static void strassDiv(int[][] A, int[][] B, int rowB, int colB) {
      for(int row1 = 0, row2= rowB; row1 < B.length; row1++, row2++) {
         for(int col1 = 0, col2=colB; col1< B.length; col1++, col2++) {
            B[row1][col1] = A[row2][col2];
         }
      }
   }

   private static void getResult(int[][] A, int[][] B, int rowB, int colB) {
      for(int row1 = 0, row2= rowB; row1 < A.length; row1++, row2++) {
         for(int col1 = 0, col2=colB; col1<A.length; col1++, col2++) {
            B[row2][col2] = A[row1][col1];
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
