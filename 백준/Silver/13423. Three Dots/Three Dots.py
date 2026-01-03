#1 중간값 찾기
import sys
input = sys.stdin.readline

testcase = int(input())
for _ in range(testcase):
    n = int(input())
    nums = sorted(list(map(int, input().split())))
    nums_set = set(nums) # 시간복잡도 O(1)을 위해 Set 사용

    cnt = 0

    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)):
            mid = (nums[i] + nums[j]) / 2
            if mid in nums_set:
                cnt += 1
    
    print(cnt)

#2 마지막 값 찾기
import sys
input = sys.stdin.readline

testcase = int(input())
for _ in range(testcase):
    n = int(input())
    nums = sorted(list(map(int, input().split())))
    nums_set = set(nums) # 시간복잡도 O(1)을 위해 Set 사용

    cnt = 0
    max_val = nums[-1]

    for i in range(len(nums)-2):
        for j in range(i+1, len(nums)-1):
            target = nums[j] * 2 - nums[i] # 등차수열 공식 (c = 2b - a)
            
            # target이 최댓값보다 크면 즉시 중단
            if target > max_val:
                break
            
            if target in nums_set:
                cnt += 1
    
    print(cnt)
