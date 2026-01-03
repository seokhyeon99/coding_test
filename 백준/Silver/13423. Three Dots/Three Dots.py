import sys
input = sys.stdin.readline

testcase = int(input())
for _ in range(testcase):
    n = int(input())
    nums = sorted(list(map(int, input().split())))
    nums_set = set(nums)

    cnt = 0

    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)):
            mid = (nums[i] + nums[j]) / 2
            if mid in nums_set:
                cnt += 1
    
    print(cnt)