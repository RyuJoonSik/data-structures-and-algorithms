import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 안테나 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int i = 0; i < n; i += 1) {
      arrayList.add(sc.nextInt());
    }

    Collections.sort(arrayList);

    System.out.println(arrayList.get((n - 1) / 2));
  }
}
