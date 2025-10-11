import sys
input = sys.stdin.readline

n = int(input())
conf = []
for i in range(n):
    conf.append(list(map(int, input().split())))
conf = sorted(conf, key = lambda x: (x[1], x[0]))

current_end = 0
count = 0
for start, end in conf:
    if start >= current_end:
        count += 1
        current_end = end
print(count)