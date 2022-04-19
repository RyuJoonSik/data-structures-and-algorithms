import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 국영수 {
  static class Student implements Comparable<Student> {
    public String name;
    public int kor;
    public int eng;
    public int m;

    Student(String name, int kor, int eng, int m) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.m = m;
    }

    @Override
    public int compareTo(국영수.Student other) {
      if (this.kor == other.kor && this.eng == other.eng && this.m == other.m) {
        return this.name.compareTo(other.name);
      }
      if (this.kor == other.kor && this.eng == other.eng) {
        return Integer.compare(other.m, this.m);
      }
      if (this.kor == other.kor) {
        return Integer.compare(this.eng, other.eng);
      }
      return Integer.compare(other.kor, this.kor);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    ArrayList<Student> students = new ArrayList<>();
    for (int i = 0; i < n; i += 1) {
      String name = sc.next();
      int kor = sc.nextInt();
      int eng = sc.nextInt();
      int m = sc.nextInt();
      students.add(new Student(name, kor, eng, m));
    }

    Collections.sort(students);

    for (int i = 0; i < n; i += 1) {
      System.out.println(students.get(i).name);
    }
  }
}
