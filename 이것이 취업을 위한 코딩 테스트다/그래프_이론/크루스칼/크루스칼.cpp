#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int v, e;
int parent[100001];
vector<pair<int, pair<int, int>>> edges;
int result = 0;

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
  cin >> v >> e;

  for (int i = 1; i <= v; i++) {
    parent[i] = i;
  }

  for (int i = 0; i < e; i++) {
    int a, b, c;
    cin >> a >> b >> c;

    edges.push_back({c, {a, b}});
  }

  sort(edges.begin(), edges.end());

  for(int i = 0; i < edges.size(); i++) {
    int c = edges[i].first;
    int a = edges[i].second.first;
    int b = edges[i].second.second;

    if (findParent(a) != findParent(b)) {
      unionParent(a, b);
      result += c;
    }
  }

  cout << result;
}