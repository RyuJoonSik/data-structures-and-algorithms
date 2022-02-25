import java.util.*;

public class 정렬_라이브러리 {
  public static void main(String[] args) {
    int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    Arrays.sort(arr);

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
