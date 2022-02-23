#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

int n, m, k;
vector<int> v;

int main() {
  cin >> n >> m >> k;

  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    v.push_back(x);
  }

  sort(v.begin(), v.end(), greater <>());

  int first = v[0], second = v[1];
  int answer = 0;

  for (int i = 1; i <= m; i++) {
    if (i % (k + 1) == 0) {
      answer += second;
    } else {
      answer += first;
    }
  }

  cout << answer;
}