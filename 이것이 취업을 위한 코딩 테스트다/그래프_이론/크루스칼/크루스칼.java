import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 크루스칼 {
  public static class Edge implements Comparable<Edge> {
    public int distance;
    public int nodeA;
    public int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
      this.distance = distance;
      this.nodeA = nodeA;
      this.nodeB = nodeB;
    }

    @Override
    public int compareTo(Edge o) {
      if (this.distance < o.distance) {
        return -1;
      }

      return 1;
    }
  }

  public static int v, e;
  public static int[] parent = new int[10000001];
  public static ArrayList<Edge> edges = new ArrayList<>();
  public static int result = 0;

  public static int findParent(int x) {
    if (x != parent[x]) {
      parent[x] = findParent(parent[x]);
    }

    return parent[x];
  }

  public static void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    v = sc.nextInt();
    e = sc.nextInt();

    for (int i = 1; i <= v; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < e; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int cost = sc.nextInt();
      edges.add(new Edge(cost, a, b));
    }

    Collections.sort(edges);

    for (int i = 0; i < edges.size(); i++) {
      int cost = edges.get(i).distance;
      int a = edges.get(i).nodeA;
      int b = edges.get(i).nodeB;

      if (findParent(a) != findParent(b)) {
        unionParent(a, b);
        result += cost;
      }
    }
    System.out.println(result);
  }
}
