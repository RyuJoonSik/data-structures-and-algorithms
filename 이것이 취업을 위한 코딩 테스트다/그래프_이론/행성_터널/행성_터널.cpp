#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
int parent[200001];
vector<pair <int, pair<int, int>>> edges;
int result;

int findParent(int x) {
  if (x != parent[x]) {
    parent[x] = findParent(parent[x]);
  }
  return parent[x];
}

void unionParent(int a, int b) {
  a = findParent(a);
  b = findParent(b);

  if (a < b) parent[b] = a;
  else parent[a] = b;
}

int main(void) {
  cin >> n;

  for (int i = 1; i<= n; i += 1) {
    parent[i] = i;
  }

  vector<pair< int, int>> x;
  vector<pair< int, int>> y;
  vector<pair< int, int>> z;

  for (int i = 1; i <= n; i += 1) {
    int a, b, c;
    cin >> a >> b >> c;
    x.push_back({a, i});
    y.push_back({b, i});
    z.push_back({c, i});
  }

  sort(x.begin(), x.end());
  sort(y.begin(), y.end());
  sort(z.begin(), z.end());

  for (int i = 0; i < n - 1; i += 1) {
    edges.push_back({x[i + 1].first - x[i].first, {x[i].second, x[i + 1].second}});
    edges.push_back({y[i + 1].first - y[i].first, {y[i].second, y[i + 1].second}});
    edges.push_back({z[i + 1].first - z[i].first, {z[i].second, z[i + 1].second}});
  }

  sort(edges.begin(), edges.end());

  for (int i = 0; i < edges.size(); i += 1) {
    int cost = edges[i].first;
    int a = edges[i].second.first;
    int b = edges[i].second.second;

    if (findParent(a) != findParent(b)) {
      unionParent(a, b);
      result += cost;
    }
  }
  cout << result;
}