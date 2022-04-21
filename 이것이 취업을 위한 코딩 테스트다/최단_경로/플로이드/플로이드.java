import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 플로이드 {
  public static final int INF = (int) 1e9;
  public static int n, m;
  public static int[][] graph = new int[101][101];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    for (int i = 0; i < 101; i += 1) {
      Arrays.fill(graph[i], INF);
    }

    for (int a = 1; a <= n; a += 1) {
      for (int b = 1; b <= n; b += 1) {
        if (a == b) graph[a][b] = 0;
      }
    }

    for (int i = 0; i < m; i += 1) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();

      if (c < graph[a][b]) graph[a][b] = c;
    }

    for (int k = 1; k <= n; k += 1) {
      for (int a = 1; a <= n; a += 1) {
        for (int b = 1; b <= n; b += 1) {
          graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
        }
      }
    }

    for (int a = 1; a <= n; a += 1) {
      for (int b = 1; b <= n; b += 1) {
        if (graph[a][b] == INF) {
          System.out.print(0 + " ");
        }
        else {
          System.out.print(graph[a][b] + " ");
        }
      }
      System.out.println();
    }
  }

}
