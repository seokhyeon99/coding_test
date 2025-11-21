T = int(input())

for test_case in range(1, T+1):
    n, l = map(int, input().split())
    score = [0]*n
    cal = [0]*n
    check_used = [[0]*n for _ in range(l+1)]
    for i in range(n):
        score[i], cal[i] = map(int, input().split())
    best_for_cal = [0]*(l+1)
    # cur_max = 0
    for i in range(1,l+1):
        best_for_cal[i] = best_for_cal[i-1]
        check_used[i] = check_used[i-1][:]

        for j in range(n):
            current_cal = cal[j]
            current_score = score[j]
            if current_cal > i or check_used[i-current_cal][j] == 1:
                continue

            new_score = best_for_cal[i - current_cal] + current_score
            if new_score > best_for_cal[i]:
                best_for_cal[i] = new_score
                check_used[i] = check_used[i - current_cal][:]
                check_used[i][j] = 1
    print('#%d %d' %(test_case, best_for_cal[l]))