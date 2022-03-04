#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n, m, num;
  cin >> n >> m;
  vector<int> arr;
  vector<int> dp(m + 1, 10001);
  dp[0] = 0;

  for (int i = 0; i < n; i++) {
    cin >> num;
    arr.push_back(num);
  }

  for (int i = 0; i < n; i++) {
    int count = arr[i];

    for (int j = count; j <= m; j++) {
      dp[j] = min(dp[j], dp[j - count] + 1);
    }
  }

  if (dp[m] == 10001) {
    cout << -1;
  } else {
    cout << dp[m];
  }

  return 0;
}