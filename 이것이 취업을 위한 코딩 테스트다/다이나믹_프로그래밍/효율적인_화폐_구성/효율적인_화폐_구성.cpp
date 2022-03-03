#include <iostream>
using namespace std;

int main() {
  int arr[1001] = {0};
  int dp[1001] = {1001};
  dp[0] = 0;
  int n, m, num;
  cin >> n >> m;
  
    for (int i = 0; i < m; i++) {
    // cout << arr[i] << ' ';
    cout << dp[i] << ' ';
  }
  for (int i = 0; i < n; i++) {
    cin >> num;
    arr[i] = num;
  }

  // for (int i = 0; i < n; i++) {
  //   int count = arr[i];
  //   // cout << count << ' ';

  //   for (int j = count; j <= m; j++) {
  //     dp[j] = min(dp[j], dp[j - count] + 1);
  //     cout << dp[j] << ':' << dp[j - count] + 1 << endl;
  //   }
  // }
  // for (int i = 0; i < n; i++) {
    // cout << arr[i] << ' ';
    // cout << dp[i] << ' ';
  // }
  // if (dp[m] == 1001) {
  //   cout << -1;
  // } else {
  //   cout << dp[m];
  // }

  return 0;
}