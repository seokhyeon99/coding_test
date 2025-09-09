import sys
input = sys.stdin.readline

import heapq # when using heap
heap = []

n = int(input())
for i in range(n):
    num = int(input())
    if num == 0:
        if heap: # if heap is not empty
            print(heapq.heappop(heap))
        else: # if heap is empty
            print(0)
    else: 
        heapq.heappush(heap, num)



''' when using list -> TimeoutError
n = int(input())
idx = 0
a = []

for i in range(n):
    num = int(input())
    if num == 0: # print the minimum number of the list and remove it. 
        if idx < len(a):
            print(a[idx])
            idx += 1
        else: # If the list is empty, print 0.
            print(0)
    else: # add number
        if idx < len(a): 
            if a[-1] < num:
                a.append(num)
            elif a[idx] > num:
                a.insert(idx, num)
            else:
                for j in range(idx, len(a)+1):
                    if a[j] <= num and num <= a[j+1]:
                        a.insert(j+1, num)
                        break
        else: # in case the list is empty
            a.append(num)
'''