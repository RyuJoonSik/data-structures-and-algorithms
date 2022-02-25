import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로_탈출 {
  public static int rowSize, columnSize;
  public static int[][] graph = new int[200][200];
  public static void bfs(int newRow, int newColumn) {
    int []row = {-1, 1, 0, 0};
    int []column = {0, 0, -1, 1};

    Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
    q.offer(new ArrayList<Integer>(Arrays.asList(newRow, newColumn)));

    while(!q.isEmpty()) {
      int currentRow = q.peek().get(0);
      int currentColumn = q.peek().get(1);
      q.poll();

      for(int i = 0; i < 4; i++) {
        int nextRow = currentRow + row[i];
        int nextColumn = currentColumn + column[i];

        if(-1 >= nextRow || nextRow >= rowSize || -1 >= nextColumn || nextColumn >= columnSize) {
          continue;
        }

        if(graph[nextRow][nextColumn] == 1) {
          graph[nextRow][nextColumn] = graph[currentRow][currentColumn] + 1;
          q.offer(new ArrayList<Integer>(Arrays.asList(nextRow, nextColumn)));
        }
      }
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    rowSize = sc.nextInt();
    columnSize = sc.nextInt();
    sc.nextLine();

    for(int row = 0; row < rowSize; row++) {
      String str = sc.nextLine();

      for(int column = 0; column < columnSize; column++) {
        graph[row][column] = str.charAt(column) - '0';
      }
    }

    bfs(0, 0);

    System.out.println(graph[rowSize-1][columnSize-1]);
  }
}
