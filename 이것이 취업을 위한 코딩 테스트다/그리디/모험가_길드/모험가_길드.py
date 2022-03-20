# n = int(input())
# arr = list(map(int, input().split()))
# current = 0
# maxFear = 0
# count = 0

# for i in arr:
#   current += 1
#   maxFear = max(maxFear, i)

#   if current >= maxFear:
#     count += 1
#     current = 0
#     maxFear = 0

# print(count)

n = int(input())
data = list(map(int, input().split()))

data.sort()

count = 0
result = 0

for i in data:
  count += 1

  if count >= i:
    result += 1
    count = 0

print(result)