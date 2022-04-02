# s = input()
# result = 0
# string = []

# for i in s:
#   if i.isnumeric():
#     result += int(i)
#   else:
#     string.append(i)

# string.sort()
# print(''.join(string) + str(result))

data = input()
result = []
value = 0

for x in data:
  if x.isalpha():
    result.append(x)
  else:
    value += int(x)

result.sort()

if value != 0:
  result.append(str(value))

print(''.join(result))