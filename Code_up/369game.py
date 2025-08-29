'''
 3 6 9 게임은?
여러 사람이 순서를 정한 후, 순서대로 수를 부르는 게임이다.
만약 3, 6, 9 가 들어간 수를 자신이 불러야 하는 상황이라면, 수를 부르는 대신 "박수(X)" 를 쳐야 한다.
33과 같이 3,6,9가 두 번 들어간 수 일때, "짝짝"과 같이 박수를 두 번 치는 형태도 있다. 
'''

# input
# 30 보다 작은 정수 1개가 입력된다. (1 ~ 29)

# output1
# 1 부터 그 수까지 순서대로 공백을 두고 수를 출력하는데,
# 3 또는 6 또는 9가 포함 되어있는 수인 경우, 그 수 대신 영문 대문자 X 를 출력한다.

def is369(num):
    ans = ''
    if (num//10) != 0 and (num//10)%3 == 0: #10의자리수가 3,6,9
        ans += 'X'
    if (num % 10) != 0 and (num % 10) % 3 == 0:#1의자리수가 3,6,9
        ans += 'X'
    return ans

#num = int(input())
num_list = [45, 70]
for num in num_list:
    print(f'num: {num}')
    for i in range(1, num+1):
        if(is369(i) == ''):
            print(i, end=' ')
        else:
            print(is369(i), end=' ')
    print()


# num = int(input())
# for i in range(1, num+1):
#     if(i%10 != 0 and (i%10)%3 == 0): #1의자리수가 3,6,9
#         print('X', end=' ')
        
#     elif((i//10) != 0 and (i//10)%3 == 0): #10의자리수가 3
#         print('X', end=' ')    
    
#     else:
#         print(i, end=' ')