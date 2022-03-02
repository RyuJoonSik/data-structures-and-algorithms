n = int(input())

dp = [0] * (n + 1)
dp[1] = 1
dp[2] = 3

for size in range(3, n + 1):
  dp[size] = (dp[size - 1] + dp[size - 2] * 2) % 796796

print(dp[n])
