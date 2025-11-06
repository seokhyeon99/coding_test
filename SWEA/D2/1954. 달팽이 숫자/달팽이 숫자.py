T = int(input())
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n = int(input())
    snail = [[0]*n for _ in range(n)]

    dir_x = [1, 0, -1, 0]
    dir_y = [0, 1, 0, -1]
    idx = 0
    cur_x = 0
    cur_y = 0

    for i in range(1, n**2+1):
        snail[cur_y][cur_x] = i
        next_y = cur_y + dir_y[idx%4]
        next_x = cur_x + dir_x[idx%4]
        if next_x < 0 or next_x > n-1 or next_y < 0 or next_y > n-1 or  snail[next_y][next_x] != 0:
            idx += 1
            next_y = cur_y + dir_y[idx%4]
            next_x = cur_x + dir_x[idx%4]
        cur_x = next_x
        cur_y = next_y

    print('#%d' %test_case)
    for i in range(n):
        for j in range(n):
            print(snail[i][j], end=' ')
        print()
    # ///////////////////////////////////////////////////////////////////////////////////