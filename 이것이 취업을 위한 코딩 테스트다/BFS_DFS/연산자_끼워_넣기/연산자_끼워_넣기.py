# n = int(input())
# nums = list(map(int, input().split()))
# plus, minus, multiply, devide = map(int, input().split())
# operators = ['+'] * plus + ['-'] * minus + ['*'] * multiply + ['/'] * devide
# print(operators)

# num_max = -1000000000
# num_min = 1000000000

# def calculate(previous_num, current_nums, current_operators):
#   if not current_operators:
#     print(previous_num)
#     global num_max, num_min
#     num_max = max(num_max, previous_num)
#     num_min = min(num_min, previous_num)
#     return

#   current_num = current_nums[0]
#   next_num = 0
#   print(current_operators)
#   for j in range(len(current_operators)):
#     if current_operators[j] == '+':
#       next_num = previous_num + current_num
#     elif current_operators[j] == '-':
#       next_num = previous_num - current_num
#     elif current_operators[j] == '*':
#       next_num = previous_num * current_num
#     elif current_operators[j] == '/':
#       next_num = int(previous_num / current_num)
      
#     new_operators = current_operators[:j] + current_operators[j + 1:]
#     calculate(next_num, current_nums[1:], new_operators)

# calculate(nums[0], nums[1:], operators)

# print(num_max)
# print(num_min)

# from math import floor
# print(-1 / 3)
# print(-1 // 3)
# print(floor(-1 / 3))
# print(int(-1 / 3))

n = int(input())
data = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

min_value = 1e9
max_value = -1e9

def dfs(i, now):
  global min_value, max_value, add, sub, mul, div

  if i == n:
    min_value = min(min_value, now)
    max_value = max(max_value, now)
  else:
    if add > 0:
      add -= 1
      dfs(i + 1, now + data[i])
      add += 1
    if sub > 0:
      sub -= 1
      dfs(i + 1, now - data[i])
      sub += 1
    if mul > 0:
      mul -= 1
      dfs(i + 1, now * data[i])
      mul += 1
    if div > 0:
      div -= 1
      dfs(i + 1, int(now / data[i]))
      div += 1

dfs(1, data[0])
print(max_value)
print(min_value)