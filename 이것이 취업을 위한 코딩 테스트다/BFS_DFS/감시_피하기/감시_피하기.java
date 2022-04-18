import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.Position;

public class 감시_피하기 {
  static class Combination {
    public int n;
    public int r;
    public int[] now;
    public ArrayList<ArrayList<Position>> result;

    Combination(int n, int r) {
      this.n = n;
      this.r = r;
      this.now = new int[r];
      this.result = new ArrayList<ArrayList<Position>>();
    }

    void combination(ArrayList<Position> arr, int depth, int index, int target) {
      if (depth == r) {
        ArrayList<Position> temp = new ArrayList<>();
        for (int i = 0; i < now.length; i += 1) {
          temp.add(arr.get(now[i]));
        }
        result.add(temp);
        return;
      }
      if (target == n) return;
      now[index] = target;
      combination(arr, depth + 1, index + 1, target + 1);
      combination(arr, depth, index, target + 1);
    }
  }

  static class Position {
    public int x;
    public int y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int n;
  public static char[][] board = new char[6][6];
  public static ArrayList<Position> teachers = new ArrayList<>();
  public static ArrayList<Position> spaces = new ArrayList<>();

  public static boolean watch(int x, int y, int direction) {
    if (direction == 0) {
      while (y >= 0) {
        if (board[x][y] == 'S') {
          return true;
        }
        if (board[x][y] == 'O') {
          return false;
        }
        y -= 1;
      }
    }
    if (direction == 1) {
      while (y < 0) {
        if (board[x][y] == 'S') {
          return true;
        }
        if (board[x][y] == 'O') {
          return false;
        }
        y += 1;
      }
    }
    if (direction == 2) {
      while (x >= 0) {
        if (board[x][y] == 'S') {
          return true;
        }
        if (board[x][y] == 'O') {
          return false;
        }
        x -= 1;
      }
      if (direction == 3) {
        while (x < 0) {
          if (board[x][y] == 'S') {
            return true;
          }
          if (board[x][y] == 'O') {
            return false;
          }
          x += 1;
        }
      }
    }
    return false;
  }

  public static boolean process() {
    for (int i = 0; i < teachers.size(); i += 1) {
      int x = teachers.get(i).x;
      int y = teachers.get(i).y;

      for (int j = 0; j < 4; j += 1) {
        if (watch(x, y, j)) {
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();

    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n ; j += 1) {
        board[i][j] = sc.next().charAt(0);
        if (board[i][j] == 'T') {
          teachers.add(new Position(i, j));
        }
        if (board[i][j] == 'X') {
          spaces.add(new Position(i, j));
        }
      }
    }

    Combination comb = new Combination(spaces.size(), 3);
    comb.combination(spaces, 0, 0, 0);
    ArrayList<ArrayList<Position>> spaceList = comb.result;

    boolean found = false;
    for (int i = 0; i < spaceList.size(); i += 1) {
      for (int j = 0; j < spaceList.get(i).size(); j += 1) {
        int x = spaceList.get(i).get(j).x;
        int y = spaceList.get(i).get(j).y;
        board[x][y] = 'O';
      }

      if (!process()) {
        found = true;
        break;
      }

      for (int j = 0; j < spaceList.get(i).size(); j += 1) {
        int x = spaceList.get(i).get(j).x;
        int y = spaceList.get(i).get(j).y;
        board[x][y] = 'X';
      }
    }

    if (found) System.out.println("YES");
    else System.out.println("NO");
  }
}
