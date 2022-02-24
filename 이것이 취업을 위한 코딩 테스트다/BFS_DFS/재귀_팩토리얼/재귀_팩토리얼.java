public class 재귀_팩토리얼 {
  public static void main(String[] args) {
    int num = 5;
    System.out.println(factorial_1(num));
    System.out.println(factorial_2(num));
  }
  
  public static int factorial_1(int num) {
    if (num <= 1) {
      return 1;
    }
  
    return num * factorial_1(num - 1);
  }
  
  public static int factorial_2(int num) {
    int result = 1;
  
    for (int i = 1; i <= num; i++) {
      result *= i;  
    }
  
    return result;
  }

}
