'''입력
첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.

둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다. 방법은 i j로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다. (1 ≤ i ≤ j ≤ N)

도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.

ex)
5 4
1 2
3 4
1 4
2 2'''

'''출력
모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.

ex)
3 4 1 2 5
'''

bas_num, chg_num = input().split()
bas = []
for i in range(int(bas_num)):# 바구니마다 1부터 시작하는 숫자를 넣는다.
    bas.append(i+1)

for i in range(int(chg_num)):
    start, end = input().split()
    start, end = int(start), int(end)
    cnt = (end - start)//2 + (end-start)%2 # 바구니의 순서를 역순으로 만드는 횟수

    for j in range(0,cnt):#바구니 역순으로 만들기
        # print('j',start-1+j,'k',end-1-j)
        tmp = bas[start-1+j]
        bas[start-1+j] = bas[end-1-j]
        bas[end-1-j] = tmp
    
for i in range(int(bas_num)):#출력
    print(bas[i], end=' ')
print()