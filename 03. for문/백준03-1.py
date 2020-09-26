#2739
a = int(input())
for i in range(1, 10):
    print("%d * %d = %d" %(a, i, a*i))
    
#10950
number = int(input())
for i in range(number):
    a,b = input().split()
    print(int(a)+int(b))
    
#8393
n = int(input())
sum = 0
for i in range(1,n+1):
    sum += i
print(sum)