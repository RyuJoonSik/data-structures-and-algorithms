#include <iostream>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;

int n, m;
int start = 1;
vector<pair<int, int>> graph[20001];
int d[20001];

void dijkstra(int start) {
  priority_queue<pair<int, int>> pq;
  pq.push({0, start});
  d[start] = 0;

  while (!pq.empty()) {
    int dist = -pq.top().first;
    int now = pq.top().second;
    pq.pop();

    if (d[now] < dist) continue;

    for (int i = 0; i < graph[now].size(); i += 1) {
      int cost = dist + graph[now][i].second;

      if (cost < d[graph[now][i].first]) {
        d[graph[now][i].first] = cost;
        pq.push({-cost, graph[now][i].first});
      }
    }
  }
}

int main(void) {
  cin >> n >> m;

  for (int i = 0; i < m; i += 1) {
    int a, b;
    cin >> a >> b;
    graph[a].push_back({b, 1});
    graph[b].push_back({a, 1});
  }

  fill(d, d + 20001, INF);

  dijkstra(start);

  int maxNode = 0;
  int maxDistance = 0;
  vector<int> result;

  for (int i = 1; i <= n; i += 1) {
    if (maxDistance < d[i]) {
      maxNode = i;
      maxDistance = d[i];
      result.clear();
      result.push_back(maxNode);
    }
    else if (maxDistance == d[i]) {
      result.push_back(i);
    }
  }

  cout << maxNode << ' ' << maxDistance << ' ' << result.size() << endl;
}