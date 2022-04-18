# n, k = map(int, input().split())
# virus = [[] for _ in range(k + 1)]
# space = []

# for i in range(n):
#   row = list(map(int, input().split()))
#   space.append(row)
#   for j in range(n):
#     if row[j] != 0:
#       virus[row[j]].append((i, j))

# s, x, y = map(int, input().split())
# rows = [-1, 1, 0, 0,]
# columns = [0, 0, -1, 1]

# for _ in range(s):
#   for i in range(1, k + 1):
#     temp = []
#     for row, column in virus[i]:
#       for t in range(4):
#         next_row = rows[t] + row
#         next_column = columns[t] + column

#         if next_row >= 0 and next_row < n and next_column >= 0 and next_column < n:
#           if space[next_row][next_column] == 0:
#             space[next_row][next_column] = i
#             temp.append((next_row, next_column))
#     virus[i]= virus[i] + temp
# print(space[x - 1][y - 1])

from collections import deque

n, k = map(int, input().split())
graph = []
data = []

for i in range(n):
  graph.append(list(map(int, input().split())))
  for j in range(n):
    if graph[i][j] != 0:
      data.append((graph[i][j], 0, i, j))

data.sort()
q = deque(data)

target_s, target_x, target_y = map(int, input().split())
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

while q:
  virus, s, x, y = q.popleft()
  if s == target_s:
    break
  for i in range(4):
    nx = x + dx[i]
    ny = y + dy[i]
    if 0 <= nx and nx < n and 0 <= ny and ny < n:
      if graph[nx][ny] == 0:
        graph[nx][ny] = virus
        q.append((virus, s + 1, nx, ny))

print(graph[target_x - 1][target_y - 1])
