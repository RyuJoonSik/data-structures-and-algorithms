#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, l, r;

int graph[50][50];
int unions[50][50];

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

void process(int x, int y, int index) {
  vector<pair<int, int>> united;
  united.push_back({x, y});
  queue<pair<int, int>> q;
  q.push({x, y});
  unions[x][y] = index;
  int summary = graph[x][y];
  int count = 1;

  while (!q.empty()) {
    int x = q.front().first;
    int y = q.front().second;
    q.pop();
    for (int i = 0; i < 4; i += 1) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
        int gap = abs(graph[nx][ny] - graph[x][y]);
        if (l <= gap && gap <= r) {
          q.push({nx, ny});
          unions[nx][ny] = index;
          summary += graph[nx][ny];
          count += 1;
          united.push_back({nx, ny});
        }
      }
    }
  }
  for (int i = 0; i < united.size(); i += 1) {
    int x = united[i].first;
    int y = united[i].second;
    graph[x][y] = summary / count;
  }
}

int totalCount = 0;

int main(void) {
  cin >> n >> l >> r;

  for (int i = 0; i < n; i += 1) {
    for (int j = 0; j < n; j += 1) {
      cin >> graph[i][j];
    }
  }

  while (true) {
    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n; j += 1) {
        unions[i][j] = -1;
      }
    }

    int index = 0;
    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n; j += 1) {
        if (unions[i][j] == -1) {
          process(i, j, index);
          index += 1;
        }
      }
    }

    if (index == n * n) break;
    totalCount += 1;
  }

  cout << totalCount << endl;
}