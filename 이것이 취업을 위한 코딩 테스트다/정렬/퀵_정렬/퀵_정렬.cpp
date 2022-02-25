#include <iostream>
using namespace std;

int arr[] = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

void quickSort(int *arr, int start, int end) {
  if (start >= end) {
    return;
  }

  int pivot = start;
  int left = start + 1;
  int right = end;

  while (left <= right) {
    while (left <= end && arr[left] <= arr[pivot]) {
      left++;
    }

    while (right > start && arr[right] >= arr[pivot]) {
      right--;
    }

    if (left > right) {
      swap(arr[pivot], arr[right]);
    } else {
      swap(arr[left], arr[right]);
    }

  }
  quickSort(arr, start, right - 1);
  quickSort(arr, right + 1, end);
}

int main() {
  int size = sizeof(arr)/sizeof(arr[0]);
  quickSort(arr, 0, size - 1);
  
  for (int i = 0; i < size; i++) {
    cout << arr[i] << ' ';
  }

  return 0;
}