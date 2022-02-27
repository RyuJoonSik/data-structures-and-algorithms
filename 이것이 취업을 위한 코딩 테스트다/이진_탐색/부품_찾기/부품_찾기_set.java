import java.util.*;

public class 부품_찾기_set {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      set.add(num);
    }

    int m = sc.nextInt();

    for (int i = 0; i < m; i++) {
      int num = sc.nextInt();

      if (set.contains(num)) {
        System.out.print("yes ");
      } else {
        System.out.print("no ");
      }
    }
  }
}
