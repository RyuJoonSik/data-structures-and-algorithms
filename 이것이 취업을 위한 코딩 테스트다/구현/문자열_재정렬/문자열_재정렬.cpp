#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
  string s;
  vector<char> str;
  int result = 0 ;
  cin >> s;

  for (int i = 0; i < s.size(); i++) {
    if (isalpha(s[i])) {
      str.push_back(s[i]);
    } else {
      result += (s[i] - '0');
    }
  }

  sort(str.begin(), str.end());

  // string answer = "";

  // for (int i = 0; i < str.size(); i++) {
  //   answer += str[i];
  // }

  // cout << answer + to_string(result);

  // return 0;

  for (int i = 0; i < str.size(); i++) {
    cout << str[i];
  }

  if (result != 0) cout << result;
}