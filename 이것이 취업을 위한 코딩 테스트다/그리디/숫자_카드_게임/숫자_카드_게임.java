package 그리디.숫자_카드_게임;

import java.util.Scanner;

public class 숫자_카드_게임 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    // int cards[][] = new int[n][m];
    int answer = 0;

    for(int i = 0; i < n; i++) {
      int min = 10000;
      for (int j = 0; j < m; j++) {
        int temp = sc.nextInt();

        min = temp < min ? temp : min;
      }

      answer = answer < min ? min : answer;
    }

    System.out.println(answer);
  }
}
