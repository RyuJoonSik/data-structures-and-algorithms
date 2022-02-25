#include<iostream>
using namespace std;

int graph[1000][1000];
int rowSize, columnSize;

bool dfs(int currentRow, int currentColumn) {
  if (currentRow <= -1 || currentRow >= rowSize || currentColumn <= -1 || currentColumn >= rowSize) {
    return false;
  }

  if (graph[currentRow][currentColumn] == 0) {
    graph[currentRow][currentColumn] == 1;
    dfs(currentRow - 1, currentColumn);
    dfs(currentRow + 1, currentColumn);
    dfs(currentRow, currentColumn - 1);
    dfs(currentRow, currentColumn + 1);

    return true;
  }

  return false;
}

int main() {
  cin >> rowSize >> columnSize;
  string str;

  for(int row = 0; row < rowSize; row++) {
    // cin.ignore();
    // cin >> str;
    
    for(int column = 0; column < columnSize; column++) {
      // graph[row][column] = str[column] - '0';
      scanf("%1d", &graph[row][column]);
    }
  }

  int answer = 0;

  for(int row = 0; row < rowSize; row++) {
    for(int column = 0; column < columnSize; column++) {
      int result = dfs(row, column);

      if (result) {
        answer++;
      }
    }
  }
  cout << answer;
  return 0;
}


