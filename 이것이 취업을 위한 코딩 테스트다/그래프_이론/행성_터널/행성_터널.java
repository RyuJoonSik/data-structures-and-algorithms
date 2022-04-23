import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 행성_터널 {
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
    public int compareTo(행성_터널.Edge o) {
      if (this.distance < o.distance) {
        return -1;
      }
      return 1;
    }
  }

  static class Position implements Comparable<Position> {
    public int x;
    public int y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(행성_터널.Position o) {
      if (this.x == o.x) {
        return Integer.compare(this.y, o.y);
      }
      return Integer.compare(this.x, o.x);
    }
  }

  public static int n;
  public static int[] parent = new int[100001];
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

    n = sc.nextInt();

    for (int i = 1; i <= n; i += 1) {
      parent[i] = i;
    }

    ArrayList<Position> x = new ArrayList<>();
    ArrayList<Position> y = new ArrayList<>();
    ArrayList<Position> z = new ArrayList<>();

    for (int i = 1; i <= n; i += 1) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      x.add(new Position(a, i));
      y.add(new Position(b, i));
      z.add(new Position(c, i));
    }

    Collections.sort(x);
    Collections.sort(y);
    Collections.sort(z);

    for (int i = 0; i < n - 1; i += 1) {
      edges.add(new Edge(x.get(i + 1).x - x.get(i).x, x.get(i).y, x.get(i + 1).y));
      edges.add(new Edge(y.get(i + 1).x - y.get(i).x, y.get(i).y, y.get(i + 1).y));
      edges.add(new Edge(z.get(i + 1).x - z.get(i).x, z.get(i).y, z.get(i + 1).y));
    }
    System.out.println(edges.size());

    Collections.sort(edges);

    for (int i = 0; i < edges.size(); i += 1) {
      int cost = edges.get(i).distance;
      int a = edges.get(i).nodeA;
      int b = edges.get(i).nodeB;
      System.out.println(cost + " " + a + " " + b);
      if (findParent(a) != findParent(b)) {
        unionParent(a, b);
        result += cost;
      }
    }

    System.out.println(result);
  }
}
