#include <iostream>
using namespace std;

int n, k;

int main() {
  cin >> n >> k;
  int answer = 0;

  while (n != 1) {
    if (n % k == 0) {
      n /= k;
    } else {
      n--;
    }
    answer++;
  }

  cout << answer;
}