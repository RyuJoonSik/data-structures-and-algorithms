# size, min_value, max_value = map(int, input().split())
# print(size, min_value, max_value)

# temps = [[0] * size for _ in range(size)]
# boards = []
# for _ in range(size):
#   boards.append(list(map(int, input().split())))
# print(boards)

# rows = [-1, 1, 0, 0]
# columns = [0, 0, -1, 1]

# for row in range(size):
#   for column in range(size):
#     for direction in range(4):
#       next_row = row + rows[direction]
#       next_column = column + columns[direction]

#       if next_row >= 0 and next_row < size and next_column >= 0 and next_column < size:
#         current_value = abs(boards[row][column] - boards[next_row][next_column])

#         if min_value <= current_value <= max_value:
#           temps[row][column] = 1
#           temps[next_row][next_column] = 1

# print(temps)

from collections import deque

n, l, r = map(int, input().split())
graph = []
for _ in range(n):
  graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

def process(x, y, index):
  united = []
  united.append((x, y))
  q = deque()
  q.append((x, y))
  union[x][y] = index
  summary = graph[x][y]
  count = 1
  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if 0 <= nx < n and 0 <= ny < n and union[nx][ny] == -1:
        if l <= abs(graph[nx][ny] - graph[x][y]) <= r:
          q.append((nx, ny))
          union[nx][ny] = index
          summary += graph[nx][ny]
          count += 1
          united.append((nx, ny))
  for i ,j in united:
    graph[i][j] = summary // count

total_count = 0

while True:
  union = [[-1] * n for _ in range(n)]
  index = 0
  for i in range(n):
    for j in range(n):
      if union[i][j] == -1:
        process(i, j, index)
        index += 1
  if index == n * n:
    break
  total_count += 1

print(total_count)