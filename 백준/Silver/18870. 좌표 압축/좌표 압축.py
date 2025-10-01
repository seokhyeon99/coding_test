import sys
input = sys.stdin.readline

n = int(input())
x = list(map(int, input().split()))

x_set = set(x)
x_list = sorted(list(x_set))
x_dic = {x_list[i]: i for i in range(len(x_list))}

for i in x:
    print(x_dic[i], end=' ')