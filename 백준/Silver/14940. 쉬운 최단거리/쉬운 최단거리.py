import sys
input = sys.stdin.readline
from collections import deque

n, m = map(int, input().split())
location = []
cur = []
for _ in range(n):
    location.append(list(map(int, input().split())))
checked = [[0]*m for _ in range(n)]
dist_map = [[0]*m for _ in range(n)]
        
target_x = 0
target_y = 0

for i in range(n):
    for j in range(m):
        if location[i][j] == 2:
            target_x = j
            target_y = i
            break
            
queue = deque([[target_x,target_y]])
dist_map[target_y][target_x] = 0
checked[target_y][target_x] = 1
while queue:
    cur = queue.popleft()
    for idx in [[cur[0]+1,cur[1]+0],[cur[0]-1,cur[1]+0],[cur[0]+0,cur[1]+1],[cur[0]+0,cur[1]-1]]:
        if idx[0] >= 0 and idx[0] < m and idx[1] >= 0 and idx[1] < n and checked[idx[1]][idx[0]] == 0 and location[idx[1]][idx[0]] != 0:
            checked[idx[1]][idx[0]] = 1
            dist_map[idx[1]][idx[0]] = dist_map[cur[1]][cur[0]]+1
            queue.append([idx[0],idx[1]])
            # print(idx[0], idx[1])

for i in range(n):
    for j in range(m):
        if checked[i][j] == 0 and location[i][j] == 1:
            dist_map[i][j] = -1
        print(dist_map[i][j], end=' ')
    print()