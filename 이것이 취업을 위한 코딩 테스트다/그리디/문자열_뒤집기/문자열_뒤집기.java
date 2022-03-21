import java.util.Scanner;

public class 문자열_뒤집기 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int count0 = 0;
    int count1 = 0;

    if (str.charAt(0) == '0') {
      count1 += 1;
    } else {
      count0 += 1;
    }

    for (int i = 0; i < str.length() - 1; i++) {
      if (str.charAt(i) != str.charAt(i + 1)) {
        if (str.charAt(i + 1) == '0') {
          count1 += 1;
        } else {
          count0 += 1;
        }
      }
    }
    System.out.println(Math.min(count0, count1));
  }
}
