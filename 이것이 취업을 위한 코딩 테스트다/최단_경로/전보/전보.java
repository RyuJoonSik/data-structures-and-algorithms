import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 전보 {
  static class Node implements Comparable<Node>{
    public int num;
    public int cost;

    Node (int num, int cost) {
      this.num = num;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      if (this.cost < o.cost) {
        return -1;
      }
      return 1;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int c = sc.nextInt();
    final int INF = (int)1e9;

    int[] d = new int[n + 1];
    Arrays.fill(d, INF);
    d[c] = 0;

    ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    for (int i = 0; i < m; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int z = sc.nextInt();

      Node node = new Node(y, z);
      graph.get(x).add(node);
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(c, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.num;
      int dist = node.cost;

      if (dist > d[now]) {
        continue;
      }

      for (int i = 0; i < graph.get(now).size(); i++) {
        int next = graph.get(now).get(i).num;
        int new_dist = dist + graph.get(now).get(i).cost;

        if (new_dist < d[next]) {
          d[next] = new_dist;

          pq.offer(new Node(next, new_dist));
        }
      }
    }

    int count = 0, max_dist = 0;

    for (int dist: d) {
      if (dist != INF) {
        count += 1;
        max_dist = Math.max(max_dist, dist);
      }
    }

    System.out.println((count - 1)+ " " + max_dist);
  }
}
