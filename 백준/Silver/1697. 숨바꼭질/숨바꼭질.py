import sys
input = sys.stdin.readline
from collections import deque

n, k = map(int, input().split())
if k < n:
    print(n-k)
else:
    min_time = [-1]*100001
    min_time[n] = 0
    queue = deque([n])
    while queue:
        cur_pos = queue.popleft()
        if min_time[k] != -1:
            break
        for next_pos in [cur_pos+1, cur_pos-1, cur_pos*2]:
            if next_pos >= 0 and next_pos <= 100000 and min_time[next_pos] == -1:
                min_time[next_pos] = min_time[cur_pos]+1
                queue.append(next_pos)
    print(min_time[k])