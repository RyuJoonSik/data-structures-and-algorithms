import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 블록_이동하기 {
  static class Node {
    public int pos1X;
    public int pos1Y;
    public int pos2X;
    public int pos2Y;
    public int distance;

    Node (int pos1X, int pos1Y, int pos2X, int pos2Y, int distance) {
      this.pos1X = pos1X;
      this.pos1Y = pos1Y;
      this.pos2X = pos2X;
      this.pos2Y = pos2Y;
      this.distance = distance;
    }
  }

  public ArrayList<Node> getNextPos (Node pos, int[][] board) {
    ArrayList<Node> nextPos = new ArrayList<Node>();
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    for (int i = 0; i < 4; i += 1) {
      int pos1NextX = pos.pos1X + dx[i];
      int pos1NextY = pos.pos1Y + dy[i];
      int pos2NextX = pos.pos2X + dx[i];
      int pos2NextY = pos.pos2Y + dy[i];
      int distanceNext = pos.distance + 1;

      if (board[pos1NextX][pos1NextY] == 0 && board[pos2NextX][pos2NextY] == 0) {
        nextPos.add(new Node(pos1NextX, pos1NextY, pos2NextX, pos2NextY, distanceNext));
      }
    }
    
    int[] hor = {-1, 1};
    if (pos.pos1X == pos.pos2X) {
      for (int i = 0; i < 2; i += 1) {
        if (board[pos.pos1X + hor[i]][pos.pos1Y] == 0 && board[pos.pos2X + hor[i]][pos.pos2Y] == 0) {
          nextPos.add(new Node(pos.pos1X, pos.pos1Y, pos.pos1X + hor[i], pos.pos1Y, pos.distance + 1));
          nextPos.add(new Node(pos.pos2X, pos.pos2Y, pos.pos2X + hor[i], pos.pos2Y, pos.distance + 1));
        }
      }
    }

    int[] ver = {-1, 1};
    if (pos.pos1Y == pos.pos2Y) {
      for (int i = 0; i < 2; i += 1) {
        if (board[pos.pos1X][pos.pos1Y + ver[i]] == 0 && board[pos.pos2X][pos.pos2Y + ver[i]] == 0) {
          nextPos.add(new Node(pos.pos1X, pos.pos1Y, pos.pos1X, pos.pos1Y + ver[i], pos.distance + 1));
          nextPos.add(new Node(pos.pos2X, pos.pos2Y, pos.pos2X, pos.pos2Y + ver[i], pos.distance + 1));
        }
      }
    }
    return nextPos;
  }

  public int solution(int[][] board) {
    int n = board.length;
    int[][] newBoard = new int[n + 2][n + 2];
    for (int i = 0; i < n + 2; i += 1) {
      for (int j = 0; j < n + 2; j += 1) {
        newBoard[i][j] = 1;
      }
    }
    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n; j += 1) {
        newBoard[i + 1][j + 1] = board[i][j];
      }
    }
    Queue<Node> q = new LinkedList<>();
    ArrayList<Node> visited = new ArrayList<>();
    Node pos = new Node(1, 1, 1, 2, 0);
    q.offer(pos);
    visited.add(pos);
    while (!q.isEmpty()) {
      pos = q.poll();
      if ((pos.pos1X == n && pos.pos1Y == n) || (pos.pos2X == n && pos.pos2Y == n)) {
        return pos.distance;
      }
      ArrayList<Node> nextPos = getNextPos(pos, newBoard);
      for (int i = 0; i < nextPos.size(); i += 1) {
        boolean check = true;
        pos = nextPos.get(i);
        for (int j = 0; j < visited.size(); j += 1) {
          if (pos.pos1X == visited.get(j).pos1X && pos.pos1Y == visited.get(j).pos1Y && pos.pos2X == visited.get(j).pos2X && pos.pos2Y == visited.get(j).pos2Y) {
            check = false;
            break;
          }
        }
        if (check) {
          q.offer(pos);
          visited.add(pos);
        }
      }
    }
    return 0;
  }
}

