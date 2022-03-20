import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 커리큘럼 {
  public static int[] times = new int[501];
  public static int[] results = new int[501];
  public static int[] indegrees = new int[501];
  public static ArrayList<ArrayList<Integer>> graphs = new ArrayList<ArrayList<Integer>>();
  public static Queue<Integer> queue = new LinkedList<Integer>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i <= n; i++) {
      graphs.add(new ArrayList<Integer>());
    }

    for (int i = 1; i <= n; i++) {
      int time = sc.nextInt();
      times[i] = time;

      while (true) {
        int outputNode = sc.nextInt();

        if (outputNode == -1) {
          break;
        }
        
        graphs.get(outputNode).add(i);
        indegrees[i] += 1;
      }
    }

    for (int i = 1; i <= n; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }

    for (int i = 1; i <= n; i++) {
      results[i] = times[i];
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int i = 0; i < graphs.get(now).size(); i++) {
        int outputNode = graphs.get(now).get(i);
        results[outputNode] = Math.max(results[outputNode], results[now] + times[outputNode]);
        indegrees[outputNode] -= 1;

        if (indegrees[outputNode] == 0) {
          queue.offer(outputNode);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      System.out.println(results[i]);
    }
  }
}
