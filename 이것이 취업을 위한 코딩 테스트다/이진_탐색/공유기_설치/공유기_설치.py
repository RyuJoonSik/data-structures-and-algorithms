home_count, wifi_count= map(int, input().split())
home_points = []

for _ in range(home_count):
  home_points.append(int(input()))

home_points.sort()
print(home_points)

start = 1
end = home_points[-1] - home_points[0]
result = 0

while (start <= end):
  mid = (start + end) // 2
  value = home_points[0]
  count = 1
  for i in range(1, home_count):
    if home_points[i] >= value + mid:
      value = home_points[i]
      count += 1
  if count >= wifi_count:
    start = mid + 1
    result = mid
  else:
    end = mid - 1

print(result)
