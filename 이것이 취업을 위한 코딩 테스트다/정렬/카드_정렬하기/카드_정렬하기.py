# n = int(input())
# nums = []

# for _ in range(n):
#   nums.append(int(input()))

# nums.sort()

# first = nums[0]
# total = 0

# for i in range(1, n):
#   first += nums[i]
#   total += first

# print(total)

import heapq

n = int(input())

heap = []
for i in range(n):
  data = int(input())
  heapq.heappush(heap, data)

result = 0

while len(heap) != 1:
  one = heapq.heappop(heap)
  two = heapq.heappop(heap)
  sum_value = one + two
  result += sum_value
  heapq.heappush(heap, sum_value)

print(result)