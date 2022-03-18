#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int find_village(int* village, int x) {
  if (village[x] != x) {
    village[x] = find_village(village, village[x]);
  }

  return village[x];
}

void union_village(int *village, int a, int b) {
  a = find_village(village, a);
  b = find_village(village, b);

  if (a < b) {
    village[b] = a;
  } else {
    village[a] = b;
  }
}

int village[1000001];
int n, m;
int result = 0;
int last = 0;
vector<pair<int, pair<int, int>>> edge;

int main() {
  cin >> n >> m;

  for (int i = 1; 1 <= n; i++) {
    village[i] = i;
  }

  for (int i = 0; i < m; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    edge.push_back({-c, {a, b}});
  }

  sort(edge.begin(), edge.end());

  for (int i = 0; i < m; i++) {
    int cost = edge[i].first;
    int a = edge[i].second.first;
    int b = edge[i].second.second;

    if (find_village(village, a) != find_village(village, b)) {
      union_village(village, a, b);
      result += cost;
      last = cost;
    }
  }

  cout << result - last;

  return 0;
}