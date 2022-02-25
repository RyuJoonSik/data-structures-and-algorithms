#include <iostream>
#include <algorithm>
using namespace std;

int main() {
  int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
  int size = sizeof(arr) / sizeof(arr[0]);
  sort(arr, arr + size);

  for (int i = 0; i < size; i++) {
    cout << arr[i] << ' ';
  }

  return 0;
}