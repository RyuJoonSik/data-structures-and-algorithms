package 구현.상하좌우;

import java.util.*;

public class 상하좌우 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    sc.nextLine();
    String str = sc.nextLine();

    int currentRow = 1;
    int currentColumn = 1;
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};
    char dt[] = {'U', 'D', 'L', 'R'};
    int nextRow, nextColumn;

    for (int i = 0; i < str.length(); i+=2) {
      char type = str.charAt(i);

      for (int j = 0; j < 4; j++) {
        if (type == dt[j]) {
          nextRow = currentRow + dx[j];
          nextColumn = currentColumn + dy[j];

          if (1 <= nextRow && nextRow <= size && 1 <= nextColumn && nextColumn <= size) {
            currentRow = nextRow;
            currentColumn = nextColumn;
          }
        }

      }
    }

    System.out.println(currentRow + " " + currentColumn);
  }
}
