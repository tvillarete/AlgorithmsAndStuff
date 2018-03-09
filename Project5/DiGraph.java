import java.util.*;

public class DiGraph {
   private LinkedList<Integer> adj[];

   public DiGraph(int N) {
      adj = new LinkedList[N];
      for (int i=0; i<N; i++) {
         adj[i] = new LinkedList<>();
      }
   }

   public void addEdge(int from, int to) {
      if (adj[from-1].contains(to-1)) {
         System.out.println("Error: Edge already added");
         return;
      }
      adj[from-1].add(to-1);
   }

   public void deleteEdge(int from, int to) {
      Iterator<Integer> it = adj[from-1].iterator();
      while (it.hasNext()) {
         if (it.next() == to-1) {
            it.remove();
            return;
         }
      }
   }

   public int edgeCount() {
      Iterator<Integer> it;
      int count = 0;

      for (int i=0; i < adj.length; i++) {
         count+=adj[i].size();
      }
      return count;
   }

   public int vertexCount() {
      return adj.length;
   }

   public void print() {
      Iterator<Integer> it;

      for (int i=0; i < adj.length; i++) {
         it = adj[i].iterator();

         System.out.print((i+1) + " is connected to: ");
         while (it.hasNext()) {
            System.out.print(it.next()+1);
            if (it.hasNext()) {
               System.out.print(", ");
            }
         }
         System.out.println();
      }
   }
}
