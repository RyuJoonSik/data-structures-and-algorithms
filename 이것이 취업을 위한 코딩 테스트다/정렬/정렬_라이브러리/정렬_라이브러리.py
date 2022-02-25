arr_1 = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
result_1 = sorted(arr_1);

print(result_1)

arr_2 = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]
arr_2.sort();

print(arr_2)

arr_3 = [('바나나', 2), ('사과', 5), ('당근', 3)]
result_3 = sorted(arr_3, key=lambda x: x[1])
print(result_3)
arr_3.sort(key=lambda x: x[1])
print(arr_3);