#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m;
int arr[50][50];
vector<pair<int, int>> chicken;
vector<pair<int, int>> house;

int getSum(vector<pair<int, int>> candidates) {
  int result = 0;

  for (int i = 0; i < house.size(); i++) {
    int hx = house[i].first;
    int hy = house[i].second;
    int temp = 1e9;

    for (int j = 0; j < candidates.size(); j++) {
      int x = candidates[j].first;
      int y = candidates[j].second;
      temp = min(temp, abs(x - hx) + abs(y - hy));
    }

    result += temp;
  }

  return result;
}

int main(void) {
  cin >> n >> m;

  for (int r = 0; r < n; r++) {
    for (int c = 0; c < n; c++) {
      cin >> arr[r][c];
      if (arr[r][c] == 1) house.push_back({r, c});
      else if(arr[r][c] == 2) chicken.push_back({r, c});
    }
  }

  vector<bool> binary(chicken.size());
  fill(binary.end()  -m, binary.end(), true);
  for (int i =0; i < binary.size(); i++) {
    cout << binary[i] << ' ';
  }

  int result = 1e9;

  do {
for (int i =0; i < binary.size(); i++) {
    cout << binary[i] << ' ';
  }
    cout << endl;
    vector<pair<int, int>> now;
    for (int i = 0; i < chicken.size(); i++) {
      if (binary[i]) {
        int cx = chicken[i].first;
        int cy = chicken[i].second;
        now.push_back({cx, cy});
      }
    }

    result = min(result, getSum(now));
  } while(next_permutation(binary.begin(), binary.end()));

  cout << result;
}