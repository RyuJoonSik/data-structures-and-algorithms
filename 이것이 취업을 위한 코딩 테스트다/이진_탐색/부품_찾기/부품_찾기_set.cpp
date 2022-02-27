#include <iostream>
#include <set>
using namespace std;

int main() {
  int n, m;
  set<int> arr;

  cin >> n;
  
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;

    arr.insert(num);
  }

  cin >> m;

  for (int i = 0; i < m; i++) {
    int num;
    cin >> num;

    if (arr.find(num) != arr.end()) {
      cout << "yes" << ' ';
    } else {
      cout << "no" << ' ';
    }
  }

  return 0;
}