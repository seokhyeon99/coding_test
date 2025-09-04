'''
n_com = int(input())
n_rel = int(input())
rel = [[0]*2]*n_rel
for i in range(n_rel):
    rel[i] = list(map(int, input().split()))
# print(rel)

err_lst = [1]
final_err_lst = []
while True:
    # print(err_lst)
    if err_lst == []:
        break
    err = err_lst.pop(0)
    # print(err)
    for i in range(n_rel):
        if err in rel[i]:
            for j in rel[i]:
                if j != err and j not in err_lst and j not in final_err_lst:
                    err_lst.append(j)
            # print(rel[0])
    final_err_lst.append(err)
print(len(final_err_lst)-1)
'''



from collections import deque
n_node = int(input())
n_edge = int(input())

linked = [[0]*(n_node+1) for _ in range(n_node+1)]
for i in range(n_edge):
    x, y = map(int, input().split())
    linked[x][y] = 1
    linked[y][x] = 1

# print(linked)
hacked = [0]*(n_node+1)
hacked[1] = 1
queue = deque([1])
count = 0

while queue:
    # print(queue)
    current_node = queue.popleft()
    # print(current_node)
    for i in range(n_node+1):
        if linked[current_node][i] and not hacked[i]:
            queue.append(i)
            hacked[i] = 1
            count += 1
            # print(count)
print(count)
