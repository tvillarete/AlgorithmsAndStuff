public class Algorithms {
   public static void linearAlgorithm(long N) {
      long x;

      for (long i=1; i<N; i++) {
         x = 1;
      }
   }

   public static void quadraticAlgorithm(long N) {
      long x;

      for (long i=1; i<N; i++) {
         for (long j=1; j<N; j++) {
            x = 1;
         }
      }
   }

   public static void cubicAlgorithm(long N) {
      long x;

      for (long i=1; i<N; i++) {
         for (long j=1; j<N; j++) {
            for (long k=1; k<N; k++) {
               x = 1;
            }
         }
      }

   }

   public static void logarithmicAlgorithm(long N) {
      long x;

      for (long i=N; i >= 1; i/=2) {
         x = 1;
      }
   }

   public static void NlogNAlgorithm(long N) {
      long x;

      for (long i=1; i<N; i++) {
         for (long j=N; j >= 1; j/=2) {
            x = 1;
         }
      }
   }
}
