from itertools import combinations

n, m = map(int, input().split())
chicken, house = [], []

for r in range(n):
  data = list(map(int, input().split()))
  for c in range(n):
    if data[c] == 1:
      house.append((r, c))
    elif data[c] == 2:
      chicken.append((r, c))

candidates = list(combinations(chicken, m))
answer = 1e9


for candidate in candidates:
  total = 0
  for house_x, house_y in house:
    min_dist = 1e9
    for chicken_x, chicken_y in candidate:
      min_dist = min(abs(house_x - chicken_x ) + abs(house_y - chicken_y), min_dist)
    total += min_dist
  answer = min(answer, total)

print(answer)
