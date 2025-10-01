import sys
input = sys.stdin.readline

n, k = map(int, input().split())
min_time = [-1]*100001
min_time[n] = 0
queue = [n]
# print(queue)
i = 0
while queue:
    if min_time[k] != -1:
        break
    if queue[i]+1 >= 0 and queue[i]+1 <= 100000 and min_time[queue[i]+1] == -1:
        min_time[queue[i]+1] = min_time[queue[i]]+1
        queue.append(queue[i]+1)
        # print(queue[i]+1, min_time[queue[i]+1])
    if queue[i]-1 >= 0 and queue[i]-1 <= 100000 and min_time[queue[i]-1] == -1:
        min_time[queue[i]-1] = min_time[queue[i]]+1
        queue.append(queue[i]-1)
        # print(queue[i]-1, min_time[queue[i]-1])
    if queue[i]*2 >= 0 and queue[i]*2 <= 100000 and min_time[queue[i]*2] == -1:
        min_time[queue[i]*2] = min_time[queue[i]]+1
        queue.append(queue[i]*2)
        # print(queue[i]*2, min_time[queue[i]*2])
    i += 1
# for i in range(20):
#     print(i, end= ' ')
# print()
# for i in range(20):
#     print(min_time[i], end=' ')
# print()
print(min_time[k])

# for i in range(n-1, -1, -1):
#     min_time[i] = min(min_time[2*i], min_time[i+1]+1, min_time[i-1])+1
# for i in range(n+1, k+1):
#     if i%2==0:
#         min_time[i] = min(min_time[n//2], min_time[n-1], min_time[n+1]) + 1
#     else:
#         min_time[i] = min(min_time[n-1], min_time[n+1]) + 1
