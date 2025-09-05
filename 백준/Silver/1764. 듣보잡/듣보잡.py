a, b = map(int, input().split())
notheard = set()
notseen = set()
for i in range(a):
    notheard.add(input())
for i in range(b):
    notseen.add(input())

notheadandnotseen=[]
for i in notseen:
    if i in notheard:
        notheadandnotseen.append(i)
print(len(notheadandnotseen))
notheadandnotseen.sort()
for i in notheadandnotseen:
    print(i)