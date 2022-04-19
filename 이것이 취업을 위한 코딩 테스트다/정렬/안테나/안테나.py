# n = int(input())
# buildings = list(map(int, input().split()))
# max_value = 1e9
# result = []

# for start in buildings:
#   total = 0
#   for end in buildings:
#     total += abs(start - end)
#   if total < max_value:
#     max_value = total
#     result = [start]
#   elif total == max_value:
#     result.append(start)

# result.sort()

# print(result[0])

n = int(input())
a = list(map(int, input().split()))
a.sort()

print(a[(n - 1) // 2])