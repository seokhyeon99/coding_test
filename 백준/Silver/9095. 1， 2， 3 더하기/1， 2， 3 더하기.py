'''
# Combination
# if 4, 

# 3  2  1
# --------
# 0  0  4 -> 4! / 4!
# 0  1  2 -> 3! / 2!
# 0  2  0 -> 2! / 2!
# 1  0  1 -> 2! / 1!

# => don't consider the number of times that 1 has been used


def fact(n):
    fact = 1
    for i in range(n,0,-1):
        fact = fact * i
    return fact


        
n = int(input())

for i in range(n):
    num = int(input())
    n_3 = num // 3 
    cnt = 0
    for j in range(n_3+1): # j: number of times 3 has been used
        num_3 = num - j * 3
        n_2 = num_3 // 2
        for k in range(n_2+1): # k: number of times 2 has been used
            cnt += int(fact(j + k + num_3 - 2*k) / (fact(j) * fact(k) * fact(num_3 - 2*k)))
    print(cnt)
'''

# Dynamic Programming
# n = (n-1) + 1 or (n-2) + 2 or (n-3) + 3
# f(1) = 1, f(2) = 2, f(3) = 4
# f(n) = f(n-1) + f(n-2) + f(n-3)

n = int(input())
num = []
for i in range(n):
    num.append(int(input()))
get_combination = [0] * (max(num)+1)
get_combination[1] = 1
get_combination[2] = 2
get_combination[3] = 4
for i in range(4, max(num)+1):
    get_combination[i] = get_combination[i-1] + get_combination[i-2] + get_combination[i-3]

for i in num:
    print(get_combination[i])
