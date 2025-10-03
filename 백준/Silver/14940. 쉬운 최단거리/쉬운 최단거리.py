import sys
from collections import deque

input = sys.stdin.readline

# n: 지도의 세로 크기(행), m: 지도의 가로 크기(열)
n, m = map(int, input().split())

# location: 문제의 원본 지도(벽, 길, 목표지점 정보)를 저장할 리스트
location = []
for _ in range(n):
    location.append(list(map(int, input().split())))
# checked: 방문 여부를 기록하는 지도 (0: 미방문, 1: 방문)
checked = [[0] * m for _ in range(n)]
# dist_map: 시작점으로부터의 최단 거리를 기록하는 지도
dist_map = [[0] * m for _ in range(n)]
# target_x, target_y: 시작점(값이 2인 곳)의 좌표를 저장할 변수
target_x = 0
target_y = 0
# 지도 전체를 탐색하여 시작점(2)의 위치를 찾음
for i in range(n):
    for j in range(m):
        if location[i][j] == 2:
            target_x = j
            target_y = i
            break 

# --- BFS 탐색 시작 ---
# 1. 큐(대기열)를 만들고, 시작점 좌표를 첫 번째 "탐색할 대상"으로 추가
queue = deque([[target_x, target_y]])
# 2. 시작점의 거리는 0으로 설정
dist_map[target_y][target_x] = 0
# 3. 시작점은 탐색을 시작한 곳이므로, 방문했다고 표시
checked[target_y][target_x] = 1

# queue가 빌 때까지 계속 반복
while queue:
    # queue의 맨 앞에서 가장 먼저 들어왔던 좌표(가장 가까운 좌표)를 꺼냄
    cur = queue.popleft()
    # 꺼낸 좌표(cur)의 상, 하, 좌, 우 네 방향의 이웃 칸들을 확인
    for idx in [[cur[0] + 1, cur[1] + 0], [cur[0] - 1, cur[1] + 0], [cur[0] + 0, cur[1] + 1], [cur[0] + 0, cur[1] - 1]]:
        # [조건 확인] 이웃 칸이 탐색 가능한 곳인지 확인
        if (idx[0] >= 0 and idx[0] < m and idx[1] >= 0 and idx[1] < n # 1. 지도 범위 안인가? (idx[0]은 열(x), idx[1]은 행(y))
                and checked[idx[1]][idx[0]] == 0 # 2. 아직 방문한 적 없는 곳인가?
                and location[idx[1]][idx[0]] != 0): # 3. 벽(0)이 아닌 곳인가?
            # 1. "방문했다"고 지도에 표시
            checked[idx[1]][idx[0]] = 1
            # 2. 거리를 계산하여 기록 (이전 칸의 거리 + 1)
            dist_map[idx[1]][idx[0]] = dist_map[cur[1]][cur[0]] + 1
            # 3. 다음 탐색을 위해 queue의 맨 뒤에 이 칸의 좌표를 추가 ("다음 할 일 목록"에 추가)
            queue.append([idx[0], idx[1]])

# --- 최종 결과 처리 및 출력 ---
for i in range(n):
    for j in range(m):
        # 지도 내에 방문할 수 있는 곳이지만 접근이 불가한 경우 거리를 -1로 표시
        if checked[i][j] == 0 and location[i][j] == 1:
            dist_map[i][j] = -1
        print(dist_map[i][j], end=' ')
    print()
