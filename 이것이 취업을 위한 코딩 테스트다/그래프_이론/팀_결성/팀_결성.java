import java.util.Scanner;

public class 팀_결성 {
  public static int n, m;
  public static int[] team = new int[100001];

  public static int find_team(int x) {
    if (team[x] != x) {
      team[x] = find_team(team[x]);
    }

    return team[x];
  }

  public static void union_team(int a, int b) {
    a = find_team(a);
    b = find_team(b);

    if (a < b) {
      team[b] = a;
    } else {
      team[a] = b;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();

    for (int i = 0; i <= n; i++) {
      team[i] = i;
    }

    for (int i = 0; i < m; i++) {
      int type = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();

      if(type == 1) {
        if (find_team(a) == find_team(b)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      } else {
        union_team(a, b);
      }
    }
  }
}
