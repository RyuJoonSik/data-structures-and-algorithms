public class 피보나치_보텀업 {
  public static void main(String[] args) {
    long[] d = new long[100];
    int n = 50;
    d[1] = 1;
    d[2] = 1;

    for (int i = 3; i <= n; i++) {
      d[i] = d[i - 1] + d[i - 2];
    }

    System.out.println(d[n]);
  }
}
