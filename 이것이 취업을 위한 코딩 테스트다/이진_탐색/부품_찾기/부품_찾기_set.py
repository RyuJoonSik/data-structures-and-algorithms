n = int(input())
array = set(map(int, input().split()))
m = int(input())
customer = list(map(int, input().split()))

print(array)

for num in customer:
  if num in array:
    print('yes', end = ' ')
  else:
    print('no', end = ' ')
