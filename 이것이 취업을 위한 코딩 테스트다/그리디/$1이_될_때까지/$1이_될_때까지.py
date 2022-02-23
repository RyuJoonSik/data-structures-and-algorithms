n, k = map(int, input().split())
answer = 0

# while n != 1:
#   if n % k == 0:
#     n //= k
#   else:
#     n -= 1
#   print(n)
#   answer += 1

# print(answer)
result = 0

while True:
  target = (n // k) * k
  print(target)
  result += (n - target)
  n = target

  if n < k:
    break

  result += 1
  n //= k

result += (n - 1)
print(result)

