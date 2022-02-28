#include <iostream>
using namespace std;

int d[100];

int fibo(int n) {
  if (n == 1 || n == 2) {
    return 1;
  }

  if (d[n] != 0) {
    return d[n];
  }
  
  d[n] = fibo(n - 1) + fibo(n - 2);

  return d[n];
}

int main() {
  cout << fibo(6);

  return 0;
}