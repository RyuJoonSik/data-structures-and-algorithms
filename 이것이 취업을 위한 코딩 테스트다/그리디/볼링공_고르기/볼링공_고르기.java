import java.util.Scanner;

public class 볼링공_고르기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] balls = new int[11];
    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i = 0; i < n; i++) {
      int ball = sc.nextInt();
      balls[ball] += 1;
    }

    int result = 0;

    for (int i = 1; i <= m; i++) {
      n -= balls[i];
      result += (balls[i] * n);
    }
    
    System.out.println(result);
  }
}