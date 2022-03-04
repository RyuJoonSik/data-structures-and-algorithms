import java.util.Arrays;
import java.util.Scanner;

public class 효율적인_화폐_구성 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    int[] arr = new int[n];
    int[] dp = new int[m + 1];
    
    Arrays.fill(dp, 10001);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    for (int num: arr) {
      for (int i = num; i <= m; i++) {
        dp[i] = Math.min(dp[i], dp[i - num] + 1);
      }
    }

    if (dp[m] == 10001) {
      System.out.println(-1);
    } else {
      System.out.println(dp[m]);
    }
  }
}
