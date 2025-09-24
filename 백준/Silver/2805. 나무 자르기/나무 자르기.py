import sys
input = sys.stdin.readline

n, m = map(int, input().split())
tree = list(map(int, input().split()))

# range of height: 0 ~ max(tree)
start = 0
end = max(tree)
height = 0
result = 0
while(True):
    if start > end:
        break    
    height = (start+end)//2
    sum = 0
    for i in range(n):
        if tree[i]-height > 0:
            sum += tree[i]-height
    if sum >= m:
        start = height+1
        result = height
    else: # sum < m
        end = height-1
print(result)
    


'''
import sys
input = sys.stdin.readline

n, m = map(int,input().split())
tree = sorted(list(map(int, input().split())))
copied_tree = tree.copy()

for i in range(n):
    tree[i] -= tree[n-1]

height = 0

for i in range(0,n):
    if i == n-1:
        if m%(i+1):
            divided_m = m//(i+1)+1
        else:
            divided_m = m//(i+1)
        height = copied_tree[0] - divided_m
        break
    elif (i+1)*(tree[n-i-1] - tree[n-i-2]) >= m:
        if m%(i+1):
            divided_m = m//(i+1)+1
        else:
            divided_m = m//(i+1)
        height = copied_tree[n-i-1] - divided_m
        break
    else:
        m -= (i+1) * (tree[n-i-1] - tree[n-i-2])

print(height)
'''
