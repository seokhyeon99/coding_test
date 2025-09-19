import sys
input = sys.stdin.readline

n = int(input()) # length of the paper
paper = []
for i in range(n):
    paper.append(list(map(int, input().split())))
count = [0,0] # [white, blue]
    
def search(n, x_start, y_start):
    global count # deal with count value
    value = paper[x_start][y_start]
    for i in range(x_start, x_start+n):# check whether the color of each piece is same or not
        for j in range(y_start, y_start+n):
            if paper[i][j] != value:
                # chk = 1
                # break
                half = n//2 # divide the paper into four parts equally
                search(half, x_start+0, y_start+0) # upper-left piece
                search(half, x_start+half, y_start+0) # upper-right piece
                search(half, x_start+0, y_start+half) # lower-left piece
                search(half, x_start+half, y_start+half) # lower-right piece
                return
    count[value] += 1 # count the color of each piece

search(n,0,0)
print(count[0])
print(count[1])