''' 시간 초과
def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibo(n-1) + fibo(n-2)

n = int(input())
for i in range(n):
    fib_num = int(input())
    num_1 = fibo(fib_num)
    if fib_num == 0:
        num_0 = 1
        num_1 = 0
    elif fib_num == 1:
        num_0 = 0
        num_1 = 1
    else:
        num_0 = fibo(fib_num - 1)
    print(num_0, num_1)
'''

'''
f(0) = 0*f(1) + 1*f(0)

f(1) = 1*f(1) + 0*f(0)

f(2) = 1*f(1) + 1*f(0)

f(3) = f(2) + f(1)
     = 2*f(1) + 1*f(0)

f(4) = f(3) + f(2)
     = 2*f(2) + f(1)
     = 3*f(1) + 2*f(0)

f(5) = f(4) + f(3)
     = 2*f(3) + f(2)
     = 3*f(2) + 2*f(1)
     = 5*f(1) + 3*f(0)

f(6) = f(5) + f(4)
     = 8*f(1) + 5*f(0)
'''



fibo = [0, 1]
n = int(input())
fib_num = []
for i in range(n):
    fib_num.append(int(input()))

for i in range(2,max(fib_num)+1):
    fibo.append(fibo[i-2]+fibo[i-1])

for i in fib_num:
    if i == 0:
        cnt_0 = 1
    elif i == 1:
        cnt_0 = 0
    else:
        cnt_0 = fibo[i-1]
    cnt_1 = fibo[i]
    print(cnt_0, cnt_1)