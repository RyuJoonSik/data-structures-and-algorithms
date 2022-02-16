n, m, k = map(int ,input().split())
nums = list(map(int ,input().split()))

print(n, m, k)
print(nums)

answer = 0
nums.sort()
first = nums[-1]
second = nums[-2]

# for i in range(1, m + 1):
#   value = 0

#   if i % (k + 1) == 0:
#     value = second
#   else:
#     value = first
#   print(value)
#   answer += value

# print(answer)

count = int(m / (k + 1)) * k
count += m % (k + 1)

result = count * first
result += (m - count) * second

print(result)
