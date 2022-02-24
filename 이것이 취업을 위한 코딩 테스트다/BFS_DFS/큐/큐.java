import java.util.LinkedList;
import java.util.Queue;

public class 큐 {
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();

    q.offer(1);
    q.offer(2);
    q.offer(3);
    q.offer(4);
    q.offer(5);

    while (!q.isEmpty()) {
      int value = q.poll();
      System.out.println(value);
    }
  }
}
