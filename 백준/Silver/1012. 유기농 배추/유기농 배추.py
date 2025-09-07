import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6) #재귀 호출 한도를 늘려 런타임 에러를 방지

def search(coor, x, y, m, n): # if another cabbage is right beside the current cabbage, set the location as 0
    if x<0 or y<0 or x>=m or y>=n or coor[y][x]==0:
        return 0
    coor[y][x] = 0
    search(coor, x+1, y, m ,n)
    search(coor, x-1, y, m ,n)
    search(coor, x, y+1, m ,n)
    search(coor, x, y-1, m ,n)
    
num = int(input())
for i in range(num):
    m, n, k = map(int, input().split())
    coor = [[0 for j in range(m)] for _ in range(n)]
    for j in range(k): # set location of the current cabbage as 1
        x, y = map(int, input().split())
        coor[y][x] = 1
    cnt = 0
    for cur_y in range(n): # count needed number of the earthworm
        for cur_x in range(m):
            if coor[cur_y][cur_x]:
                search(coor, cur_x, cur_y, m, n)
                cnt += 1
    print(cnt)