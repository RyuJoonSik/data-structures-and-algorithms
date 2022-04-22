import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 화성_탐사 {
  static class Node implements Comparable<Node> {
    public int x;
    public int y;
    public int distance;

    Node(int x, int y, int distance) {
      this.x = x;
      this.y = y;
      this.distance = distance;
    }

    @Override
    public int compareTo(화성_탐사.Node o) {
      if (this.distance < o.distance) {
        return -1;
      }

      return 1;
    }
  }

  static final int INF = (int) 1e9;
  static int[][] graph = new int[125][125];
  static int[][] d = new int[125][125];
  static int testCase, n;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    testCase = sc.nextInt();

    for (int tc = 0; tc < testCase; tc += 1) {
      n = sc.nextInt();
      
      for (int i = 0; i < n; i += 1) {
        for (int j = 0; j < n; j += 1) {
          graph[i][j] = sc.nextInt();
        }
      }
  
      for (int i = 0; i < n; i += 1) {
        Arrays.fill(d[i], INF);
      }
  
      int x = 0, y = 0;
  
      PriorityQueue<Node> pq = new PriorityQueue<>();
      pq.offer(new Node(0, 0, graph[x][y]));
      d[x][y] = graph[x][y];
  
      while (!pq.isEmpty()) {
        Node node = pq.poll();
        int dist = node.distance;
        x = node.x;
        y = node.y;
  
        if (d[x][y] < dist) continue;
  
        for (int i = 0; i < 4; i += 1) {
          int nx = x + dx[i];
          int ny = y + dy[i];
  
          if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
          int cost = dist + graph[nx][ny];
  
          if (cost < d[nx][ny]) {
            d[nx][ny] = cost;
            pq.offer(new Node(nx, ny, cost));
          }
        }
      }
      System.out.println(d[n - 1][n - 1]);
    }

  }
}
