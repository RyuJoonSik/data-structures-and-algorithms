from collections import deque

n = int(input())
subject = [0] * (n + 1)
indegree = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]

for i in range(1, n + 1):
  arr = list(map(int, input().split()))
  subject[i] = arr[0]

  for j in arr[1:-1]:
    graph[j].append(i)
    indegree[i] += 1

print(indegree)
print(graph)
queue = deque()
result = subject[:]

for i in range(n):
  if indegree[i] == 0:
    queue.append(i)

while (queue):
  now = queue.popleft()
  print(now, end=" ")

  for i in graph[now]:
    result[i] = max(result[i], subject[i] + result[now])
    indegree[i] -= 1

    if indegree[i] == 0:
      queue.append(i)

print()

for i in range(1, n + 1):
  print(result[i])

