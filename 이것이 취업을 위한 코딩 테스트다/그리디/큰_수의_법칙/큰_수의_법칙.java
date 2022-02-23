package 그리디.큰_수의_법칙;

import java.util.*;

public class 큰_수의_법칙 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n, m, k;

    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();

    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    Arrays.sort(arr);
    int first = arr[n - 1];
    int second = arr[n - 2];
    int answer = 0;

    for (int i = 1; i <= m; i++) {
      if (i % (k + 1) == 0) {
        answer += second;
      } else {
        answer += first;
      }
    }

    System.out.println(answer);
  }
}
