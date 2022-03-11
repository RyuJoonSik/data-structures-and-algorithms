import heapq

INF = int(1e9)
n, m, c = map(int, input().split())
d = [INF] * (n + 1)
d[c] = 0
graph = [[] for _ in range(n + 1)]

for _ in range(m):
  x, y, z = map(int, input().split())
  graph[x].append((y, z))

q = []
heapq.heappush(q, (0, c))

while q:
  dist, now = heapq.heappop(q)

  if d[now] < dist:
    continue

  for (next, cost) in graph[now]:
    new_cost = dist + cost

    if new_cost < d[next]:
      d[next] = new_cost
      heapq.heappush(q, (new_cost, next))

count = 0
max_distance = 0

for i in d:
  if i != INF:
    count += 1
    max_distance = max(max_distance, i)

print(count - 1, max_distance)

