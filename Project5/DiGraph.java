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

   // PART 2

   private int[] indegrees() {
      Iterator<Integer> it;
      int indegrees[] = new int[adj.length];
      int count;

      // Initialize all array spots to zero
      for (int i=0; i<adj.length; i++) {
         indegrees[i] = 0;
      }

      for (int i=0; i<adj.length; i++) {
         it = adj[i].iterator();
         while (it.hasNext()) {
            indegrees[it.next()] += 1;
         }
      }
      return indegrees;
   }

   public int[] topSort() throws IllegalArgumentException {
      Iterator<Integer> it;
      int N = adj.length;
      int indegrees[] = indegrees();
      int answer[] = new int[N];
      int u;
      PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

      for (u = 0;  u < N; u++) {
         if (indegrees[u] == 0) {
            queue.add(u);
         }
      }
      int i = 0;
      while (queue.peek() != null) {
         u = queue.remove();
         answer[i] = u;
         i++;
         it = adj[u].iterator();
         while (it.hasNext()) {
            int v = it.next();
            indegrees[v]--;
            if (indegrees[v] == 0) {
               queue.add(v);
            }
         }
      }
      if (i != N) {
         throw new IllegalArgumentException("Error: This is a cyclical graph");
      }
      return answer;
   }

}
