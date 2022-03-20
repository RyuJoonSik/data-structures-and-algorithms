#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> graph[501];
queue<int> que;
int indegree[501];
int times[501];
int result[501];
int n;

int main() {
  cin >> n;

  for (int i = 1; i <= n; i++) {
    int time;
    cin >> time;
    times[i] = time;

    while (true) {
      int outputNode;
      cin >> outputNode;

      if (outputNode == -1) {
        break;
      }

      graph[outputNode].push_back(i);
      indegree[i] += 1;
    }
  }

  for (int i = 1; i <= n; i++) {
    result[i] = times[i];

    if (indegree[i] == 0) {
      que.push(i);
    }
  }

  while (!que.empty()) {
    int now = que.front();
    que.pop();

    for (int i = 0; i < graph[now].size(); i++) {
      int outputNode = graph[now][i];
      result[outputNode] = max(result[outputNode], result[now] + times[outputNode]);
      indegree[outputNode] -= 1;
      if (indegree[outputNode] == 0) {
        que.push(outputNode);
      }
    }
  }

  for (int i = 1; i <= n; i++) {
    cout << result[i] << " ";
  }

  return 0;
}