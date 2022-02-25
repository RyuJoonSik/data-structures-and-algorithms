#include <iostream>
using namespace std;

int main() {
  int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
  int size = sizeof(arr) / sizeof(arr[0]);
  int cnt[10] = {0};

  for (int i = 0; i < size; i++) {
    cnt[arr[i]]++;
  }

  for (int i = 0; i <= 9; i++) {
    for (int j = 0; j < cnt[i]; j++) {
      cout << i << ' ';
    }
  }

  return 0;
}
