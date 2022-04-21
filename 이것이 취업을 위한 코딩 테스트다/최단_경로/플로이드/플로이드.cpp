#include <iostream>
#define INF 1e9

using namespace std;

int n, m;
int graph[101][101];

int main(void) {
  cin >> n >> m;

  for (int i = 0; i < 101; i += 1) {
    fill(graph[i], graph[i] + 101, INF);
  }

  for (int a = 1; a <= n; a += 1) {
    for (int b = 1; b <= n; b += 1) {
      if (a == b) graph[a][b] = 0;
    }
  }

  for (int i = 0; i < m; i += 1) {
    int a, b, c;
    cin >> a >> b >> c;
    if (c < graph[a][b]) graph[a][b] = c;
  }

  for (int k = 1; k <= n; k += 1) {
    for (int a = 1; a <= n; a += 1) {
      for (int b = 1; b <= n; b += 1) {
        graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
      }
    }
  }

  for (int a = 1; a <= n; a += 1) {
    for (int b = 1; b <= n; b += 1) {
      if (graph[a][b] == INF) {
        cout << 0 << ' ';
      } else {
        cout << graph[a][b] << ' ';
      }
    }
    cout << endl;
  }
}