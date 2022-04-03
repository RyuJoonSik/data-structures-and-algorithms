def solution(key, lock):
    board_size = 2 * (len(key) - 1) + len(lock)
    lock_start = len(key) - 1
    lock_end = lock_start + len(lock) - 1
    
    print(lock_start)
    print(lock_end)
    
    board = [[0] * board_size for _ in range(board_size)]
    
    for i in range(lock_start, lock_end + 1):
        for j in range(lock_start, lock_end + 1):
            board[i][j] = lock[i - lock_start][j - lock_start]
    
    print(board)
    
    for i in range(board_size):
        for j in range(board_size):
            
