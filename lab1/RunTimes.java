public class RunTimes {
   public static void main(String[] args) {
      long startTime;
      long endTime;

      startTime = System.nanoTime();
      System.out.println("Logarithmic algorithm's running times: ");

      for (long N=1000; N<100000000; N*=2) {
         startTime = System.nanoTime();
         Algorithms.logarithmicAlgorithm(N);

         endTime = System.nanoTime();
         System.out.print("T("+N+") = ");
         System.out.println((endTime-startTime)/1000000);
      }

      System.out.println("\nLinear algorithm's running times: ");

      for (long N=1000; N<100000000; N*=2) {
         startTime = System.nanoTime();
         Algorithms.linearAlgorithm(N);

         endTime = System.nanoTime();

         System.out.print("T("+N+") = ");
         System.out.println((endTime-startTime)/1000000);
      }

      System.out.println("\nNlogN algorithm's running times: ");

      for (long N=1000; N<100000000; N*=2) {
         startTime = System.nanoTime();
         Algorithms.NlogNAlgorithm(N);

         endTime = System.nanoTime();

         System.out.print("T("+N+") = ");
         System.out.println((endTime-startTime)/1000000);
      }

      System.out.println("\nQuadratic algorithm's running times: ");

      for (long N=1000; N<=512000; N*=2) {
         startTime = System.nanoTime();
         Algorithms.quadraticAlgorithm(N);

         endTime = System.nanoTime();

         System.out.print("T("+N+") = ");
         System.out.println((endTime-startTime)/1000000);
      }

      System.out.println("\nCubic algorithm's running times: ");

      for (long N=1000; N<=8000; N*=2) {
         startTime = System.nanoTime();
         Algorithms.cubicAlgorithm(N);

         endTime = System.nanoTime();

         System.out.print("T("+N+") = ");
         System.out.println((endTime-startTime)/1000000);
      }
   }
}
