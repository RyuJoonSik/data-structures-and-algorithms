#include <iostream>

using namespace std;

int find_team(int* team, int x) {
  if (team[x] != x) {
    team[x] = find_team(team, team[x]);
  }

  return team[x];
}

void union_team(int* team, int a, int b) {
  a = find_team(team, a);
  b = find_team(team, b);

  if (a < b) {
    team[b] = a;
  } else {
    team[a] = b;
  }
}

int main() {
  int team[100001];
  int n, m;
  cin >> n >> m;

  for (int i = 0; i <= n; i++) {
    team[i] = i;
  }

  for (int i = 0; i < m; i++) {
    int type, a, b;
    cin >> type >> a >> b;

    if (type) {
      if (find_team(team, a) == find_team(team, b)) {
        cout << "YES\n";
      } else {
        cout << "NO\n";
      }
    } else {
      union_team(team, a, b);
    }
  }

  return 0;
}