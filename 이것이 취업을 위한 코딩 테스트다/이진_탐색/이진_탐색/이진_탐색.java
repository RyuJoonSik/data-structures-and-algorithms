import java.util.Scanner;

public class 이진_탐색 {
  public static int loop_binary_search(int[] array, int target, int start, int end) {
    while (start <= end) {
      int mid = (start + end) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  public static int recursive_binary_search(int[] array, int target, int start, int end) {
    if (start > end) {
      return -1;
    }

    int mid = (start + end) / 2;
    if (array[mid] == target) {
      return mid;
    } else if (array[mid] > target) {
      return recursive_binary_search(array, target, start, mid - 1);
    } else {
      return recursive_binary_search(array, target, mid + 1, end);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int target = sc.nextInt();
    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      array[i] = sc.nextInt();
    }

    // int result = loop_binary_search(array, target, 0, n - 1);
    int result = recursive_binary_search(array, target, 0, n - 1);

    if (result == -1) {
      System.out.println("no result");
    } else {
      System.out.println(result + 1);
    }
  }
}
