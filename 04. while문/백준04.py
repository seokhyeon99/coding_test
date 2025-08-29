#10952
import sys
a,b = sys.stdin.readline().strip().split()
while(int(a) != 0 and int(b) != 0):
    print(int(a)+int(b))
    a,b = sys.stdin.readline().strip().split()

#10951  
import sys
while True:
    a = sys.stdin.readline().strip()
    if not a:
        break
    b,c = a.split()
    print(int(b)+int(c))
    
'''
#Test
import sys
f=open("C:/Users/이석현/Desktop/sample.txt")
while True:
    a = f.readline().strip()
    if not a:
        break
    b,c = a.split()
    print(int(b)+int(c))
'''

#1110
import sys
first = sys.stdin.readline().strip()
a = int(first)
count = 0
c = a % 10
b = a // 10
a = (b + c) % 10 + 10 * c
count += 1
while a != int(first):
    c = a % 10
    b = a // 10
    a = (b + c) % 10 + 10 * c 
    count += 1
print(count)