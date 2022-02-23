#include <iostream>

using namespace std;

int main() {
  int n, answer;
  cin >> n;

  for (int hour = 0; hour <= n; hour++) {
    for (int min = 0; min <= 59; min++) {
      for (int sec = 0; sec <= 59; sec++) {
        if (hour % 10 == 3 || min / 10 == 3 || min % 10 == 3 || sec / 10 == 3 || sec % 10 == 3) {
          answer++;
        }
      }
    }
  }

  cout << answer;

  return 0;
}