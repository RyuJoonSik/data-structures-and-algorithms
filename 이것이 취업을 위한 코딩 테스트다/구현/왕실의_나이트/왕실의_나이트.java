package 구현.왕실의_나이트;

import java.util.Scanner;

public class 왕실의_나이트 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pos = sc.nextLine();

    int currentRow = pos.charAt(1);
    int currentColumns = pos.charAt(0);

    System.out.println(currentRow, currentColumns);
  }
}
