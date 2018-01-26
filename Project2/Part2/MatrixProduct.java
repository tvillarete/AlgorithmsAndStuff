public class MatrixProduct {
   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
      try {
         checkValid(A, B);
      } catch (IllegalArgumentException e) {
         System.out.println("Requirements not satisfied");
         System.exit(1);
      }
      return A;
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
