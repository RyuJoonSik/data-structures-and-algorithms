import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 문자열_재정렬 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    ArrayList<Character> str =new ArrayList<>();
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      // if (Character.isAlphabetic(s.charAt(i))) {
      if (Character.isLetter(s.charAt(i))) {
        str.add(s.charAt(i));
      } else {
        result += (s.charAt(i) - '0');
      }
    }

    Collections.sort(str);

    for (int i = 0; i < str.size(); i++) {
      System.out.print(str.get(i));
    }

    if (result != 0) {
      System.out.print(result);
    }
  }
}