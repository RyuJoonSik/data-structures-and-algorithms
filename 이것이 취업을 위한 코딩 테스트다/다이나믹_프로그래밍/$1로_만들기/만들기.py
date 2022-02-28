x = int(input())

def dp(x):
  dp = [[] for _ in range(x + 1)]
  dp[0].append(x)

  for i in range(x):
    print(dp[i])
    for j in range(len(dp[i])):
      if dp[i][j] == 1:
        return i

      if dp[i][j] % 5 == 0: 
        dp[i+1].append(dp[i][j] // 5)

      if dp[i][j] % 3 == 0: 
        dp[i+1].append(dp[i][j] // 3)

      if dp[i][j] % 2 == 0: 
        dp[i+1].append(dp[i][j] // 2)

      dp[i+1].append(dp[i][j] - 1)

print(dp(x))