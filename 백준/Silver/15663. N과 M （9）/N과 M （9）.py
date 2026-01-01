import sys
input = sys.stdin.readline

# N: 입력받을 숫자의 개수, M: 뽑을 숫자의 개수
n, m = map(int, input().split())
# 전체 숫자 입력 받기
nums = list(map(int, input().split()))

# 중복을 제거하고 오름차순 정렬 (사전 순 출력을 위해 미리 정렬)
num_set = sorted(list(set(nums)))

# [숫자, 개수] 형태로 저장할 2차원 리스트 초기화
num_list = [[0]*2 for _ in range(len(num_set))]

# 각 숫자가 실제로 몇 개씩 있는지 카운트하여 num_list에 저장
for i in range(len(num_list)):
    num_list[i][0] = num_set[i] # 숫자 저장
    for j in nums:
        if num_list[i][0] == j:
            num_list[i][1] += 1 # 개수 카운트

# 현재 만들고 있는 수열을 담을 리스트
combination = []

def dfs():
    # 1. 종료 조건: 수열의 길이가 M이 되면 출력하고 함수 종료
    if len(combination) == m:
        print(*combination)
        return
    
    # 2. 후보 탐색: 정렬된 unique 숫자 리스트를 순회
    for i in range(len(num_list)):
        # 해당 숫자의 남은 개수가 0보다 클 때만 사용 가능
        if num_list[i][1] > 0:
            
            # 상태 변화 (숫자 사용)
            num_list[i][1] -= 1          # 개수 1 감소
            combination.append(num_list[i][0]) # 수열에 추가
            
            # 재귀 호출 (다음 숫자 고르러 가기)
            dfs()
            
            # 원상 복구 (백트래킹 핵심: 나와서 다시 다른 경우의 수를 따지기 위해 복구)
            combination.pop()            # 수열에서 제거
            num_list[i][1] += 1          # 개수 다시 복구

# 탐색 시작
dfs()