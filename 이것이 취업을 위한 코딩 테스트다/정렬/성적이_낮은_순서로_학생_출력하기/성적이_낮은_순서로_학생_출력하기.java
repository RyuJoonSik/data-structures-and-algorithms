import java.util.*;

public class 성적이_낮은_순서로_학생_출력하기 {
  static class Student implements Comparable<Student>{
    public String name;
    public int score;
  
    Student(String name, int score) {
      this.name = name;
      this.score = score;
    }
  
    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
          return - 1;
        }
  
        return 1;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<Student> info = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String name = sc.next();
      int score = sc.nextInt();
      info.add(new Student(name, score));
    }

    Collections.sort(info);

    for(Student student : info) {
      System.out.print(student.name + " ");
    }
  }
}
