n = int(input())
array = [0] * 1_000_000

for num in input().split():
  array[int(num)] = 1

m = int(input())
customer = list(map(int, input().split()))

for num in customer:
  if array[num] == 1:
    print('yes', end = ' ')
  else:
    print('no', end = ' ')