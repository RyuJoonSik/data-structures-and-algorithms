import java.util.Scanner;

public class 탑승구 {
  public static int g, p;
  public static int[] parent = new int[100001];

  public static int findParent(int x) {
    if (x != parent[x]) {
      x = findParent(parent[x]);
    }
    return parent[x];
  }

  public static void unionParent(int a, int b) {
    a = findParent(a);
    b = findParent(b);

    if (a < b) {
      parent[b] = a;
    } else {
      parent[a] = b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    g = sc.nextInt();
    p = sc.nextInt();

    for (int i = 1; i <= g; i += 1) {
      parent[i] = i;
    }

    int result = 0;
    for (int i = 0; i < p; i += 1) {
      int x = sc.nextInt();
      int root = findParent(x);

      if (root == 0) break;
      unionParent(root, root - 1);
      result += 1;
    }
    System.out.println(result);
  }
}
