# n, m = map(int, input().split())
# dp = [0] * (m + 1)

# for i in range(n):
#   num = int(input())

#   if num > m:
#     continue

#   dp[num] = 1

# for money in range(2, m + 1):
#   if dp[money] == 1:
#     continue

#   value = 10000

#   for i in range(money - 1, (money // 2) - 1, - 1):
#     if dp[i] == 0 or dp[money - i] == 0:
#       continue
    
#     value = min(value, dp[i] + dp[money - i])
  
#   if value != 10000:
#     dp[money] = value
    
# print(dp)
# if (dp[m] == 0):
#   print(-1)
# else:
#   print(dp[m])
  
n, m = map(int, input().split())
array = []
for i in range(n):
  array.append(int(input()))

d = [10001] * (m + 1)
d[0] = 0

for i in range(n):
  for j in range(array[i], m + 1):
    d[j] = min(d[j], d[j - array[i]] + 1)

if d[m] == 1001:
  print(-1)
else:
  print(d[m])