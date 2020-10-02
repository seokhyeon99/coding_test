#11654
import sys
a = sys.stdin.readline().strip()
print(ord(a))

#11720
import sys
a = sys.stdin.readline().strip()
b = sys.stdin.readline().strip()
sum = 0
for i in range(int(a)):
    sum += int(b[i:i+1])
print(sum)

#10809
import sys
a = sys.stdin.readline().strip()
for i in range(97,123):
    print(a.find(chr(i)), end=" ")
    
#1157
import sys
a = sys.stdin.readline().strip()
count = [0]*26
for i in range(len(a)):
    if ord(a[i:i+1])>=65 and ord(a[i:i+1])<=90:
        count[ord(a[i:i+1])-65] += 1
    elif ord(a[i:i+1])>= 97 and ord(a[i:i+1]) <=122:
        count[ord(a[i:i+1]) - 97] += 1
first = max(count)
first_index = count.index(first)
count.pop(first_index)
second = max(count)
if first == second:
    print('?')
else:
    print(chr(first_index+65))

