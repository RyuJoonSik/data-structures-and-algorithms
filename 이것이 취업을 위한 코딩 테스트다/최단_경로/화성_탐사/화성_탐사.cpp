#include <iostream>
#include <queue>
#define INF 1e9

using namespace std;

int testCase, n;
int graph[125][125], d[125][125];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

int main(void) {
  cin >> testCase;

  for (int tc = 0; tc < testCase; tc += 1) {
    cin >> n;

    for (int i = 0; i < n; i += 1) {
      for (int j = 0; j < n; j += 1) {
        cin >> graph[i][j];
      }
    }

    for (int i = 0; i < n; i += 1) {
      fill(d[i], d[i] + 125, INF);
    }

    int x = 0, y = 0;

    priority_queue<pair<int, pair<int, int>>> pq;
    pq.push({-graph[x][y], {0, 0}});
    d[x][y] = graph[x][y];

    while (!pq.empty()) {
      int dist = -pq.top().first;
      int x = pq.top().second.first;
      int y = pq.top().second.second;
      pq.pop();

      if (d[x][y] < dist) continue;

      for (int i = 0; i < 4; i += 1) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

        int cost = dist + graph[nx][ny];

        if (cost < d[nx][ny]) {
          d[nx][ny] = cost;
          pq.push({-cost, {nx, ny}});
        }
      }
    }

    cout << d[n - 1][n - 1] << endl;
  }
}