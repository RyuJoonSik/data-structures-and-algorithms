#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
  vector<int> arr;
  int n;
  cin >> n;

  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;
    arr.push_back(num);
  }

  sort(arr.begin(), arr.end(), [](int a, int b){return b > a;});

  for(int i = n - 1; i >= 0; i--) {
    cout << arr[i] << ' ';
  }

  return 0;
}