import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num = []
for i in range(1,n+1):
    num.append(i)
tmp = [0]*8
loc = 0
def comb_print(quan, idx):
    if len(num[idx:]) < quan:
        return 0
    elif len(num[idx:]) == quan:
        for i in range(quan):
            tmp[m-quan+i] = num[idx+i]
        for j in range(m):
            print(tmp[j], end=' ')
        print()
    else: # len(num[idx:]) > quan
        if quan == 1:
            for i in num[idx:]:
                tmp[m-quan] = i
                for j in range(m):
                    print(tmp[j], end=' ')
                print()
        else:
            for i in range(len(num[idx:])):
                tmp[m-quan] = num[idx+i]
                comb_print(quan-1,idx+i+1)

comb_print(m, loc)