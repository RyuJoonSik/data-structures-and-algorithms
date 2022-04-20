import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 병사_배치하기 {
  static int n;
  static ArrayList<Integer> v = new ArrayList<>();
  static int[] dp = new int[20000];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    for (int i = 0; i < n; i += 1) {
      v.add(sc.nextInt());
    }

    Collections.reverse(v);

    for (int i = 0; i < n; i += 1) {
      dp[i] = 1;
    }

    for (int i = 1; i < n; i += 1) {
      for (int j = 0; j < i; j += 1) {
        if (v.get(j) < v.get(i)) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int maxValue = 0;
    for (int i = 0; i < n; i += 1) {
      maxValue = Math.max(maxValue, dp[i]);
    }
    System.out.println(n - maxValue);
  }
}
