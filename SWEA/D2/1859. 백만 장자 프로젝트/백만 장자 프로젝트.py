def argmax(lst):
    max = 0
    for i in range(len(lst)):
        if lst[i] > lst[max]:
            max = i
    return max

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    n = int(input())
    price = list(map(int, input().split()))
    idx = 0
    sum = 0
    while idx != n:
        max = idx + argmax(price[idx:])
        for i in range(idx, max):
            sum += price[max] - price[i]
        idx = max + 1
    print('#%d %d' %(test_case, sum))
    # ///////////////////////////////////////////////////////////////////////////////////
