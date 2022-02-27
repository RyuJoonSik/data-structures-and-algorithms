import java.util.*;

public class 부품_찾기_이진_탐색 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int[] store = new int[n];

    for (int i = 0; i < n; i++) {
      store[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    int[] customer = new int[m];

    for (int i = 0; i < m; i++) {
      customer[i] = sc.nextInt();
    }

    Arrays.sort(store);
    Arrays.sort(customer);

    for (int target: customer) {
      int start = 0, end = n - 1;
      String result = "no";
      while (start <= end) {
        int mid = (start + end) / 2;

        if (store[mid] == target) {
          result = "yes";
          break;
        } else if (store[mid] > target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
      System.out.print(result + " ");
    }
  }
}
