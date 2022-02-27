#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n, target;
  vector<int> arr;
  cin >> n >> target;
  int start = 0, end = 0;

  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;

    if (end < num) {
      end = num;
    }

    arr.push_back(num);
  }

  int result;

  while (start <= end) {
    int mid = (start + end) / 2;
    int total = 0;

    for (int i = 0; i < n; i++) {
      if (arr[i] > mid) {
        total += arr[i] - mid;
      }
    }

    if (total < target) {
      end = mid - 1;
    } else {
      result = mid;
      start = mid + 1;
    }
  }
  
  cout << result;

  return 0;
}