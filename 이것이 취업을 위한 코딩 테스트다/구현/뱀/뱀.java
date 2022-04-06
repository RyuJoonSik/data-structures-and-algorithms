import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀 {
  public static class Timer {
    public int time;
    public String direction;

    Timer(int time, String direction) {
      this.time = time;
      this.direction = direction;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int board_size = sc.nextInt();
    int[][] board = new int[board_size][board_size];

    int apple_count = sc.nextInt();
    for (int i = 0; i < apple_count; i++) {
      int row = sc.nextInt() - 1;
      int column = sc.nextInt() - 1;

      board[row][column] = 1;
    }

    // for (int i = 0; i < board_size; i++) {
    //   for (int j = 0; j < board_size; j++) {
    //     System.out.print(board[i][j] + " ");
    //   }

    //   System.out.println();
    // }

    int direction_count = sc.nextInt();
    Timer[] Timers = new Timer[direction_count];

    for (int i = 0; i < direction_count; i++) {
      int time = sc.nextInt();
      String direction = sc.next();
      Timers[i] = new Timer(time, direction);
    }

    // for (int i = 0; i < direction_count; i++) {
    //   System.out.println(Timers[i].time + " " + Timers[i].direction);
    // }

    int current_direction = 0;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int row = 0;
    int column = 0;
    int time = 0;
    int idx = 0;
    board[row][column] = 2;
    Queue<ArrayList<Integer>> snake = new LinkedList<ArrayList<Integer>>();
    ArrayList<Integer> xy = new ArrayList<Integer>();
    xy.add(0);
    xy.add(0);
    snake.add(xy);

    while (true) {
      row += dx[current_direction];
      column += dy[current_direction];
      time += 1;

      if (row < 0 || row > board_size - 1 || column < 0 || column > board_size - 1 || board[row][column] == 2) {
        break;
      }

      if (board[row][column] == 1) {
        board[row][column] = 2;
        ArrayList<Integer> new_xy = new ArrayList<Integer>();
        new_xy.add(row);
        new_xy.add(column);
        snake.offer(new_xy);
      } else if (board[row][column] == 0) {
        board[row][column] = 2;
        ArrayList<Integer> new_xy = new ArrayList<Integer>();
        new_xy.add(row);
        new_xy.add(column);
        snake.offer(new_xy);
        ArrayList<Integer> prev_xy = snake.poll();
        board[prev_xy.get(0)][prev_xy.get(1)] = 0;
      }

      for (int i = 0; i < board_size; i++) {
      for (int j = 0; j < board_size; j++) {
        System.out.print(board[i][j] + " ");
      }

      System.out.println();
    }

    System.out.println();

      if (idx < direction_count && time == Timers[idx].time) {
        if (Timers[idx].direction.equals("L")) {
          current_direction = current_direction == 0 ? 3 : current_direction - 1;
        } else {
          current_direction = current_direction == 3 ? 0 : current_direction + 1;
        }

        idx += 1;
      }
    }

    System.out.println(time);
  }
}
