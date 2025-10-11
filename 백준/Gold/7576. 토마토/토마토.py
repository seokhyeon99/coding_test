# 필요한 모듈을 가져옵니다.
import sys
from collections import deque # 큐(Queue) 자료구조를 사용하기 위해 deque를 가져옵니다. BFS에 필수적입니다.

# 입력을 빠르게 받기 위한 설정입니다.
input = sys.stdin.readline

# BFS를 위한 큐를 생성합니다.
queue = deque([])

# 상자의 가로(m), 세로(n) 크기를 입력받습니다.
m, n = map(int, input().split())

# 토마토 상자(box)의 상태를 저장할 2차원 리스트를 생성합니다.
box = []
for i in range(n):
    # 각 줄의 토마토 상태를 입력받아 box에 추가합니다.
    box.append(list(map(int, input().split())))

# --- BFS 초기 설정 ---
# 상자 전체를 확인하여 처음부터 익어있는 토마토(1)를 모두 큐에 넣습니다.
# 이 토마토들이 BFS의 시작점이 됩니다.
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append([i, j]) # 큐에 [세로위치, 가로위치] 형태로 좌표를 추가합니다.

# --- BFS 시작 ---
# 날짜를 계산할 변수입니다.
day = 0
# 큐가 빌 때까지 계속 반복합니다.
while(True):
    # 이번 날짜(레벨)에 처리해야 할 익은 토마토의 개수를 저장합니다.
    # 이 부분이 핵심! 이렇게 하면 '하루' 동안 일어나는 일을 정확히 구분할 수 있습니다.
    len_queue = len(queue)

    # 큐가 비었다면 더 이상 익을 토마토가 없다는 의미이므로 루프를 종료합니다.
    if len_queue == 0:
        # 마지막으로 비어있는 큐에 대해 day가 불필요하게 1 증가했으므로 1을 빼줍니다.
        day -= 1
        break

    # 현재 날짜에 익힐 토마토의 개수만큼만 반복합니다.
    for _ in range(len_queue):
        # 큐에서 익은 토마토의 좌표를 하나 꺼냅니다.
        cur_y, cur_x = queue.popleft()

        # 해당 토마토의 상, 하, 좌, 우를 탐색합니다.
        for del_x, del_y in [[1, 0], [-1, 0], [0, 1], [0, -1]]:
            # 다음에 탐색할 토마토의 좌표를 계산합니다.
            next_x = cur_x + del_x
            next_y = cur_y + del_y

            # 해당 좌표가 상자 범위 안에 있고, 아직 익지 않은 토마토(0)라면
            if 0 <= next_x < m and 0 <= next_y < n and box[next_y][next_x] == 0:
                # 토마토를 익게 만듭니다(값을 1로 변경).
                box[next_y][next_x] = 1
                # 새로 익은 토마토를 큐에 추가하여 다음 날 탐색하도록 합니다.
                queue.append([next_y, next_x])
    
    # 하루 동안의 탐색이 모두 끝났으므로 날짜를 1일 증가시킵니다.
    day += 1

# --- 결과 확인 ---
# BFS가 모두 끝난 후, 상자 안에 익지 않은 토마토(0)가 있는지 확인합니다.
for i in range(n):
    for j in range(m):
        # 만약 익지 않은 토마토가 하나라도 있다면,
        if box[i][j] == 0:
            # 결과값을 -1로 변경합니다. (모두 익지 못하는 상황)
            day = -1
            break # 더 이상 확인할 필요가 없으므로 반복을 멈춥니다.
    if day == -1:
        break

# 최종 계산된 날짜를 출력합니다.
# (모두 익었으면 day, 익지 못하는 상황이면 -1, 처음부터 모두 익었었다면 0)
print(day)
