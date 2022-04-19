#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int countByRange(vector<string>& v, string leftValue, string rightValue) {
  vector<string>::iterator rightIndex = upper_bound(v.begin(), v.end(), rightValue);
  vector<string>::iterator leftIndex = lower_bound(v.begin(), v.end(), leftValue);
  return rightIndex - leftIndex;
}

string replaceAll(string str, string from, string to) {
  string res = str;
  int pos = 0;
  while ((pos = res.find(from, pos)) != string::npos) {
    res.replace(pos, from.size(), to);
    pos += to.size();
  }
  return res;
}

vector<string> arr[100001];
vector<string> reversed_arr[100001];

vector<int> solution(vector<string> words, vector<string> queries) {
  vector<int> answer;

  for (int i = 0; i < words.size(); i += 1) {
    string word = words[i];
    arr[word.size()].push_back(word);
    reverse(word.begin(), word.end());
    reversed_arr[word.size()].push_back(word);
  }

  for (int i = 0; i < 10001; i += 1) {
    sort(arr[i].begin(), arr[i].end());
    sort(reversed_arr[i].begin(), reversed_arr[i].end());
  }

  for (int i = 0; i < queries.size(); i += 1) {
    string q = queries[i];
    int res = 0;
    if (q[0] != '?') {
      res = countByRange(arr[q.size()], replaceAll(q, "?", "a"), replaceAll(q, "?", "z"));
    }
    else {
      reverse(q.begin(), q.end());
      res = countByRange(reversed_arr[q.size()], replaceAll(q, "?", "a"), replaceAll(q, "?", "z"));
    }
    answer.push_back(res);
  }
  return answer;
}