'''입력
바둑알이 깔려 있는 상황이 19 * 19 크기의 정수값으로 입력된다.
십자 뒤집기 횟수(n)가 입력된다.
십자 뒤집기 좌표가 횟수(n) 만큼 입력된다. 단, n은 10이하의 자연수이다.
'''

'''출력
십자 뒤집기 결과를 출력한다.
'''

coor = []

for i in range(19): #처음 바둑판
    tmp = input().split()
    tmp1 = []
    for j in range(19):
        tmp1.append(int(tmp[j]))
    coor.append(tmp1)

n = int(input())
for i in range(n):
    x, y = input().split()
    x = int(x)
    y = int(y)
    for j in range(19):
        coor[x-1][j-1] = int(not coor[x-1][j-1]) #가로 뒤집기
        coor[j-1][y-1] = int(not coor[j-1][y-1]) #세로 뒤집기

for i in range(19):
    for j in range(19):
        print(coor[i][j], end=' ')
    print()