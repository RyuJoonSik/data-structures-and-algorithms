# row_col = input()
# row = int(row_col[1])
# col = ord(row_col[0]) - 96

# answer = 0
# dirs = [[0, 2], [0, -2], [2, 0], [-2, 0]]

# for rowAdd, colAdd in dirs:
#   rowNext = row + rowAdd
#   colNext = col + colAdd

#   if 0 < rowNext < 9 and 0 < colNext < 9:
#     if rowAdd == 0:
#       rowUp = row - 1
#       rowDown = row + 1

#       if 0 < rowUp < 9:
#         answer += 1

#       if 0 < rowDown < 9:
#         answer += 1
#     else:
#       colLeft = col - 1
#       colRight = col + 1

#       if 0 < colLeft < 9:
#         answer += 1

#       if 0 < colRight < 9:
#         answer += 1

# print(answer)

input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0])) - int(ord('a')) + 1

steps = [
  (-2, -1), (-1, -2), (1, -2), (2, -1),
  (2, 1), (1, 2), (-1, 2), (-2, 1)
]

result = 0

for up_down, left_right in steps:
  print(up_down, left_right)
  next_row = row + up_down
  next_column = column + left_right
  print(next_row, next_column)

  if 0 < next_row < 9 and 0 < next_column < 9:
    result += 1

print(result)