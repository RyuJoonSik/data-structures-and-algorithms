#include <iostream>
#include <string>
using namespace std;

int main() {
  int size;
  string str;

  cin >> size;
  cin.ignore();
  getline(cin, str);

  int row[] = {-1, 1, 0, 0};
  int column[] = {0, 0, -1, 1};
  int currentRow = 1, currentColumn = 1;
  char type[] =  {'U', 'D', 'L', 'R'};

  for(int i = 0; i < str.size(); i+=2) {
    char dType = str[i];

    for (int j = 0; j < 4; j++) {
      if (dType == type[j]) {
        int nextRow = currentRow + row[j];
        int nextColumn = currentColumn + column[j];

        if (1 <= nextRow && nextRow <= size && 1 <= nextColumn && nextColumn <= size) {
          currentRow = nextRow;
          currentColumn = nextColumn;
        }
      }
    }
  }

  cout << currentRow << ' ' << currentColumn;

  return 0;
}