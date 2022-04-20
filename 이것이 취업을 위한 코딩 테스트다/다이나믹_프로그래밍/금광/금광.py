# t = int(input())

# for _ in range(t):
#   n, m = map(int, input().split())
#   arr = list(map(int, input().split()))

#   boards = []

#   for i in range(n):
#     boards.append([])
#     for j in range(m):
#       boards[i].append(arr[m * i + j])

#   dx = [0, 1, -1]
#   dy = [-1, -1, -1]

#   result = 0

#   for i in range(1, m):
#     for j in range(n):
#       max_value = 0

#       for direction in range(3):
#         prev_x = j + dx[direction]
#         prev_y = i + dy[direction]

#         if prev_x < 0 or prev_x >= n or prev_y < 0 or prev_y >= m:
#           continue

#         max_value = max(max_value, boards[prev_x][prev_y] + boards[j][i])
      
#       boards[j][i] = max_value
#       result = max(result, max_value)
  
#   print(result)
#   print(boards)

for tc in range(int(input())):
  n, m = map(int, input().split())
  array = list(map(int, input().split()))

  dp = []
  index = 0
  for i in range(n):
    dp.append(array[index:index + m])
    index += m

  for j in range(1, m):
    for i in range(n):
      if i == 0:
        left_up = 0
      else:
        left_up = dp[i - 1][j - 1]
      if i == n - 1:
        left_down = 0
      else:
        left_down = dp[i + 1][j - 1]
      left = dp[i][j - 1]
      dp[i][j] = dp[i][j] + max(left_up, left_down, left)
  
  result = 0
  for i in range(n):
    result = max(result, dp[i][m - 1])
  
  print(result)