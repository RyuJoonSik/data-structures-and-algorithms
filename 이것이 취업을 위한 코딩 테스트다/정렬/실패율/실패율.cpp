#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, double> a, pair<int, double> b) {
  if (a.second == b.second) return a.first < b.first;
  return a.second > b.second;
}

vector<int> solution(int N, vector<int> stages) {
  vector<pair<int, double>> v;
  vector<int> answer;
  int length = stages.size();

  for (int i = 1; i <= N; i += 1) {
    int cnt = count(stages.begin(), stages.end(), i);

    double fail = 0;
    if (length >= 1) {
      fail = (double) cnt / length;
    }

    v.push_back({i, fail});
    length -= cnt;
  }

  sort(v.begin(), v.end(), compare);

  for (int i = 0; i < N; i += 1) {
    answer.push_back(v[i].first);
  }
  return answer;
}