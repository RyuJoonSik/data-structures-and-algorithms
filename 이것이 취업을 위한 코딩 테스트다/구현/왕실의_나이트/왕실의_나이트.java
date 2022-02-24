package 구현.왕실의_나이트;

import java.util.Scanner;

public class 왕실의_나이트 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pos = sc.nextLine();

    int currentRow = pos.charAt(1) - '0';
    int currentColumn = pos.charAt(0) - 'a' + 1;
    int []row = {-2, -2, 2, 2, -1, 1, -1, 1};
    int []column = {-1, 1, -1, 1, -2, -2, 2, 2};
    int answer = 0;
    int nextRow, nextColumn;

    for (int i = 0; i < 8; i++) {
      nextRow = currentRow + row[i];
      nextColumn = currentColumn + column[i];

      if (1 <= nextRow && nextRow <= 8 && 1 <= nextColumn && nextColumn <= 8) {
        answer++;
      }
    }
    System.out.println(answer);
  }
}
