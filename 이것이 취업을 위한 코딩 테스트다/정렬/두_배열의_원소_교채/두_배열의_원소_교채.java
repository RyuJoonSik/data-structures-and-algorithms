import java.util.*;

public class 두_배열의_원소_교채 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    int max = sc.nextInt();
    Integer[] a = new Integer[size];
    Integer[] b = new Integer[size];

    for (int i = 0; i < size; i++) {
      a[i] = sc.nextInt();
    }

    for (int i = 0; i < size; i++) {
      b[i] = sc.nextInt();
    }

    Arrays.sort(a);
    Arrays.sort(b, Collections.reverseOrder());

    int answer = 0;

    for (int i = 0; i < max; i++) {
      if (a[i] < b[i]) {
        a[i] = b[i];
      } else {
        break;
      }
    }

    for (int i = 0; i < size; i++) {
      answer += a[i];
    }
    
    System.out.println(answer);
  }
}
