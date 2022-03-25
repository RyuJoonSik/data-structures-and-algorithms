#include <iostream>
#include <string>

using namespace std;

int main() {
  string n;
  cin >> n;

  int size = n.size();
  int mid = size / 2;
  int sum = 0;

  for (int i = 0; i < mid; i++) {
    sum += (n[i] - '0');
  }

  for (int i = mid; i < size; i++) {
    sum -= (n[i] - '0');
  }

  if (sum == 0) {
    cout << "LUCKY";
  } else {
    cout << "READY";
  }

  return 0;
}