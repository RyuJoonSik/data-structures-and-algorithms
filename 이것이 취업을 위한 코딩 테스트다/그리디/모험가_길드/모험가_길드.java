import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 모험가_길드 {
  public static ArrayList<Integer> fears = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      int fear = sc.nextInt();
      fears.add(fear);
    }

    Collections.sort(fears);

    int result = 0;
    int count = 0;

    for (int i = 0; i < n; i++) {
      count += 1;

      if (count >= fears.get(i)) {
        result += 1;
        count = 0;
      }
    }

    System.out.println(result);
  }
}
