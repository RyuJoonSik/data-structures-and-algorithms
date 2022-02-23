#include <iostream>
#include <string>

using namespace std;

int main() {
  int n, m;
  cin >> n >> m;

  int currentRow, currentColumn, currentDirection;
  cin >> currentRow >> currentColumn >> currentDirection;
  cin.ignore();

  int check[50][50];
  int arr[50][50];
  int temp;
  check[1][1] = 1;
  
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cin >> temp;
      arr[i][j] = temp;
    }
  }

  int row[] = {-1, 0, 1, 0};
  int column[] = {0, 1, 0, -1};
  int nextRow, nextColumn, nextDirection;
  int count = 0;
  int answer = 1;

  while (true) {
    if (count == 4 ) {
      nextRow = currentRow - row[nextDirection];
      nextColumn = currentColumn - column[nextDirection];

      if (arr[nextRow][nextColumn] == 1) {
        break;
      } else {
        currentRow = nextRow;
        currentColumn = nextColumn;
        count = 0;
      }
    }

    nextDirection = currentDirection == 0 ? 3 : currentDirection - 1;
    cout << nextDirection << endl;
    nextRow = currentRow + row[nextDirection];
    nextColumn = currentColumn + column[nextDirection];
    cout << currentRow << " " << currentColumn << endl;

    if (arr[nextRow][nextColumn] == 0 && check[nextRow][nextColumn] == 0) {
      answer++;
      count = 0;
      check[nextRow][nextColumn] = 1;
      currentRow = nextRow;
      currentColumn = nextColumn;
      currentDirection = nextDirection;

      continue;
    } else {
      count++;
      currentDirection = nextDirection;
    }

  }

  cout << answer;
}