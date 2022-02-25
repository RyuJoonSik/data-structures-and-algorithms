# from collections import deque

# row_size, column_size = map(int, input().split())
# boards = []

# for i in range(row_size):
#   boards.append(list(map(int, input())))

# print(boards)

# que = deque([(0, 0, 1)])
# answer = 0

# while(que):
#   current_row, current_column, count = que.popleft()
  
#   if current_row == row_size - 1 and current_column == column_size - 1:
#     answer = count
#     break

#   for row, column in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
#     next_row = current_row + row
#     next_column = current_column + column

#     if -1 < next_row < row_size and -1 < next_column < column_size:
#       que.append((next_row, next_column, count + 1))

# print(answer)

from collections import deque

n, m = map(int, input().split())
graph = []
for i in range(n):
  graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
  queue = deque()
  queue.append((x, y))

  while queue:
    x, y = queue.popleft()

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]

      if nx < 0 or ny < 0 or nx >= n or ny >= m:
        continue

      if graph[nx][ny] == 0:
        continue

      if graph[nx][ny] == 1:
        graph[nx][ny] = graph[x][y] + 1
        queue.append((nx, ny))
  
  return graph[n - 1][m - 1]

print(bfs(0, 0))