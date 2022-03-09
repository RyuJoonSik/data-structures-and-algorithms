import heapq
import sys
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())
graph = [[] for i in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
  a, b, c = map(int, input().split())
  graph[a].append((b, c))

def dijkstra(start):
  q = []
  heapq.heappush(q, (0, start))
  distance[start] = 0
  while q:
    dist, now = heapq.heappop(q)

    if distance[now] < dist:
      continue
    for node, cost in graph[now]:
      new_cost = dist + cost

      if new_cost < distance[node]:
        distance[node] = new_cost
        heapq.heappush(q, (new_cost, node))

dijkstra(start)

for i in range(1, n + 1):
  if distance[i] == INF:
    print("INFINITY")
  else:
    print(distance[i])