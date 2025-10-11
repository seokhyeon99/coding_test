import sys
input = sys.stdin.readline
from collections import deque
queue = deque([])

m, n = map(int, input().split())
box = []
for i in range(n):
    box.append(list(map(int, input().split())))

for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append([i,j])

day = 0
while(True):
    len_queue = len(queue)
    if len_queue == 0:
        day -= 1
        break
    for _ in range(len_queue):
        cur_y, cur_x = queue.popleft()
        for del_x, del_y in [[1,0],[-1,0],[0,1],[0,-1]]:
            next_x = cur_x + del_x
            next_y = cur_y + del_y
            if 0 <= next_x < m and 0 <= next_y < n and box[next_y][next_x] == 0:
                box[next_y][next_x] = 1
                queue.append([next_y, next_x])
    day += 1

for i in range(n):
    for j in range(m):
        if box[i][j] == 0:
            day = -1
print(day)