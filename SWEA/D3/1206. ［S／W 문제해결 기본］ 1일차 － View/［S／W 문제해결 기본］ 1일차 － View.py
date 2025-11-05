for test_case in range(1, 11):
    # ///////////////////////////////////////////////////////////////////////////////////
    n = int(input())
    building = list(map(int, input().split()))
    sum = 0
    checked = []
    for i in range(2, n-2):
        if i in checked:
            continue
        if max(building[i-2:i+3]) == building[i]:
            sum += building[i] - sorted(building[i-2:i+3])[3]
            for j in range(2):
                checked.append(i+j+1)
    print('#%d %d' %(test_case, sum))
    # ///////////////////////////////////////////////////////////////////////////////////