# from collections import deque

# row_size, column_size = map(int, input().split())
# frames = []

# for i in range(row_size):
#   row = [int(ch) for ch in list(input())]
#   frames.append(row)

# print(frames)

# answer = 0

# def bfs(row, column):
#   que = deque([(row, column)])

#   while que:
#     current_row, current_column = que.popleft()
#     print(current_row, current_column)
#     frames[current_row][current_column] = 1


#     for r, c in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
#       next_row = current_row + r
#       next_column = current_column + c

#       if 0 > next_row or next_row >= row_size or 0 > next_column or next_column >= column_size:
#         continue

#       if not frames[next_row][next_column]:
#         que.append((next_row, next_column))

# for current_row in range(row_size):
#   for current_column in range(column_size):
#     if not frames[current_row][current_column]:
#       answer += 1
      
#       bfs(current_row, current_column)

# print(answer)

n, m = map(int, input().split())

graph = []
for i in range(n):
  graph.append(list(map(int, input())))

def dfs(x, y):
  if x <= -1 or x >= n or y <= -1 or y >= m:
    return False
  if graph[x][y] == 0:
    graph[x][y] = 1

    dfs(x - 1, y)
    dfs(x, y - 1)
    dfs(x + 1, y)
    dfs(x, y + 1)
    return 1
  return False

result = 0

for i in range(n):
  for j in range(m):
    if dfs(i, j) == True:
      result += 1

print(result)