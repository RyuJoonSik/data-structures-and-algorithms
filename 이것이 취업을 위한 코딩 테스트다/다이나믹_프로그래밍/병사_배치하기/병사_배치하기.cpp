#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> v;

int main(void) {
  cin >> n;

  for (int i = 0; i < n; i += 1) {
    int x;
    cin >> x;
    v.push_back(x);
  }

  reverse(v.begin(), v.end());

  int dp[2000];
  for (int i = 0; i < n; i += 1) {
    dp[i] = 1;
  }

  for (int i = 1; i < n; i += 1) {
    for (int j = 0; j < i; j += 1) {
      if (v[j] < v[i]) {
        dp[i] = max(dp[i], dp[j] + 1);
      }
    }
  }

  int maxValue = 0;
  for (int i = 0; i < n; i += 1) {
    maxValue = max(maxValue, dp[i]);
  }

  cout << n - maxValue << endl;
}