import java.util.Scanner;

public class 부품_찾기_계수_정렬 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] store = new int[1000001];
    
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      store[num] = 1;
    }

    int m = sc.nextInt();

    for (int i = 0; i < m; i++) {
      int num = sc.nextInt();

      if (store[num] == 1)  {
        System.out.print("yes ");
      } else {
        System.out.print("no ");
      }
    }
  }
}