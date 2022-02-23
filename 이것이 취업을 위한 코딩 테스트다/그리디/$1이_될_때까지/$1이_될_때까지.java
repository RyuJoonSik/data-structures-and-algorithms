package 그리디.$1이_될_때까지;

import java.util.*;

public class $1이_될_때까지 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int answer = 0;

    while (n != 1) {
      if (n % k == 0) {
        n /= k;
      } else {
        n--;
      }

      answer++;
    }

    System.out.println(answer);
  }
}
