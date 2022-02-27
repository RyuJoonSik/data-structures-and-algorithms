#include <iostream>
#include <vector>
using namespace std;

int recursive_binary_search(vector<int>& array, int target, int start, int end) {
  if (start > end) {
    return -1;
  }

  int mid = (start + end) / 2;

  if (array[mid] == target) {
    return mid;
  } else if(array[mid] > target) {
    return recursive_binary_search(array, target, start, mid - 1);
  } else {
    return recursive_binary_search(array, target, mid + 1, end);
  }
}

int loop_binary_search(vector<int>& array, int target, int start, int end) {
  while (start <= end) {
    int mid = (start + end) / 2;

    if (array[mid] == target) {
      return mid;
    } else if (array[mid] > target) {
      end = mid - 1;
    } else {
      start = mid + 1;
    }
  }
  return -1;
}

int main() {
  int n, target;
  vector<int> arr;

  cin >> n >> target;
  for (int i = 0; i < n; i++) {
    int value;
    cin >> value;
    arr.push_back(value);
  }

  // int result = recursive_binary_search(arr, target, 0, n - 1);
  int result = loop_binary_search(arr, target, 0, n - 1);

  if (result == -1) {
    cout << "no result";
  } else {
    cout << result + 1;
  }

  return 0;
}