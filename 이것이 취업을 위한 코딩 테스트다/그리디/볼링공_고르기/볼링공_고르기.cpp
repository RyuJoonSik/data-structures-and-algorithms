#include <iostream>

using namespace std;

int main() {
  int n, m;
  int balls[11] = {0};
  cin >> n >> m;

  for (int i = 0; i < n; i++) {
    int ball;
    cin >> ball;
    balls[ball] += 1;
  }

  int result = 0;

  for (int i = 1; i <= m; i ++) {
    n -= balls[i];
    result += (balls[i] * n);
  }

  cout << result;

  return 0;
}