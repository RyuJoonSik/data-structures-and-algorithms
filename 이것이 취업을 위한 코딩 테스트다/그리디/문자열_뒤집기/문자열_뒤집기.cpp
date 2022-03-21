#include <iostream>
#include <string>

using namespace std;

int main() {
  string str;
  cin >> str;

  int count0 = 0;
  int count1 = 0;

  if (str[0] = '0') {
    count1 += 1;
  } else {
    count0 += 1;
  }

  for (int i = 1; i < str.size() - 1; i++) {
    if (str[i] != str[i+1]) {
      if (str[i+1] == '0') {
        count1 += 1;
      } else {
        count0 += 1;
      }
    }
  }

  cout << min(count0, count1);

  return 0;
}