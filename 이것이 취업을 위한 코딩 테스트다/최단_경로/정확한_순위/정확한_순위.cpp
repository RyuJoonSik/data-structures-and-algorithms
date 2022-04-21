#include <iostream>
#define INF 1e9

using namespace std;

int n, m;
int graph[501][501];

int main(void) {
  cin >> n >> m;

  for (int i = 0; i < 501; i += 1) {
    fill(graph[i], graph[i] + 501, INF);
  }

  for (int a = 1; a <= n; a += 1) {
    for (int b = 1; b <= n; b += 1) {
      if (a == b) graph[a][b] = 0;
    }
  }

  for (int i = 0; i < m; i += 1) {
    int a, b;
    cin >> a >> b;
    graph[a][b] = 1;
  }

  for (int k = 1; k <= n; k += 1) {
    for (int a = 1; a <= n; a += 1) {
      for (int b = 1; b <= n; b += 1) {
        graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
      }
    }
  }

  int result = 0;

  for (int i = 1; i <= n; i += 1) {
    int cnt = 0;
    for (int j = 1; j <= n; j += 1) {
      if (graph[i][j] != INF || graph[j][i] != INF) {
        cnt += 1;
      }
    }

    if (cnt == n) {
      result += 1;
    }
  }

  cout << result << endl;
}