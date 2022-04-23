import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 어두운_길 {
  static class Edge implements Comparable<Edge> {
    public int distance;
    public int nodeA;
    public int nodeB;

    Edge(int distance, int nodeA, int nodeB) {
      this.distance = distance;
      this.nodeA = nodeA;
      this.nodeB = nodeB;
    }

    @Override
    public int compareTo(어두운_길.Edge o) {
      if (this.distance < o.distance) {
        return -1;
      }
      return 1;
    }
  }

  public static int n, m;
  public static int[] parent = new int[200001];
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

    if (a < b) parent[b] = a;
    else parent[b] = a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    for (int i = 1; i <= n; i += 1) {
      parent[i] = i;
    }

    for (int i = 0; i < m; i += 1) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();
      edges.add(new Edge(z, x, y));
    }

    Collections.sort(edges);
    int total = 0;

    for (int i = 0; i < edges.size(); i += 1) {
      int cost = edges.get(i).distance;
      int a = edges.get(i).nodeA;
      int b = edges.get(i).nodeB;
      total += cost;

      if (findParent(a) != findParent(b)) {
        unionParent(a, b);
        result += cost;
      }
    }
    System.out.println(total - result);
  }
}
