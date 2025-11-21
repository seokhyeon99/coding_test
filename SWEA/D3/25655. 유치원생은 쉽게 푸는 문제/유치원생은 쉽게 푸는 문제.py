T = int(input())

for test_case in range(T):
    n = int(input())
    if n == 1:
        print(0)
    elif n % 2 == 0:
        for i in range(n//2):
            print(8, end='')
        print()
    else:
        print(4, end='')
        for i in range(n//2):
            print(8, end='')
        print()