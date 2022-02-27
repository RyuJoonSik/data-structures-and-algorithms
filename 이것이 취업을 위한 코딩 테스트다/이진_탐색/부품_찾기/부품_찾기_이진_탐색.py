import sys

n = int(input())
store = list(map(int, sys.stdin.readline().rstrip().split()))
m = int(input())
customer = list(map(int, sys.stdin.readline().rstrip().split()))

store.sort()
customer.sort()

for target in customer:
  start, end = 0, n - 1
  result = 'no'

  while (start <= end):
    mid = (start + end) // 2
    if store[mid] == target:
      result = 'yes'
      break
    elif store[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  
  print(result, end=' ')