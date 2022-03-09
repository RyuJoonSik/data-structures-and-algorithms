#include <iostream>
#include <vector>
#define INF 1e9

using namespace std;


int n, m, start;
vector<pair<int, int>> graph[100001];
bool visited[1000001];
int d [1000001];

int getSamllestNode() {
  int min_value = INF;
  int index = 0;
  for (int i = 1; i <= n; i++) {
    if (d[i] < min_value && !visited[i]) {
      min_value = d[i];
      index = i;
    }
  }
  return index;
}

void dijkstart(int start) {
  d[start] = 0;
  visited[start] = true;

  for (int j = 0; j < graph[start].size(); j++) {
    int node = graph[start][j].first;
    int cost = graph[start][j].second;

    d[node] = cost;
  }

  for (int i = 0; i < n - 1; i++) {
    int now = getSamllestNode();
    visited[now] = true;

    for (int j = 0; j < graph[now].size(); j++) {
      int node = graph[now][j].first;
      int new_cost = d[now] + graph[now][j].second;

      if (new_cost < d[node]) {
        d[node] = new_cost;
      }
    }
  }
}

int main() {
  cin >> n >> m >> start;
  
  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;

    graph[a].push_back({b, c});
  }

  fill_n(d, 100001, INF);

  dijkstart(1);

  for (int i = 1; i <= n; i++) {
    if (d[i] == INF) {
      cout << "INFINITY" << '\n';
    } else {
      cout << d[i] << '\n';
    }
  }

  return 0;
}