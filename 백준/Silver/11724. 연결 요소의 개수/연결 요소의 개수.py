import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
table = [[0]*(n+1) for i in range(n+1)]
checked = [0]*(n+1)
for i in range(m):
    a, b = map(int, input().split())
    table[a][b] = 1
    table[b][a] = 1

def find_chained_factors(a):
    checked[a] = 1
    for k in range(1,n+1):
        if table[a][k] == 1:
            if checked[k] == 0:
                find_chained_factors(k)
            table[a][k] = 0

count = 0
for i in range(1,n+1):
    if checked[i]:
        continue
    for j in range(1,n+1):
        if table[i][j] == 1:
            table[i][j] = 0
            # print(i,j)
            if checked[i] == 0:
                find_chained_factors(i)
            if checked[j] == 0:
                find_chained_factors(j)
    count += 1
print(count)