# x = int(input())

# def dp(x):
#   dp = [[] for _ in range(x + 1)]
#   dp[0].append(x)

#   for i in range(x):
#     print(dp[i])
#     for j in range(len(dp[i])):
#       if dp[i][j] == 1:
#         return i

#       if dp[i][j] % 5 == 0: 
#         dp[i+1].append(dp[i][j] // 5)

#       if dp[i][j] % 3 == 0: 
#         dp[i+1].append(dp[i][j] // 3)

#       if dp[i][j] % 2 == 0: 
#         dp[i+1].append(dp[i][j] // 2)

#       dp[i+1].append(dp[i][j] - 1)

# print(dp(x))

x = int(input())

d = [0] * 27

for i in range(2, x + 1):
  print("current number : ", i)
  d[i] = d[i - 1] + 1
  print("before : ", d[i])
  if i % 2 == 0:
    d[i] = min(d[i], d[i // 2] + 1)
  if i % 3 == 0:
    d[i] = min(d[i], d[i // 3] + 1)
  if i % 5 == 0:
    d[i] = min(d[i], d[i // 5] + 1)
  print("after : ", d[i])
  print(d)
print(d[x])