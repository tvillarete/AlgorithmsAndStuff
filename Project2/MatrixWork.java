import java.util.Scanner;

public class MatrixWork {
   public static void main(String[] args) {
      System.out.println("Please enter the input-file's name");
      Scanner s = new Scanner(System.in);
      String filename = s.next();
      System.out.println(filename);
      File file = new File(filename);
      int ctr = 0;
      boolean matrix1 = true;
      int matrix1[][];
      int matrix2[][];
      int rowct=0;
      int colct=0;
      while (file.hasNextInt()) {
         int row;
         int col;
         if (matrix1) {
            row = file.nextInt();
            col = file.nextInt();
            matrix1= new int[row][col];
            matrix1 = false;
         }
         else { //matrix2;
            row = file.nextInt();
            col = file.nextInt();
            matrix2 = new int[row][col];

         }

         else if ((rowct == matrix1.length()) && (colct == matrix1[0].length())){
         }
         else {
            matrix1[rowct][colct] = file.nextInt();
         }
         

      }
   }

   private static void fillArray(int[][] arr,file) {

   }
/*
   public static int[][] matrixProduct(int[][] A, int[][]B) {

   }*/
}

