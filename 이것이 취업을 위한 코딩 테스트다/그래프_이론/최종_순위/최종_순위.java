import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 최종_순위 {
  public static int testCase, n, m;
  public static int[] indegree = new int[501];
  public static boolean[][] graph = new boolean[501][501];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    testCase = sc.nextInt();

    for (int tc = 0; tc < testCase; tc += 1) {
      Arrays.fill(indegree, 0);

      for (int i = 0; i < 501; i += 1) {
        Arrays.fill(graph[i], false);
      }

      n = sc.nextInt();
      ArrayList<Integer> arrayList = new ArrayList<>();

      for (int i = 0; i < n; i += 1) {
        int x = sc.nextInt();
        arrayList.add(x);
      }

      for (int i = 0; i < n; i += 1) {
        for (int j = i + 1; j < n; j += 1) {
          graph[arrayList.get(i)][arrayList.get(j)] = true;
          indegree[arrayList.get(j)] += 1;
        }
      }

      m = sc.nextInt();
      for (int i = 0; i < m; i += 1) {
        int a = sc.nextInt();
        int b= sc.nextInt();

        if (graph[a][b]) {
          graph[a][b] = false;
          graph[b][a] = true;
          indegree[a] += 1;
          indegree[b] -= 1;
        } else {
          graph[a][b] = true;
          graph[b][a] = false;
          indegree[a] -= 1;
          indegree[b] += 1;
        }
      }

      ArrayList<Integer> result = new ArrayList<>();
      Queue<Integer> q = new LinkedList<>();

      for (int i = 1; i <= arrayList.size(); i += 1) {
        if (indegree[i] == 0) {
          q.offer(i);
        }
      }

      boolean certain = true;
      boolean cycle = false;

      for (int i = 0; i < n; i += 1) {
        if (q.size() == 0) {
          cycle = true;
          break;
        }

        if (q.size() >= 2) {
          certain = false;
          break;
        }

        int now = q.poll();
        result.add(now);

        for (int j = 1; j <= n; j += 1) {
          if (graph[now][j]) {
            indegree[j] -= 1;

            if (indegree[j] == 0) {
              q.offer(j);
            }
          }
        }
      }

      if (cycle) System.out.print("IMPOSSIBLE");
      else if (!certain) System.out.println("?");
      else {
        for (int i = 0; i < result.size(); i += 1) {
          System.out.print(result.get(i) + " ");
        }
        System.out.println();
      }
    }
  }
}