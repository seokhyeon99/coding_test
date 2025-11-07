'''
T = int(input())
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n, m = map(int, input().split())
    fly = []
    for i in range(n):
        fly.append(list(map(int, input().split())))
    max = 0
    for i in range(n-m+1):
        for j in range(n-m+1):
            sum = 0
            for k in range(m):
                for l in range(m):
                    sum += fly[j+l][i+k]
            if sum > max:
                max = sum
    print('#%d %d' %(test_case, max))
    # ///////////////////////////////////////////////////////////////////////////////////
'''
T = int(input())
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n, m = map(int, input().split())
    fly = []
    for i in range(n):
        fly.append(list(map(int, input().split())))
    totalsum = [[0]*(n+1) for _ in range(n+1)]
    for i in range(1, n+1):
        for j in range(1, n+1):
            totalsum[i][j] = totalsum[i][j-1] + totalsum[i-1][j] - totalsum[i-1][j-1] + fly[i-1][j-1]

    max = 0
    for i in range(m, n+1):
        for j in range(m, n+1):
            current_sum = totalsum[i][j] - totalsum[i][j-m] - totalsum[i-m][j] + totalsum[i-m][j-m]
            if current_sum > max:
                max = current_sum
            
    print('#%d %d' %(test_case, max))
    # ///////////////////////////////////////////////////////////////////////////////////