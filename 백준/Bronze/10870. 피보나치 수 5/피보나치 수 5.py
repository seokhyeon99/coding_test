import sys
input = sys.stdin.readline

n = int(input())

nums = [0, 1]
for i in range(n-1):
    nums.append(nums[i] + nums[i+1])
    
print(nums[n])