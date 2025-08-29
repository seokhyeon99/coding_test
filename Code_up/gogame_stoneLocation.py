'''입력
바둑판에 올려 놓을 흰 돌의 개수(n)가 첫 줄에 입력된다.
둘째 줄 부터 n+1 번째 줄까지 힌 돌을 놓을 좌표(x, y)가 n줄 입력된다.
n은 10이하의 자연수이고 x, y 좌표는 1 ~ 19 까지이며, 똑같은 좌표는 입력되지 않는다.
'''

'''출력
흰 돌이 올려진 바둑판의 상황을 출력한다.
흰 돌이 있는 위치는 1, 없는 곳은 0으로 출력한다.
'''

n = int(input())

coor = []
for i in range(19):
    tmp = []
    for j in range(19):
        tmp.append(0)
    coor.append(tmp)
# print(coor)

for i in range(n):
    x, y = input().split()
    x = int(x)
    y = int(y)
    coor[x-1][y-1] = 1

for i in range(19):
    for j in range(19):
        print(coor[i][j], end =' ')
    print()