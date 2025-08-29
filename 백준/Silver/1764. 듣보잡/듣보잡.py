n, m = map(int, input().split())
notListened = set()
notSeen = set()
for i in range(n):
    notListened.add(input())
for i in range(m):
    notSeen.add(input())
notListenedAndSeen = []
for i in notSeen:
    if i in notListened:
        notListenedAndSeen.append(i)
notListenedAndSeen.sort()
print(len(notListenedAndSeen))
for i in notListenedAndSeen:
    print(i)