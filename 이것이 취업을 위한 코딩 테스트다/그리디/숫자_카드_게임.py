from json.encoder import INFINITY


n, m = map(int, input().split())
cards = []

for i in range(n):
  cards.append(list(map(int, input().split())))

print(cards)

answer = -INFINITY

for i in range(n):
  col_min = min(cards[i])
  answer = max(answer, col_min)

print(answer)
