#include <iostream>
#include <queue>

using namespace std;

int n, result;
priority_queue<int> pq;

int main(void) {
  cin >> n;

  for (int i = 0; i < n; i += 1) {
    int x;
    cin >> x;
    pq.push(-x);
  }

  while (pq.size() != 1) {
    int one = -pq.top();
    pq.pop();
    int two = -pq.top();
    pq.pop();
    int sum_value = one + two;
    result += sum_value;
    pq.push(-sum_value);
  }

  cout << result << '\n';
}