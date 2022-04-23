#include <iostream>
#include <vector>

using namespace std;

int n, m;
int parent[501];

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
  cin >> n >> m;

  for (int i = 1; i <= n; i += 1) {
    parent[i] = i;
  }

  for (int i = 0; i < n; i += 1) {
    for (int j = 0; j < n; j += 1) {
      int x;
      cin >> x;
      if (x == 1) {
        unionParent(i + 1, j + 1);
      }
    }
  }

  vector<int> plan;
  for (int i = 0; i < m; i += 1) {
    int x;
    cin >> x;
    plan.push_back(x);
  }

  bool result = true;

  for (int i = 0; i < m - 1; i += 1) {
    if (findParent(plan[i]) != findParent(plan[i + 1])) {
      result = false;
    }
  }

  if (result) cout << "YES" << endl;
  else cout << "NO" << endl;
}

