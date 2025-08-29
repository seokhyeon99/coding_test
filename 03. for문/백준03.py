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

#15552
import sys
n = sys.stdin.readline().split()
for i in range(int(n[0])):
    a, b = sys.stdin.readline().strip().split() 
    print(int(a)+int(b))
    '''
    sys.stdin.readline: input과 유사하지만 시간이 짧다. 개행문자(\n)이 같이 읽어진다.
    strip으로 앞뒤의 개행문자를 없앨 수 있다.
    split으로 띄어쓰기 단위로 문자를 쪼갤 수 있다.
    '''

#2741
import sys
n = sys.stdin.readline().split()
for i in range(int(n[0])):
    print(i+1)
    
#2742
import sys
n = sys.stdin.readline().split()
for i in range(int(n[0])):
    print(int(n[0])-i)
    
#11021
import sys
n = sys.stdin.readline().strip()
for i in range(int(n)):
    a, b = sys.stdin.readline().strip().split()
    print("Case #%d: %d" %(i+1,int(a)+int(b)))
          
#11022
import sys
n = sys.stdin.readline().strip()
for i in range(int(n)):
    a,b = sys.stdin.readline().strip().split()
    print("Case #%d: %d + %d = %d" %(i+1, int(a), int(b), int(a)+int(b)))
        
#2438
import sys
n = sys.stdin.readline().strip()
for i in range(int(n)):
    print("*"*(i+1))

#2439
import sys
n = sys.stdin.readline().strip()
for i in range(int(n)):
    print(" "*(int(n)-1-i), end="")
    print("*"*(i+1))

#10871
import sys
n, standard = sys.stdin.readline().strip().split()
a = sys.stdin.readline().strip().split()
for i in range(int(n)):
    if int(a[i])<int(standard):
        print("%d " %int(a[i]),end="")