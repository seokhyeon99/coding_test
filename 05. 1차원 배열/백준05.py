#10818
import sys
n = sys.stdin.readline().strip()
a = list(map(int, sys.stdin.readline().strip().split()))
print(min(a), max(a))

#2562
import sys
a=[]
for i in range(9):
    a.append(sys.stdin.readline().strip())
a = list(map(int,a))
print(max(a))
print(a.index(max(a))+1)

#2577
import sys
a = sys.stdin.readline().strip()
b = sys.stdin.readline().strip()
c = sys.stdin.readline().strip()
mul = int(a)*int(b)*int(c)
count = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
while(mul != 0):
    rest = mul % 10
    count[rest] += 1
    mul //= 10
for i in range(10):
    print(count[i])
    
#3052
import sys
a = []
for i in range(10):
    a.append(sys.stdin.readline().strip())
a = list(map(int, a))
count = [0]*42
for i in range(10):
    index = a[i] % 42
    count[index] += 1
c = 0
for i in range(42):
    if count[i] != 0:
        c += 1
print(c)

#1546
import sys
n = sys.stdin.readline().strip()
a = list(map(int, sys.stdin.readline().strip().split()))
m = max(a)
sum = 0
for i in range(int(n)):
    sum += (a[i]/m*100)
print(sum/int(n))

#8958
import sys
n = sys.stdin.readline().strip()
for i in range(int(n)):
    sum = 0
    string = sys.stdin.readline().strip()
    string = string + "X"
    length = len(string)
    count = 0
    for i in range(length):
        if string[i] == 'O':
            count += 1
        else:
        	while(count != 0):
        		sum += count
        		count -= 1
    print(sum)

#4344
import sys
n = sys.stdin.readline().strip()
for i in range(int(n)):
    a = list(map(int, sys.stdin.readline().strip().split()))
    sum = 0
    count = 0
    for i in range(len(a)-1):
        sum += a[i+1]
        avr = sum / a[0]
    for i in range(len(a)-1):
        if a[i+1] > avr:
            count += 1
    print('%.3f%%' %(count/a[0]*100))
        

    