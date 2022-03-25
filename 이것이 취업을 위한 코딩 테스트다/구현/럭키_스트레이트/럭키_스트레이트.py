# n = input()
# mid = len(n) // 2
# num_1 = 0
# num_2 = 0

# for i in range(mid):
#   num_1 += int(n[i])

# for i in range(mid, len(n)):
#   num_2 += int(n[i])

# if num_1 == num_2:
#   print("LUCKY")
# else:
#   print("READY")

n = input()
length = len(n)
sum = 0

for i in range(length // 2):
  sum += int(n[i])

for i in range(length // 2, length):
  sum -= int(n[i])

if sum == 0:
  print("LUCKY")
else:
  print("READY")