# floor = int(input())
# floors = []

# for _ in range(floor):
#   floors.append(list(map(int, input().split())))

# print(floors)

# for row in range(1, floor):
#   for column in range(len(floors[row])):
#     if column == 0:
#       floors[row][column] += floors[row - 1][column]
#       continue

#     if column == len(floors[row]) - 1:
#       floors[row][column] += floors[row - 1][column - 1]
#       continue

#     floors[row][column] += max(floors[row - 1][column], floors[row - 1][column - 1])

# print(max(floors[floor - 1]))

n = int(input())
dp = []

for _ in range(n):
  dp.append(list(map(int, input().split())))

for i in range(1, n):
  for j in range(i + 1):
    if j == 0:
      up_left = 0
    else:
      up_left = dp[i - 1][j - 1]
    
    if j == i:
      up = 0
    else:
      up = dp[i - 1][j]
    
    dp[i][j] = dp[i][j] + max(up_left, up)

print(max(dp[n - 1]))