import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드_정렬하기 {
  public static int n, result;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int i = 0; i < n; i += 1) {
      pq.offer(sc.nextInt());
    }

    while (pq.size() != 1) {
      int one = pq.poll();
      int two = pq.poll();
      int summary = one + two;
      result += summary;
      pq.offer(summary);
    }

    System.out.println(result);
  }
}
