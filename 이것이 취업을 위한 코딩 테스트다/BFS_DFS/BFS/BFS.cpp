#include <iostream>
#include <vector>
#include <queue>
using namespace std;

bool visited[9];
vector<int> graph[9];

void bfs(int num) {
  queue<int> q;
  q.push(num);
  visited[num] = true;

  while (!q.empty()) {
    int current = q.front();
    q.pop();
    cout << current << endl;

    for (int i = 0; i < graph[current].size(); i++) {
      int next = graph[current][i];

      if (!visited[next]) {
        q.push(next);
        visited[next] = true;
      }
    }
  }
}

int main() {
    graph[1].push_back(2);
  graph[1].push_back(3);
  graph[1].push_back(8);
  
  graph[2].push_back(1);
  graph[2].push_back(7);

  graph[3].push_back(1);
  graph[3].push_back(4);
  graph[3].push_back(5);

  graph[4].push_back(3);
  graph[4].push_back(5);

  graph[5].push_back(3);
  graph[5].push_back(4);

  graph[6].push_back(7);

  graph[7].push_back(2);
  graph[7].push_back(6);
  graph[7].push_back(8);

  graph[8].push_back(1);
  graph[8].push_back(7);

  bfs(1);
  
  return 0;
}