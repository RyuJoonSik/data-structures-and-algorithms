#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

class Virus {
  public:
    int index;
    int second;
    int x;
    int y;
    Virus(int index, int second, int x, int y) {
      this->index = index;
      this->second = second;
      this->x = x;
      this->y = y;
    }
    bool operator <(Virus &other) {
      return this->index < other.index;
    }
};

int n, k;
int graph[200][200];
vector<Virus> viruses;

int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -2};

int main(void) {
  cin >> n >> k;

  for (int i = 0; i < n; i += 1) {
    for (int j = 0; j < n; j += 1) {
      cin >> graph[i][j];

      if (graph[i][j] != 0) {
        viruses.push_back(Virus(graph[i][j], 0, i, j));
      }
    }
  }

  sort(viruses.begin(), viruses.end());
  queue<Virus> q;
  for (int i = 0; i < viruses.size(); i += 1) {
    q.push(viruses[i]);
  }

  int target_s, target_x, target_y;
  cin >> target_s >> target_x >> target_y;

  while (!q.empty()) {
    Virus virus = q.front();
    q.pop();

    if (virus.second == target_s) break;
    for (int i = 0; i < 4; i += 1) {
      int nx = virus.x + dx[i];
      int ny = virus.y + dy[i];

      if (0 <= nx && nx < n && 0 <= ny && ny < n) {
        if (graph[nx][ny] == 0) {
          graph[nx][ny] = virus.index;
          q.push(Virus(virus.index, virus.second + 1, nx, ny));
        }
      }
    }
  }
  cout << graph[target_x - 1][target_y - 1] << endl;
}