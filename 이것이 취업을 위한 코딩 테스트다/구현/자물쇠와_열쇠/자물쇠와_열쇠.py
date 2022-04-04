# def solution(key, lock):
#     board_size = 2 * (len(key) - 1) + len(lock)
#     lock_start = len(key) - 1
#     lock_end = lock_start + len(lock) - 1
    
#     print(lock_start)
#     print(lock_end)
    
#     board = [[0] * board_size for _ in range(board_size)]
    
#     for i in range(lock_start, lock_end + 1):
#         for j in range(lock_start, lock_end + 1):
#             board[i][j] = lock[i - lock_start][j - lock_start]
    
#     for i in range(board_size - lock_start):
#         for row in range(i, i + len(key)):
#             for column in range(i, i + len(key)):
#                 if board[row][column] == 0 and key[row - i][column - i] == 1:

def rotate(a):
    n = len(a)
    m = len(a[0])
    result = [[0] * n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            result[j][n - 1 - i] = a[i][j];
    return result

def check(new_lock):
    lock_length = len(new_lock)
    for i in range(lock_length, lock_length * 2):
        for j in range(lock_length, lock_length * 2):
            if new_lock[i][j] != 1:
                return False
    return True

def solution(key, lock):
    n = len(lock)
    m = len(key)
    new_lock = [[0] * (n * 3) for _ in range(n * 3)]
    for i in range(n):
        for j in range(n):
            new_lock[i + n][j + n] = lock[i][j]

    for rotation in range(4):
        key = rotate(key)
        for x in range(n * 2):
            for y in range(n * 2):
                for i in range(m):
                    for j in range(m):
                        new_lock[x + i][y + j] += key[i][j]
                if check(new_lock) == True:
                    return True
                for i in range(m):
                    for j in range(m):
                        new_lock[x + i][y + j] -= key[i][j]
    return False