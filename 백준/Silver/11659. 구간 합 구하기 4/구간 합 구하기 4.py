import sys

# input 함수를 sys.stdin.readline으로 대체하면 더 빠르게 입력을 받을 수 있습니다.
input = sys.stdin.readline

n, m = map(int, input().split())
number = [0] + list(map(int, input().split()))
sum_list = [0]*(n+1)
sum_list[0] = number[0]

for i in range(1, n+1):
    sum_list[i] = number[i] + sum_list[i-1]
    
for i in range(m):
    a, b = map(int, input().split())
    print(sum_list[b] - sum_list[a-1])