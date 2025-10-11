import sys
input = sys.stdin.readline

s = set()

n = int(input())
for i in range(n):
    op = input().split()
    if op[0] == 'add':
        s.add(int(op[1]))
    elif op[0] == 'remove':
        s.discard(int(op[1]))
    elif op[0] == 'check':
        if int(op[1]) in s:
            print(1)
        else:
            print(0)
    elif op[0] == 'toggle':
        if int(op[1]) in s:
            s.discard(int(op[1]))
        else:
            s.add(int(op[1]))
    elif op[0] == 'all':
        s.update([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20])
    else:
        s = set()