#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n, m;
  cin >> n >> m;
  vector<vector<int>>cards;
  int answer = 1;

  for (int i = 0; i < n; i++) {
    int num, min = 10000;
    vector<int> temp;

    for (int j = 0 ; j < m; j++) {
      cin >> num;
      min = num < min ? num : min;
      temp.push_back(num);
    }

    answer = min > answer ? min : answer;

    cards.push_back(temp);
  }

  cout << answer;
}