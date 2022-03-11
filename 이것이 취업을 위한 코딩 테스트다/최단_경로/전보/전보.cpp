#include <iostream>
#include <vector>
#include <queue>
#define INF int(1e9)

using namespace std;


int main() {
  int d[30001];
  vector<pair<int, int>> graph[30001];
  priority_queue<pair<int, int>> q;
  int n, m, c, x, y, z;

  cin >> n >> m >> c;

  fill(d, d + (n + 1), INF);

  for (int i = 0; i < m ; i++) {
    cin >> x >> y >> z;
    graph[x].push_back({y, z});
  }

  q.push({0, c});
  d[c] = 0;

  while (!q.empty()) {
    int dist = -q.top().first;
    int now = q.top().second;
    q.pop();

    if (dist > d[now]) {
      continue;
    }

    for (int i = 0; i < graph[now].size(); i++) {
      int cost = graph[now][i].second;
      int next = graph[now][i].first;
      int new_cost = cost + dist;

      if (new_cost < d[next]) {
        d[next] = new_cost;

        q.push(make_pair(-new_cost, next));
      }
    }
  }
  
  int max_distance = 0, count = 0;

  for (int i = 1; i <= n; i++) {
    if (d[i] != INF) {
      count += 1;
      max_distance = max(max_distance, d[i]);
    }
  }

  cout << count - 1 << ' ' << max_distance;

  return 0;
}
