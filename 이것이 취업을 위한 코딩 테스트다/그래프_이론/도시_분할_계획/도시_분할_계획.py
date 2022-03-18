def find_village(village, x):
  if village[x] != x:
    village[x] = find_village(village, village[x])

  return village[x]

def union_village(village, a, b):
  a = find_village(village, a)
  b = find_village(village, b)

  if a < b:
    village[b] = a
  else:
    village[a] = b

n, m = map(int, input().split())
village = [0] * (n + 1)
edge = []
result = 0
last = 0

for i in range(1, n + 1):
  village[i] = i

for _ in range(m):
  a, b, c = map(int, input().split())
  edge.append([c, a, b])

edge.sort()

for [c, a, b] in edge:
  if find_village(village, a) != find_village(village, b):
    union_village(village, a, b)
    result += c
    last = c

print(result - last)
