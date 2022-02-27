#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;

int main() {
  int n, m, num, target;
  vector<int> store, customer;

  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> num;
    store.push_back(num);
  }

  cin >> m;

  for (int i = 0; i < m; i++) {
    cin >> num;
    customer.push_back(num);
  }

  sort(store.begin(), store.end());
  sort(customer.begin(), customer.end());

  int start, mid, end;
  string result = "no";

  for (int i = 0; i < m; i++) {
    target = customer[i];
    start = 0, end = n - 1;

    while (start <= end) {
      mid = (start + end) / 2;

      if (store[mid] == target) {
        result = "yes";
        break;
      } else if (store[mid] > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    cout << result << ' ';
  }

  return 0;
}