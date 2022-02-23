n = int(input())
value_range = [n + 1, 0]
directions = input().split()
move = {
  "R": (0, 1),
  "L": (0, -1),
  "U": (-1, 0),
  "D": (1, 0)
}
row = col = 1

for direction in directions:
  row_next = row + move[direction][0]
  col_next = col + move[direction][1]

  if row_next in value_range or col_next in value_range:
    continue
  
  row, col = row_next, col_next

print(row, col)