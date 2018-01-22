import java.util.Scanner;
import java.io.File;

public class MatrixWork {
   public static void main(String[] args) {
      System.out.println("Please enter the input-file's name");
      Scanner s = new Scanner(System.in);
      String filename = s.next();
      Scanner file = new Scanner(System.in);
      try {
         file = new Scanner(new File(filename));
      }
      catch (Exception exc) {
         System.out.println("Someone fucked up\n");
      }
      System.out.println("Reading from " + filename);
      boolean isMatrix1 = true;
      while (file.hasNextInt()) {
         int row;
         int col;
         if (isMatrix1) {
            row = file.nextInt();
            col = file.nextInt();
            int[][] matrix1 = new int[row][col];
            matrix1 = fillMatrix(file,row,col);
            printMatrix(matrix1);
            isMatrix1 = false;
         }
         else { //matrix2
            row = file.nextInt();
            col = file.nextInt();
            int[][] matrix2 = new int[row][col];
            matrix2 = fillMatrix(file,row,col);
            printMatrix(matrix2);
         }
      }
      /*
       * int[][] matrix3 = new int[row][col]; // get row/col of product?
       * matrix3 = matrixProduct(matrix1,matrix2);
       * System.out.println("Product matrix:");
       * printMatrix(matrix3);
       */
   }

   private static void printMatrix(int[][] arr) {
      int row = arr.length;
      int col = arr[0].length;
      System.out.println("Printing a "+ row + " x " + col + " matrix");
      for (int i=0;i<row;i++) {
         for (int j=0;j<col;j++) {
            System.out.print(arr[i][j] + " ");
         }
         System.out.println();
      }
   }

   private static int[][] fillMatrix(Scanner file,int row, int col) {
      int[][] matrix = new int[row][col];
      for (int i =0;i<row;i++) {
         for (int j=0;j<col;j++) {
            matrix[i][j] = file.nextInt();
         }
      }
      return matrix;
   }
/*
   public static int[][] matrixProduct(int[][] A, int[][]B) {

   }*/
}

