import sys
input = sys.stdin.readline
from collections import deque

# 1. 입력 및 그래프 초기화
n = int(input())
graph = [[] for _ in range(n+1)]

# 2. 인접 리스트로 연결 관계 저장 (양방향)
for i in range(n-1):
    a, b = map(int, input().split())  
    graph[a].append(b)
    graph[b].append(a)

# 3. 부모 노드 저장용 리스트 및 방문 처리 리스트
tree = [0] * (n+1)
visited = [0]*(n+1)

# 4. BFS 시작 (루트인 1번 노드부터 탐색)
queue = deque([1])
visited[1] = 1 # 루트 방문 처리

while queue:
    val = queue.popleft() # 현재 탐색 중인 부모 노드
    for child in graph[val]: # 연결된 노드들 확인
        if visited[child] == 0: # 아직 방문하지 않은 노드라면 (자식 노드임)
            visited[child] = 1  # 방문 체크
            tree[child] = val   # 자식 노드 위치에 부모 번호 기록
            queue.append(child) # 다음 탐색을 위해 큐에 추가

# 5. 2번 노드부터 부모 노드 번호 출력
for i in range(2, n+1):
    print(tree[i])