# n = int(input())
# arr = list(map(int, input().split()))

# for i in range(2, n):
#   arr[i] = arr[i] + arr[i - 2]

# print(max(arr[n - 1], arr[n - 2]))

n = int(input())
arr = list(map(int, input().split()))
dp = [0] * n
dp[0] = 0
dp[1] = max(arr[0], arr[1])

for i in range(2, n):
  dp[i] = max(dp[i-1], arr[i] + dp[i-2])

print(dp[n - 1])