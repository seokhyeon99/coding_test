'''
if 4, 

3  2  1
--------
0  0  4 -> 4! / 4!
0  1  2 -> 3! / 2!
0  2  0 -> 2! / 2!
1  0  1 -> 2! / 1!

=> don't consider the number of times that 1 has been used
'''

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