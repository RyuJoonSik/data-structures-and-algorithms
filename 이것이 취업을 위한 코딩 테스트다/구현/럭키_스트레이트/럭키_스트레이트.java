import java.util.Scanner;

public class 럭키_스트레이트 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    int size = str.length();
    int mid = size / 2;
    int sum = 0;

    for (int i = 0; i < mid; i++) {
      sum += (str.charAt(i) - '0');
    }

    for (int i = mid; i < size; i++) {
      sum -= (str.charAt(i) - '0');
    }

    if (sum == 0) {
      System.out.println("LUCKY");
    } else {
      System.out.println("READY");
    }
  }
}
