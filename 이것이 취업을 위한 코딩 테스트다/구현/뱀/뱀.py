board_size = int(input())
board = [[0] * board_size for _ in range(board_size)]
apple_count = int(input())
for i in range(apple_count):
  [row, column] = map(int, input().split())
  board[row - 1][column - 1] = 1

timer = {}
timer_count = int(input())
for i in range(timer_count):
  [time, next_direction] = input().split()
  timer[int(time)] = next_direction

print(board)
print(timer)

# 동 남 서 북
directions = [[0, 1], [1, 0], [0, -1], [-1, 0]]
direction = 0
row = 0
column = 0
time = 0
board[row][column] = 2
snake = [[0, 0]]

while True:
  time += 1
  row += directions[direction][0]
  column += directions[direction][1]

  if row <= -1 or row >= board_size or column <= -1 or column >= board_size or board[row][column] == 2:
    break

  if board[row][column] == 1:
    snake.append([row, column])
    board[row][column] = 2
  elif board[row][column] == 0:
    board[row][column] = 2
    snake.append([row, column])
    [tail_row, tail_column] = snake.pop(0)
    board[tail_row][tail_column] = 0

  if time in timer and timer[time] == 'D':
    direction = direction + 1 if direction < 3 else 0
  elif time in timer and timer[time] == 'L':
    direction = direction - 1 if direction > 0 else 3

print(time)



