public class 선택_정렬 {
  public static void main(String[] args) {
    int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    for (int i = 0; i < 10; i++) {
      int minIndex = i;

      for (int j = i + 1; j < 10; j++) {
        if (arr[minIndex] > arr[j]) {
          minIndex = j;
        }
      }

      int temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }

    for (int num: arr) {
      System.out.print(num + " ");
    }
  }
}
