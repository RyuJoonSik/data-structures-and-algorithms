#include <iostream>
#include <string>
#include <vector>
using namespace std;

int sequentialSearch(int n, string target, vector<string> arr) {
  for (int i = 0; i < n; i++) {
    if (arr[i] == target) {
      return i + 1;
    }
  }
  return -1;
}

int main() {
  int n;
  string target;
  vector<string> arr;

  cin >> n >> target;

  for (int i = 0; i < n; i++) {
    string x;
    cin >> x;
    arr.push_back(x);
  }

  cout << sequentialSearch(n, target, arr);

  return 0;
}