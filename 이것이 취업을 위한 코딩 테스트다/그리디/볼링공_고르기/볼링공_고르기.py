n, m = map(int, input().split())
balls = list(map(int, input().split()))
ball_counts = [0] * (m + 1)

for i in range(n):
  ball_counts[balls[i]] += 1

result = 0
print(ball_counts)
for i in range(1, m + 1):
  n -= ball_counts[i]
  result += (n * ball_counts[i])

print(result)