#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<vector<int>> rotate(vector<vector<int>> key) {
  int size = key.size();
  vector<vector<int>> new_key(size, vector<int>(size, 0));

  for (int row = 0; row < size; row += 1) {
    for (int column = 0; column < size; column += 1) {
      new_key[row][column] = key[size - column - 1][row];
    }
  }

  // for (int row = 0; row < size; row += 1) {
  //   for (int column = 0; column < size; column += 1) {
  //     cout << new_key[row][column];
  //   }
  // }

  return new_key;
}

vector<vector<int>> initBoard(vector<vector<int>> lock) {
  int lock_size = lock.size();
  int board_size = lock_size * 3;
  vector<vector<int>> board(board_size, vector<int>(board_size, 0));

  for (int i = lock_size; i < lock_size * 2; i++) {
    for (int j = lock_size; j < lock_size * 2; j++) {
      board[i][j] = lock[i - lock_size][j - lock_size];
    }
  }

  // for (int i = lock_size; i < lock_size * 2; i++) {
  //   for (int j = lock_size; j < lock_size * 2; j++) {
  //     cout << board[i][j];
  //   }
  // }

  return board;
}

bool check(vector<vector<int>> board) {
  int size = board.size() / 3;

  for (int i = size; i < size * 2; i++) {
    for (int j = size; j < size * 2; j++) {
      if (board[i][j] != 1) {
        return false;
      }
    }
  }

  return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {
  vector<vector<int>> board = initBoard(lock);
  int key_size = key.size();
  int lock_size = lock.size();
  int board_size = board.size();

  for (int r = 0; r < 4; r++) {
    key = rotate(key);

    for (int row = 0; row < lock_size * 2; row++) {
      for (int column = 0; column < lock_size * 2; column++) {
        for (int key_row = 0; key_row < key_size; key_row++) {
          for (int key_column = 0; key_column < key_size; key_column++) {
            board[row + key_row][column + key_column] += key[key_row][key_column];
          }
        }

        if (check(board) == true) {
          return true;
        }

        for (int key_row = 0; key_row < key_size; key_row++) {
          for (int key_column = 0; key_column < key_size; key_column++) {
            board[row + key_row][column + key_column] -= key[key_row][key_column];
          }
        }
      }
    }
  }
  return false;

  bool answer = true;
  return answer;
}