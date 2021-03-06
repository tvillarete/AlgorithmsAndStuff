/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 3/14/18
 * Project 5
 */

import java.util.Scanner;

public class DiGraphTest {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int vertices = 0;
      char choice = 'z';
      System.out.println("Enter number of vertices ");
      vertices = scan.nextInt();
      DiGraph graph = new DiGraph(vertices);
      System.out.println("There are " + vertices + " vertices\n");


      System.out.println("Choose one of the following operations:\n" +
         "- add edge (enter a)\n" +
         "- delete edge (enter d)\n" +
         "- edge count (enter e)\n" +
         "- vertex count (enter v)\n" +
         "- print graph (enter p)\n" +
         "- is there a path (enter i)\n" +
         "- length of the path (enter l)\n"+
         "- shortest path (enter s)\n"+
         //"- print breadth-first-tree (enter b)\n"+
         "- Quit (enter q)\n");

      while(choice != 'q') {
         System.out.println("Please enter a menu choice: ");
         String line;
         while ((line = scan.nextLine()).length() < 1) {
         }
         if (line.length() > 1) {
            System.out.println("Menu choice should be one letter");
         } else {
            choice = line.charAt(0);
            useChoice(scan, choice, graph);
         }
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
            System.out.println("("+from+","+to+") edge is now added to the graph");

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
            System.out.println("Number of edges is " + edge);
            break;
         case 'v':
            //vertex count
            int count = graph.vertexCount();
            System.out.println("Number of vertices is " + count);
            break;
         case 'p':
            //print graph
            graph.print();
            break;
         case 't':
            int topSorted[] = graph.topSort();
            if (topSorted != null) {
               System.out.println("Topologically sorted vertices: ");
               for (int i=0; i<topSorted.length; i++) {
                  if (i == topSorted.length-1) {
                     System.out.print(topSorted[i]+1);
                  } else {
                     System.out.print(topSorted[i]+1 + ", ");
                  }
               }
               System.out.println();
            }
            break;
         case 'i':
            //is there a path?
            int vert1,vert2;
            boolean isPath = false;
            System.out.println("Please enter 2 vertex numbers");
            from = s.nextInt();
            to = s.nextInt();
            isPath = graph.isTherePath(from,to);
            System.out.println("Is there a path from " + from + " to " + to + "? " + isPath);
            break;
         case 'l':
            //length of path
            int length = -1;
            System.out.println("Please enter 2 vertex numbers");
            from = s.nextInt();
            to = s.nextInt();
            length = graph.lengthOfPath(from,to);
            System.out.println("The length from " + from + " to " + to + " is " +length);
            break;
         case 's':
            //print the shortest path
            System.out.println("Please enter 2 vertex numbers");
            from = s.nextInt();
            to = s.nextInt();
            System.out.print("The path from " + from + " to " + to + " is: ");
            graph.printPath(from,to);
            break;
         case 'b':
            int vert;
            System.out.println("Please provide a source vertex");
            vert = s.nextInt();
            graph.printTree(vert);
            break;
         case 'q':
            System.out.println("Good bye.");
            System.exit(0);
         default:
            System.out.println("Invalid choice");
            break;
      }
   }
}
