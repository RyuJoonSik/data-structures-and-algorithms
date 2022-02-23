#include <iostream>
#include <string>

using namespace std;

int main() {
  string pos;
  cin >> pos;

  int currentRow = pos[1] - '0';
  int currentColumn = int(pos[0]) - 96;
  int answer = 0;
  int nextRow, nextColumn;
  cout << 'a' - 'a' << endl;
  cout << currentRow << " " << currentColumn << endl;

  int row[] = {2, 2, -2, -2, -1, 1, -1, 1};
  int column[] = {-1, 1, -1, 1, 2, 2, -2, -2};

  for (int i = 0; i < 8; i++) {
    nextRow = currentRow + row[i];
    nextColumn = currentColumn + column[i];

    if (1 <= nextRow && nextRow <= 8 && 1 <= nextColumn && nextColumn <= 8) {
      answer++;
    }
  }
  cout << answer;

  return 0;
}