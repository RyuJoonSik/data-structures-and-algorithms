package 구현.시각;

import java.util.Scanner;

public class 시각 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int answer = 0;
  
    for(int hour = 0; hour <= n; hour++) {
      for(int min = 0; min <= 59; min++) {
        for(int sec = 0; sec <= 59; sec++) {
          if (hour % 10 == 3 || min / 10 == 3 || min % 10 == 3 || sec / 10 == 3 || sec % 10 == 3) {
            answer++;
          }
        }
      }
    }
    System.out.println(answer);
  }
}
