import java.util.ArrayList;
import java.util.Collections;

public class 실패율 {
  static class Node implements Comparable<Node> {
    public int stage;
    public double fail;

    Node(int stage, double fail) {
      this.stage = stage;
      this.fail = fail;
    }
    
    @Override
    public int compareTo(Node o) {
      if (this.fail == o.fail) {
        return Integer.compare(this.stage, o.stage);
      }
      return Double.compare(o.fail, this.fail);
    }
  }

  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    ArrayList<Node> arrayList = new ArrayList<>();
    int length = stages.length;

    for (int i = 1; i <= N; i += 1) {
      int cnt = 0;
      for (int j = 0; j < stages.length; j += 1) {
        if (stages[j] == i) {
          cnt += 1;
        }
      }

      double fail = 0;
      if (length >= 1) {
        fail = (double) cnt / length;
      }

      arrayList.add(new Node(i, fail));
      length -= cnt;
    }

    Collections.sort(arrayList);

    for (int i = 0; i < N; i += 1) {
      answer[i] = arrayList.get(i).stage;
    }
    return answer;
  }
}
