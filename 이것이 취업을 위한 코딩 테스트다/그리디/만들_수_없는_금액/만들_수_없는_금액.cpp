#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
  int n;
  vector<int> coins;
  cin >> n;

  for (int i = 0; i < n; i++) {
    int coin;
    cin >> coin;

    coins.push_back(coin);
  }

  sort(coins.begin(), coins.end());

  int target = 1;

  for (int i = 0; i < n; i++) {
    if (target < coins[i]) {
      break;
    }

    target += coins[i];
  }

  cout << target;
  
  return 0;
}