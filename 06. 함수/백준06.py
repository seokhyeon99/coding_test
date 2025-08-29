#15596
def solve(a):
    sum = 0
    for i in range(len(a)):
        sum += a[i]
    return sum

#4673
def self_num():
    a = list(range(10000))
    b = []
    c = []
    for i in range(10000):
        d = i
        while(i != 0):
            d += (i%10)
            i //= 10
        if d <= 10000:
            b.append(d)
    b = sorted(list(set(b)))
    for i in a:
        if i not in b:
            c.append(i)
    for i in c:
        print(i)

self_num()            

#1065
def hansu():
    import sys
    #a = sys.stdin.readline().strip()
    a = 67
    count = 0
    for i in range(a):
        b = set()
        i += 1
        while((i//10) != 0):
            b.add(((i//10)%10)-(i%10))
            i //= 10
        if len(b) == 1 or len(b) == 0:
            count += 1
    print(count)

hansu()


def hansu():
    import sys
    a = sys.stdin.readline().strip()
    count = 0
    for i in range(int(a)):
        b = set()
        i += 1
        while((i//10) != 0):
            b.add(((i//10)%10)-(i%10))
            i //= 10
        if len(b) == 1 or len(b) == 0:
            count += 1
    print(count)

hansu()