import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 도시_분할_계획 {
  static class Edge implements Comparable<Edge> {
    public int a;
    public int b;
    public int cost;

    Edge(int a, int b, int cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
      if (this.cost < other.cost) {
        return -1;
      }

      return 1;
    }
  }

  public static int[] village = new int[100001];
  public static ArrayList<Edge> Edges = new ArrayList<Edge>();

  public static int find_village(int x) {
    if (village[x] != x) {
      village[x] = find_village(village[x]);
    }

    return village[x];
  }

  public static void union_village(int a, int b) {
    a = find_village(a);
    b = find_village(b);

    if (a < b) {
      village[b] = a;
    } else {
      village[a] = b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      village[i] = i;
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      Edges.add(new Edge(a, b, c));
    }

    Collections.sort(Edges);

    int result = 0;
    int last = 0;

    for (int i = 0; i < m; i++) {
      int a = Edges.get(i).a;
      int b = Edges.get(i).b;
      int c = Edges.get(i).cost;

      if (find_village(a) != find_village(b)) {
        union_village(a, b);
        result += c;
        last = c;
      }
    }

    System.out.println(result - last);
  }
}
