#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int arr[101][101];

int main() {
  int board_size;
  cin >> board_size;

  int apple_count;
  cin >> apple_count;

  for (int i = 0; i < apple_count; i++) {
    int row, column;
    cin >> row >> column;
    arr[row - 1][column - 1] = 1;
  }

  int direction_count;
  cin >> direction_count;

  vector<pair<int, char>> timer;

  for (int i = 0; i < direction_count; i++) {
    int time;
    char direction;
    cin >> time >> direction;
    timer.push_back({time, direction});
  }

  int rows[] = {0, 1, 0, -1};
  int columns[] = {1, 0, -1, 0}; 
  int row = 0;
  int column = 0;
  int time = 0;
  int direction = 0;
  int idx = 0;
  arr[row][column] = 2;
  queue<pair<int, int>> snake;
  snake.push({0, 0});


  while (true) {
    time += 1;
    row += rows[direction];
    column += columns[direction];

    if (row < 0 || row > board_size - 1 || column < 0 || column > board_size - 1 || arr[row][column] == 2) {
      break;
    }

    if (arr[row][column] == 1) {
      snake.push({row, column});
      arr[row][column] = 2;
    } else if (arr[row][column] == 0) {
      arr[row][column] = 2;
      snake.push({row, column});
      arr[snake.front().first][snake.front().second] = 0;
      snake.pop();
    }

    if (idx < direction_count && timer[idx].first == time) {
      if (timer[idx].second == 'L') {
        direction = (direction == 0)? 3 : direction - 1;
      } else {
        direction = (direction + 1) % 4;
      }

      idx += 1;
    }
  }

  cout << time;

  return 0;
}