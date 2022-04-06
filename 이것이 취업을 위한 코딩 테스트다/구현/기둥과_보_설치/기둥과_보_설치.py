def solution(n, build_frame):
  board = [[-1] * n for _ in range(n)];
  print(board)

  for [x, y, a, b] in build_frame:
    row = n - y
    column = x

    if a == 1:
      if b == 1:
        if check_pillar(row, column, board):
          board[row][column] = 1
      elif b == 0:
        board[row][column] = -1
        if not check_removable(board):
          board[row][column] = 1
    elif a == 0:
      if b == 1:
        if check_beam(row, column, board):
          board[row][column] = 0
      elif b == 0:
        board[row][column] = -1
        if not check_removable(board):
          board[row][column] = 0

def check_pillar(row, column, board):
  n = len(board)

  if row == n or board[row + 1][column] == 1 or board[row][column - 1] == 0:
    return True
  
  return False

def check_beam(row, column, board):
  if board[row + 1][column] == 1 or board[row + 1][column + 1] == 1 or (board[row][column - 1] == 0 and board[row][column + 1]  == 0):
    return True
  
  return False

def check_removable(board):
  n = len(board)

  for i in range(n):
    for j in range(n):
      if board[i][j] == 0:
        if not check_beam(i, j, board):
          return False
      elif board[i][j] == 1:
        if not check_pillar(i, j, board):
          return False
  
  return True