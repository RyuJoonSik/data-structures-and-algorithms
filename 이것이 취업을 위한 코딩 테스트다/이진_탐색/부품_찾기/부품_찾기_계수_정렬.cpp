#include <iostream>
using namespace std;

int main() {
  int n, m, num;
  int store[1000001] = {0};

  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> num;
    store[num] = 1;
  }

  cin >> m;
  
  for (int i = 0; i < m; i++) {
    int result = -1;

    cin >> num;
    
    if (store[num] == 1) {
      cout << "yes" << ' ';
    } else {
      cout << "no" << ' ';
    }
  }

  return 0;
}