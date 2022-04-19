#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Node {
  public:
    int pos1X;
    int pos1Y;
    int pos2X;
    int pos2Y;

    Node(int pos1X, int pos1Y, int pos2X, int pos2Y) {
      this->pos1X = pos1X;
      this->pos1Y = pos1Y;
      this->pos2X = pos2X;
      this->pos2Y = pos2Y;
    }
};

vector<Node> getNextPos(Node pos, vector<vector<int>> board) {
  vector<Node> nextPos;
  int dx[] = {-1, 1, 0, 0};
  int dy[] = {0, 0, -1, 1};
  for (int i = 0; i < 4; i += 1) {
    int pos1NextX = pos.pos1X + dx[i];
    int pos1NextY = pos.pos1Y + dy[i];
    int pos2NextX = pos.pos2X + dx[i];
    int pos2NextY = pos.pos2Y + dy[i];

    if (board[pos1NextX][pos1NextY] == 0 && board[pos2NextX][pos2NextY] == 0) {
      nextPos.push_back(Node(pos1NextX, pos1NextY, pos2NextX, pos2NextY));
    }
  }
  int hor[] = {-1, 1};
  if (pos.pos1X == pos.pos2X) {
    for (int i = 0; i < 2; i += 1) {
      if (board[pos.pos1X + hor[i]][pos.pos1Y] == 0 && board[pos.pos2X + hor[i]][pos.pos2Y] == 0) {
        nextPos.push_back(Node(pos.pos1X, pos.pos1Y, pos.pos1X + hor[i], pos.pos1Y));
        nextPos.push_back(Node(pos.pos2X, pos.pos2Y, pos.pos2X + hor[i], pos.pos2Y));
      }
    }
  }
  int ver[] = {-1, 1};
  if (pos.pos1Y == pos.pos2Y) {
    for (int i = 0; i < 2; i += 1) {
      if (board[pos.pos1X][pos.pos1Y + ver[i]] == 0 && board[pos.pos2X][pos.pos2Y + ver[i]] == 0) {
        nextPos.push_back(Node(pos.pos1X, pos.pos1Y, pos.pos1X, pos.pos1Y + ver[i]));
        nextPos.push_back(Node(pos.pos2X, pos.pos2Y, pos.pos2X, pos.pos2Y + ver[i]));
      }
    }
  }
  return nextPos;
}

int solution(vector<vector<int>> board) {
  int n = board.size();
  vector<vector<int>> newBoard(n + 2, vector<int>(n + 2, 1));
  for (int i = 0; i < n; i += 1) {
    for (int j = 0; j < n; j += 1) {
      newBoard[i + 1][j + 1] = board[i][j];
    }
  }
  queue<pair<Node, int>> q;
  vector<Node> visited;
  Node pos = Node(1, 1, 1, 2);
  q.push({pos, 0});
  visited.push_back(pos);
  while (!q.empty()) {
    Node pos = q.front().first;
    int cost = q.front().second;
    q.pop();
    if ((pos.pos1X == n && pos.pos1Y == n) || (pos.pos2X == n && pos.pos2Y == n)) {
      return cost;
    }
    vector<Node> nextPos = getNextPos(pos, newBoard);
    for (int i = 0; i < nextPos.size(); i += 1) {
      bool check = true;
      Node pos = nextPos[i];
      for (int j = 0; j < visited.size(); j += 1) {
        if (pos.pos1X == visited[j].pos1X && pos.pos1Y == visited[j].pos1Y && pos.pos2X == visited[j].pos2X && pos.pos2Y == visited[j].pos2Y) {
          check = false;
          break;
        }
      }
      if (check) {
        q.push({pos, cost + 1});
        visited.push_back(pos);
      }
    }
  }
  return 0;
}