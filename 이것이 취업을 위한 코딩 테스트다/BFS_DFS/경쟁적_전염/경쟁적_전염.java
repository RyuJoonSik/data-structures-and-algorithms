import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 경쟁적_전염 {
  static class Virus implements Comparable<Virus> {
    public int index;
    public int second;
    public int x;
    public int y;

    public Virus(int index, int second, int x, int y) {
      this.index = index;
      this.second = second;
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Virus other) {
      if (this.index < other.index) {
        return - 1;
      }
      return 1;
    }
  }

  public static int n, k;
  public static int[][] graph = new int[200][200];
  public static ArrayList<Virus> viruses = new ArrayList<Virus>();

  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n; j += 1) {
        graph[i][j] = sc.nextInt();
        if (graph[i][j] != 0) {
          viruses.add(new Virus(graph[i][j], 0, i, j));
        }
      }
    }

    Collections.sort(viruses);
    Queue<Virus> q = new LinkedList<Virus>();
    for (int i = 0; i < viruses.size(); i += 1) {
      q.offer(viruses.get(i));
    }

    int targetS = sc.nextInt();
    int targetX = sc.nextInt();
    int targetY = sc.nextInt();

    while (!q.isEmpty()) {
      Virus virus = q.poll();

      if (virus.second == targetS) break;
      for (int i = 0; i < 4; i += 1) {
        int nx = virus.x + dx[i];
        int ny = virus.y = dy[i];

        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
          if (graph[nx][ny] == 0) {
            graph[nx][ny] = virus.index;
            q.offer(new Virus(virus.index, virus.second + 1, nx, ny));
          }
        }
      }
    }
    System.out.println(graph[targetX - 1][targetY - 1]);
  }
}
