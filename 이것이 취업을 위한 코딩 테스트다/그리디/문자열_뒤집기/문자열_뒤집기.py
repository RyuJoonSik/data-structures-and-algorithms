# s = input()
# current = s[0]
# obj = {
#   '0': 0,
#   '1': 0
# }

# if current == '0':
#   obj['1'] += 1
# else:
#   obj['0'] += 1

# for c in s:
#   if c == current:
#     continue;
#   else:
#     obj[c] += 1

#   current = c

# print(min(obj['0'], obj['1']))

data = input()
count_0 = 0
count_1 = 0
current = data[0]

if current == '0':
  count_1 += 1
else:
  count_0 += 1

for i in range(1, len(data)):
  if current != data[i]:
    if data[i] == '0':
      count_1 += 1
    else:
      count_0 += 1
    current = data[i]

print(min(count_0, count_1))