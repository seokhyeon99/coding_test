'''
a(1) = 0
a(2) = 1
a(3) = 1
a(4) = 2
a(n) = min(a(n/3), a(n/2), a(n-1)) + 1
'''

a = [0, 0, 1, 1]
n = int(input())
for i in range(4, n+1):
    if i%3 == 0 and i%2 == 0:
        min_a = min(a[i//3], a[i//2], a[i-1])+1
    elif i%3 == 0:
        min_a = min(a[i//3], a[i-1])+1
    elif i%2 == 0:
        min_a = min(a[i//2], a[i-1])+1
    else:
        min_a = a[i-1]+1
    a.append(min_a)
print(a[n])