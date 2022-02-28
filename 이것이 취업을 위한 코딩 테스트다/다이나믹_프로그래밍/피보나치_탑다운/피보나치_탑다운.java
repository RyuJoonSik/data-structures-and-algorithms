public class 피보나치_탑다운 {
  public static int[] d = new int[100];

  public static int fibo(int n) {
    if (n == 1 || n == 2) {
      return 1;
    }

    if (d[n] != 0) {
      return d[n];
    }

    d[n] = fibo(n - 1) + fibo(n - 2);

    return d[n];
  }
  public static void main(String[] args) {
    System.out.println(fibo(6));
  }
}