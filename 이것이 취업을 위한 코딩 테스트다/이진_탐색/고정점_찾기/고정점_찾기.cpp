#include <iostream>
#include <vector>

using namespace std;

int binarySearch(vector<int>& arr, int start, int end) {
  if (start > end) return -1;
  int mid = (start + end) / 2;
  if (arr[mid] == mid) return mid;
  else if (arr[mid] > mid) return binarySearch(arr, start, mid - 1);
  else return binarySearch(arr, mid + 1, end);
}

int n;
vector<int> arr;

int main(void) {
  cin >> n;
  for (int i = 0; i < n; i += 1) {
    int x;
    cin >> x;
    arr.push_back(x);
  }

  int index = binarySearch(arr, 0, n - 1);
  cout << index << endl;
}