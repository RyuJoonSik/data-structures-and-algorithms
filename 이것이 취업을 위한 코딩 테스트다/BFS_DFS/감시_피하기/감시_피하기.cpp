#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
char board[6][6];
vector<pair<int, int>> teachers;
vector<pair<int, int>> spaces;

bool watch(int x, int y, int direction) {
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
    while (y < n) {
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
  }
  if (direction == 3) {
    while (x < n) {
      if (board[x][y] == 'S') {
        return true;
      }
      if (board[x][y] == 'O') {
        return false;
      }
      x += 1;
    }
  }
  return false;
}

bool process() {
  for (int i = 0; i < teachers.size(); i += 1) {
    int x = teachers[i].first;
    int y = teachers[i].second;

    for (int i = 0; i < 4; i += 1) {
      if (watch(x, y, i)) {
        return true;
      }
    }
  }
  return false;
}

bool found;

int main(void) {
  cin >> n;

  for (int i = 0; i < n; i += 1) {
    for (int j = 0; j < n; j += 1) {
      cin >> board[i][j];
      if (board[i][j] == 'T') {
        teachers.push_back({i, j});
      }
      if (board[i][j] == 'X') {
        spaces.push_back({i, j});
      }
    }
  }

  vector<bool> binary(spaces.size());
  fill(binary.end() - 3, binary.end(), true);

  do {
    for (int i = 0; i < spaces.size(); i += 1) {
      if (binary[i]) {
        int x = spaces[i].first;
        int y = spaces[i].second;
        board[x][y] = 'O';
      }
    }

    if (!process()) {
      found = true;
      break;
    }

    for (int i = 0; i < spaces.size(); i += 1) {
      if (binary[i]) {
        int x = spaces[i].first;
        int y = spaces[i].second;
        board[x][y] = 'X';
      }
    }
  } while (next_permutation(binary.begin(), binary.end()));

  if (found) cout << "YES" << endl;
  else cout << "NO" << endl;
}