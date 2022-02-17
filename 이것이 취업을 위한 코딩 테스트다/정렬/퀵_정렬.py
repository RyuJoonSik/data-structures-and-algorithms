array_1 = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort_1(array_1, start, end):
  if start >= end:
    return

  pivot = start
  left = start + 1
  right = end
  while left <= right:
    # 왼쪽부터 피벗보다 큰 갑 찾기
    while left <= end and array_1[left] <= array_1[pivot]:
      left += 1
    
    # 오른쪽부터 피벗보다 작은 값 찾기
    while right > start and array_1[right] >= array_1[pivot]:
      right -= 1

    if left > right:
      array_1[right], array_1[pivot] = array_1[pivot], array_1[right]
    else:
      array_1[left], array_1[right] = array_1[right], array_1[left]
  quick_sort_1(array_1, start, right - 1)
  quick_sort_1(array_1, right + 1, end)

quick_sort_1(array_1, 0, len(array_1) - 1)
print(array_1)

array_2 = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort_2(array):
  if len(array) <= 1:
    return array

  pivot = array[0]
  tail = array[1:]

  left_side = [x for x in tail if x <= pivot]
  right_side = [x for x in tail if x > pivot]

  return quick_sort_2(left_side) + [pivot] + quick_sort_2(right_side)

print(quick_sort_2(array_2))