import java.util.ArrayList;
import java.util.Scanner;

public class 여행_계획 {
  public static int n, m;
  public static int[] parent = new int[501];

  public static int findParent(int x) {
    if (x != parent[x]) {
      x = parent[x];
    }

    return x;
  }

  public static void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    if (a < b) parent[b] = a;
    else parent[a] = b;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    for (int i = 1; i <= n; i += 1) {
      parent[i] = i;
    }

    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n; j += 1) {
        int x = sc.nextInt();

        if (x == 1) {
          unionParent(i + 1, j + 1);
        }
      }
    }

    ArrayList<Integer> plan = new ArrayList<>();
    for (int i = 0; i < m; i += 1) {
      int x = sc.nextInt();
      plan.add(x);
    }

    boolean result = true;
    for (int i = 0; i < m - 1; i += 1) {
      if (findParent(plan.get(i)) != findParent(plan.get(i + 1))) {
        result = false;
      }
    }

    if (result) System.out.println("YES");
    else System.out.println("NO");
  }
}
