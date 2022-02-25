#include <iostream>
#include <queue>
using namespace std;

int rowSize, columnSize;
int graph[201][201];

void bfs(int newRow, int newColumn) {
  int row[] = {-1, 1, 0, 0};
  int column[] = {0, 0, -1, 1};
  
  queue<pair<int, int>> q;
  q.push({newRow, newColumn});

  while(!q.empty()) {
    int currentRow = q.front().first;
    int currentColumn = q.front().second;
    q.pop();
    for (int i = 0; i < 4; i++) {
      int nextRow = currentRow + row[i];
      int nextColumn = currentColumn + column[i];

      if (-1 >= nextRow || nextRow >= rowSize || -1 >= nextColumn || nextColumn >= columnSize) {
        continue;
      }

      if (graph[nextRow][nextColumn] == 1) {
        graph[nextRow][nextColumn] = graph[currentRow][currentColumn] + 1;
        q.push({nextRow, nextColumn});
      }
    }
  }
}

int main() {
  cin >> rowSize >> columnSize;

  for (int row = 0; row < rowSize; row++) {
    for (int column = 0; column < columnSize; column++) {
      scanf("%1d", &graph[row][column]);
    }
  }

  bfs(0, 0);

  cout << graph[rowSize -1][columnSize - 1];
}