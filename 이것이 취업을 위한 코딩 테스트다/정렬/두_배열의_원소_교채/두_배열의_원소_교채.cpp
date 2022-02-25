#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int x, int y) {
  return x > y;
}

int main() {
  int size, count;
  cin >> size >> count;

  vector<int>a;
  vector<int>b;

  int num;

  for (int i = 0; i < size; i++) {
    cin >> num;
    a.push_back(num);
  }

    for (int i = 0; i < size; i++) {
    cin >> num;
    b.push_back(num);
  }

  sort(a.begin(), a.end());
  sort(b.begin(), b.end(), compare);

  for (int i = 0; i < count; i++) {
    if (a[i] < b[i]) {
      a[i] = b[i];
    } else {
      break;
    }
  }

  // for (int i = 0; i < count; i++) {
  //   if (a[i] < b[size - 1 - i]) {
  //     a[i] = b[size - 1 - i];
  //   } else {
  //     break;
  //   }
  // }

  int answer = 0;

  for (int i = 0; i < size; i++) {
    answer += a[i];
  }

  cout << answer;

  return 0;
}