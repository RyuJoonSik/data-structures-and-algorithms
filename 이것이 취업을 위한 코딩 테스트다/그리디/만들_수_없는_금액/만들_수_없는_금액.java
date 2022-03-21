import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 만들_수_없는_금액 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> coins = new ArrayList<>();
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      coins.add(sc.nextInt());
    }

    Collections.sort(coins);

    int target = 1;

    for (int i = 0; i < n; i++) {
      if (target < coins.get(i)) {
        break;
      }

      target += coins.get(i);
    }

    System.out.println(target);
  }
}
