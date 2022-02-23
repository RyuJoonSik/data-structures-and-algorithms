package 구현.게임_개발;

import java.util.Scanner;

public class 게임_개발 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rowSize = sc.nextInt();
    int columnSize = sc.nextInt();
    int [][]boards = new int[50][50];
    int [][]checks = new int[50][50];
    int currentRow = sc.nextInt();
    int currentColumn = sc.nextInt();
    int direction = sc.nextInt();
    int []row = {-1, 0, 1, 0};
    int []column = {0, -1, 0, 1};
    int nextRow, nextColumn;
    int answer = 1, count = 0;
    checks[1][1] = 1;

    for (int i = 0; i < rowSize; i++) {
      for (int j = 0; j < columnSize; j++) {
        boards[i][j] = sc.nextInt();
      }
    }

    while (true) {
      direction = direction == 0 ? 3 : direction - 1;
      nextRow = currentRow + row[direction];
      nextColumn = currentColumn + column[direction];

      if (boards[nextRow][nextColumn] == 0 && checks[nextRow][nextColumn] == 0) {
        count = 0;
        answer++;
        checks[nextRow][nextColumn] = 1;
        currentRow = nextRow;
        currentColumn = nextColumn;
      } else {
        count++;
      }

      if (count == 4) {
        nextRow = currentRow - row[direction];
        nextColumn = currentColumn - column[direction];

        if (boards[nextRow][nextColumn] == 0) {
          currentRow = nextRow;
          currentColumn = nextColumn;
          count = 0;
        } else {
          break;
        }
      }
    }

    System.out.println(answer);
  }
}
