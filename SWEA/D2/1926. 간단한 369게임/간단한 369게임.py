n = int(input())

for i in range(1, n+1):
    count = 0
    cur = i
    while i != 0:
        rest = i % 10
        if rest != 0 and rest % 3 == 0:
            count += 1
        i = i // 10
    if count == 0:
        print(cur, end=' ')
    else:
        print('-'*count, end=' ')