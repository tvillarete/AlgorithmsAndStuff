/**
 * Tanner Villarete (tvillare)
 * Daniel Kirkpatrick (djkirkpa)
 * CSC 349
 * 3/14/18
 * Project 5
 */

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
      try {
         ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

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
            throw new IllegalArgumentException();
         }
      }
      catch (IllegalArgumentException e) {
         System.out.println("Error: This is a cyclical graph");
         return null;
      }
      return answer;
   }

   // PART 3

   private class VertexInfo {
      public int distance;
      public int predecessor;

      public VertexInfo() {
         this.distance = -1;
         this.predecessor = -1;
      }
   }

   public boolean isTherePath(int from, int to) {
      VertexInfo VA[] = BFS(from);
      if (VA[to-1].distance == -1)
         return false;
      return true;
   }

   public int lengthOfPath(int from, int to) {
      int length=0;
      VertexInfo VA[] = BFS(from);
      if (VA[to-1].distance == -1) {
         System.out.println("There is no path");
      }
      else {
         while (from != to) {
            length++;
            to = VA[to-1].predecessor+1;
         }
      }
      return length;
   }

   private VertexInfo[] BFS (int s) {
      int N = adj.length;
      int u;
      s=s-1;
      Iterator<Integer> it;
      VertexInfo VA[] = new VertexInfo[N];

      for (u = 0; u < N; u++) {
         VA[u] = new VertexInfo();
      }
      VA[s].distance = 0;
      ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
      queue.add(s);
      while (queue.peek() != null) {
         u = queue.remove();
         it = adj[u].iterator();
         while (it.hasNext()) {
            int v = it.next();
            if (VA[v].distance == -1) {
               VA[v].distance = VA[u].distance + 1;
               VA[v].predecessor = u;
               queue.add(v);
            }
         }
      }
      return VA;
   }

   public void printPath(int from, int to) {
      VertexInfo VA[] = BFS(from);
      if (VA[to-1].distance == -1) {
         System.out.println("There is no path");
      }
      else {
         String output = "";
         while (from != to) {
            output = "->" + (to) + output;
            to = VA[to-1].predecessor+1;
         }
         output = from + output;
         System.out.println(output);
      }
   }

   /* TEST METHOD */
   private static void printVA(VertexInfo VA[]) {
      for (int i=0;i<VA.length;i++) {
         System.out.println((i+1) + ": dist: " + VA[i].distance + " pred: " + VA[i].predecessor);
      }
   }

   /* TEST METHOD */
   private static void printTreeArr(TreeNode TN[]) {
      char chr[] = {'a','b','c','d','e','f','g','h','i','j','k','l'};
      Iterator<TreeNode> it;
      for (int i=0;i<TN.length;i++){
         it = TN[i].children.iterator();
         while ( it.hasNext() ) {
            System.out.print(chr[it.next().vertNum] + " ");
         }
         System.out.println();
      }
   }

   //PART 4
   private class TreeNode {
      int vertNum;
      LinkedList<TreeNode> children;

      public TreeNode(int vertNum) {
         this.vertNum = vertNum;
         this.children = new LinkedList<TreeNode>();
      }
   }
   private TreeNode buildTree(int s) {
      VertexInfo VA[] = BFS(s);
      TreeNode treeArr[] = new TreeNode[VA.length];
      TreeNode root = null;
      for (int i=0;i<treeArr.length;i++) {
         treeArr[i] = new TreeNode(i);
      }
      for (int j=0;j<VA.length;j++) {
         int parent;
         parent = VA[j].predecessor;
         if (parent!= -1) {
            treeArr[parent].children.add(treeArr[j]);
         }
         else {
            root = treeArr[j];
         }
      }
      return root;
   }

   public void printTree(int s) {
      TreeNode root = buildTree(s);
      printRec(root,0);
   }

   private void printRec(TreeNode root,int level) {
      if (root == null)
         return;
      Iterator<TreeNode> it = root.children.iterator();
      String str = "";
      for (int i=0; i<level; i++) {
         str = str.concat("    ");
      }
      System.out.println(str + (root.vertNum + 1));

      while (it.hasNext()) {
         printRec(it.next(),level+1);
      }
   }
}
