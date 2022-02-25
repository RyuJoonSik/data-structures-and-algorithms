import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static boolean[] visited = new boolean[9];
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

  public static void bfs(int start) {
    Queue <Integer> q = new LinkedList<>();
    visited[start] = true;
    q.offer(start);

    while(!q.isEmpty()) {
      int current = q.poll();
      System.out.println(current);

      for (int i = 0; i < graph.get(current).size(); i++) {
        int next = graph.get(current).get(i);

        if(!visited[next]) {
          visited[next] = true;
          q.offer(next);
        }
      }
    }
  }

  public static void main(String[] args) {
    for (int i =0; i < 9; i++) {
      graph.add(new ArrayList<Integer>());
    }

    graph.get(1).add(2);
    graph.get(1).add(3);
    graph.get(1).add(8);

    graph.get(2).add(1);
    graph.get(2).add(7);

    graph.get(3).add(1);
    graph.get(3).add(4);
    graph.get(3).add(5);

    graph.get(4).add(3);
    graph.get(4).add(5);

    graph.get(5).add(3);
    graph.get(5).add(4);

    graph.get(6).add(7);

    graph.get(7).add(2);
    graph.get(7).add(6);
    graph.get(7).add(8);

    graph.get(8).add(1);
    graph.get(8).add(7);

    bfs(1);
  }
}
