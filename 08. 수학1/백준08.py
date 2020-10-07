#1712
import sys
a,b,c = sys.stdin.readline().strip().split()
if int(c)>int(b):
    print(int(a)//(int(c)-int(b))+1)
else:
    print(-1)
