#include <iostream>
using namespace std;

int n = 10;
int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

int main() {
  for (int i = 0; i < 10; i++) {
    int minIndex = i;

    for (int j = i + 1; j < 10; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }

    swap(arr[i], arr[minIndex]);
  }

  for (int i = 0; i < 10; i++) {
    cout << arr[i] << ' ';
  }

  return 0;
}