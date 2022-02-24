#include <iostream>
using namespace std;

int factorial(int num) {
  if(num <= 1) {
    return 1;
  }

  return num * factorial(num - 1);
}

int main() {
  int value = factorial(5);
  cout << value << endl;

  int result = 1;
  int num = 5;

  for (int i = 1; i <= num; i++) {
    result *= i;
  }

  cout << result << endl;
}