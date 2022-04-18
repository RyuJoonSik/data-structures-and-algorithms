# n = int(input())
# maps = []
# teachers = []

# for row in range(n):
#   new_row = input().split(' ')
#   for column in range(n):
#     if new_row[column] == 'T':
#       teachers.append((row, column))
#   maps.append(new_row)

# result = False

# def search(maps, count):
#   if count == 3:
#     for teacher_row, teacher_column in teachers:
#       if not find(maps, teacher_row, teacher_column):
#         print(maps)
#         global result
#         result = True
#       return
#   for row in range(n):
#     for column in range(n):
#       if maps[row][column] == 'X':
#         maps[row][column] = 'O'
#         search(maps, count + 1)
#         maps[row][column] ='X'

# def find(maps, teacher_row, teacher_column):
#   n = len(maps)
#   rows = [-1, 1, 0, 0]
#   columns = [0, 0, -1, 1]

#   for i in range(4):
#     next_row = teacher_row + rows[i]
#     next_column = teacher_column + columns[i]

#     while next_row >= 0 and next_row < n and next_column >= 0 and next_column < n:
#       if maps[next_row][next_column] == 'O':
#         break
#       if maps[next_row][next_column] == 'S':
#         return True

#       next_row += rows[i]
#       next_column += columns[i]
#   return False

# search(maps, 0)

# if result:
#   print("YES")
# else:
#   print("NO")

from itertools import combinations

n = int(input())
board = []
teachers = []
spaces = []

for i in range(n):
  board.append(list(input().split()))
  for j in range(n):
    if board[i][j] == 'T':
      teachers.append((i, j))
    if board[i][j] == 'X':
      spaces.append((i, j))

def watch(x, y, direction):
  if direction == 0:
    while y >= 0:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      y -= 1
  if direction == 1:
    while y < n:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      y += 1
  if direction == 2:
    while x >= 0:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      x -= 1
  if direction == 3:
    while x < n:
      if board[x][y] == 'S':
        return True
      if board[x][y] == 'O':
        return False
      x += 1

def process():
  for x, y in teachers:
    for i in range(4):
      if watch(x, y, i):
        return True
  return False

find = False

for data in combinations(spaces, 3):
  for x, y in data:
    board[x][y] = 'O'
  if not process():
    find = True
    break
  for x, y in data:
    board[x][y] = 'X'

if find:
  print('YES')
else:
  print('NO')