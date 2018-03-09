import java.util.Scanner;

public class DiGraphTest {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int vertices = 0;
      char choice = 'z';
      System.out.println("Please enter the number of vertices: ");
      vertices = scan.nextInt();
      DiGraph graph = new DiGraph(vertices);
      System.out.println("There are " + vertices + " vertices\n");


      System.out.println("Choose one of the following operations:\n" +
         "- add edge (enter a)\n" +
         "- delete edge (enter d)\n" +
         "- edge count (enter e)\n" +
         "- vertex count (enter v)\n" +
         "- print graph (enter p)\n" +
         "- Quit (enter q)\n");

      while(choice != 'q') {
         System.out.println("Please enter a menu choice: ");
         choice = scan.next().charAt(0);
         System.out.println("Choice was: " + choice );
         useChoice(scan,choice, graph);
      }
   }

   private static void useChoice(Scanner s,char c, DiGraph graph) {
      int from = 0;
      int to = 0;
      switch (c) {
         case 'a':
            //add edge
            System.out.println("Please identify from and to vertices");
            from = s.nextInt();
            to = s.nextInt();

            graph.addEdge(from,to);
            break;
         case 'd':
            //delete edge
            System.out.println("Please identify from and to vertices");
            from = s.nextInt();
            to = s.nextInt();
            graph.deleteEdge(from,to);
            break;
         case 'e':
            //edge count
            int edge = graph.edgeCount();
            System.out.println("Edge count: " + edge);
            break;
         case 'v':
            //vertex count
            int count = graph.vertexCount();
            System.out.println("Vertex count: " + count);
            break;
         case 'p':
            //print graph
            graph.print();
            break;
         case 'q':
            System.out.println("Quitting");
            System.exit(0);
         default:
            System.out.println("Invalid choice");
            break;
      }
   }
}
