#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
  vector<int> fears;
  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    int fear;
    cin >> fear;

    fears.push_back(fear);
  }

  sort(fears.begin(), fears.end());

  int result = 0;
  int count = 0;

  for (int i = 0; i < n; i++) {
    count += 1;

    if (count >= fears[i]) {
      result += 1;
      count = 0;
    }
  }

  cout << result;

  return 0;
}