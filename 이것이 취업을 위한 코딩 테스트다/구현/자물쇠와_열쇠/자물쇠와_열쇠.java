class Solution {
  public static int[][] rotate(int[][] key) {
    int size = key.length;
    int[][] new_key = new int[size][size];

    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        new_key[row][column] = key[size - column - 1][row];
      }
    }

    return new_key;
  }

  public static int[][] initBoard(int[][] lock) {
    int size = lock.length;
    int[][] board = new int[size * 3][size * 3];

    for (int row = size; row < size * 2; row++) {
      for (int column = size; column < size * 2; column++) {
        board[row][column] = lock[row - size][column - size];
      }
    }

    return board;
  }

  public static boolean check(int[][] board) {
    int size = board.length / 3;

    for (int row = size; row < size * 2; row++) {
      for (int column = size; column < size * 2; column++) {
        if (board[row][column] != 1) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean solution(int[][] key, int[][] lock) {
    int[][] board = initBoard(lock);
    int key_size = key.length;
    int lock_size = lock.length;

      for (int r = 0; r < 4; r++) {
        key = rotate(key);

        for (int row = 0; row < lock_size * 2; row++) {
          for (int column = 0; column < lock_size * 2; column++) {
            for (int key_row = 0; key_row < key_size; key_row++) {
              for (int key_column = 0; key_column < key_size; key_column++) {
                board[row + key_row][column + key_column] += key[key_row][key_column];
              }
            }

            if (check(board)) {
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
  }
}