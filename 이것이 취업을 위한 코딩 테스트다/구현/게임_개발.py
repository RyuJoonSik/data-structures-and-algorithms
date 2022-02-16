row, column = map(int, input().split())
print(f"row : {row}, column : {column}")

current_row, current_column, direction = map(int, input().split())
print(f"current_row : {current_row}, current_column : {current_column}, direction : {direction}")

maps = []

for r in range(row):
  maps.append(list(map(int, input().split())))

print(maps)
maps[current_row][current_column] = 1
move = {
  0: [-1, 0],
  1: [0, 1],
  2: [1, 0],
  3: [0, -1]
}
answer = 1

def set_direction():
  global direction
  if direction > 0:
    direction -= 1
  else:
    direction = 3

def has_island():
  moves = [[-1, 0], [0, 1], [1, 0], [0, -1]]

  for move in moves:
    next_row = current_row + move[0]
    next_column = current_column + move[1];

    if maps[next_row][next_column] == 0:
      return True
  
  return False

print()
while (has_island()):
  set_direction()
  next_row = current_row + move[direction][0]
  next_column = current_column + move[direction][1]

  if maps[next_row][next_column] == 1:
    continue;
  
  answer += 1
  maps[next_row][next_column] = 1
  current_row = next_row
  current_column = next_column

print(answer)
