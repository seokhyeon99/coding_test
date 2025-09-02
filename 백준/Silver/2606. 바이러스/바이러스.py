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