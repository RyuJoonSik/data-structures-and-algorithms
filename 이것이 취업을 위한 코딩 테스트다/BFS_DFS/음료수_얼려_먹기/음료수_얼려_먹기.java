import java.util.Scanner;

public class 음료수_얼려_먹기 {
  public static int rowSize, columnSize;
  public static int[][] graph = new int[1000][1000];

  public static boolean dfs(int currentRow, int currentColumn) {
    if (currentRow <= -1 || currentRow >= rowSize || currentColumn <= -1 || currentColumn >= columnSize) {
      return false;
    }

    if(graph[currentRow][currentColumn] == 0) {
      graph[currentRow][currentColumn] = 1;
      dfs(currentRow - 1, currentColumn);
      dfs(currentRow + 1, currentColumn);
      dfs(currentRow, currentColumn - 1);
      dfs(currentRow, currentColumn + 1);
      
      return true;
    }

    return false;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    rowSize = sc.nextInt();
    columnSize = sc.nextInt();
    sc.nextLine();
    
    for (int row = 0; row < rowSize; row++) {
      String str = sc.nextLine();

      for (int column = 0; column < columnSize; column++) {
        graph[row][column] = str.charAt(column) - '0';
      }
    }

    int answer = 0;

    for (int row = 0; row < rowSize; row++) {
      for (int column = 0; column < columnSize; column++) {
        if(dfs(row, column)) {
          answer++;
        }
      }
    }

    System.out.println(answer);
  }
}
