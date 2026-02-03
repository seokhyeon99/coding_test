import java.util.*;
import java.io.*;

public class Solution {
	
	// 현재 수위(st)보다 높은 치즈 덩어리의 개수를 BFS로 세는 함수
	static int find_mass(int[][] map, int st) {
		int count = 0;
		// 상하좌우 이동을 위한 델타 배열
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		// 방문 체크 배열 (매번 새로 생성하여 원본 map을 보존함)
		boolean[][] visited = new boolean[map.length][map[0].length];
		Queue<int[]> q = new ArrayDeque<>();
		
		// 맵 전체를 돌면서 탐색 시작점 찾기
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				// 치즈가 물에 잠기지 않았고(> st), 아직 방문하지 않았다면 BFS 시작
				if(map[i][j] > st && !visited[i][j]) {
					visited[i][j] = true;
					q.offer(new int[]{j,i});
					count++; // 새로운 덩어리 발견, 개수 증가
					
					// BFS 탐색: 현재 덩어리에 연결된 모든 칸을 방문 처리
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						int cur_x = tmp[0];
						int cur_y = tmp[1];
						
						for(int k=0; k<4; k++) {
							int next_x = cur_x + dx[k];
							int next_y = cur_y + dy[k];
							
							// 1. 맵 범위 내부, 2. 물에 잠기지 않음, 3. 미방문 상태인지 확인
							if(next_x >= 0 && next_x < map.length && next_y >= 0 && next_y < map[0].length 
									&& map[next_y][next_x] > st && !visited[next_y][next_x]) {
								visited[next_y][next_x] = true;
								q.offer(new int[]{next_x, next_y});
							}
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<T+1; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] map = new int[n][n];
			int max_val = Integer.MIN_VALUE;
			
			// 맵 입력 및 치즈의 최대 높이 구하기
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max_val = Math.max(max_val, map[i][j]);
				}
			}
			
			int max = Integer.MIN_VALUE;
			// 0일(비가 안 옴)부터 치즈가 다 잠기기 직전까지 모든 경우 시뮬레이션
			for(int c=0; c<max_val; c++) {
				int result = find_mass(map, c);
				max = Math.max(max, result); // 덩어리 개수의 최댓값 갱신
			}
			
			// 정답 형식에 맞춰 StringBuilder에 저장 (#테스트케이스 정답)
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		// 결과 한 번에 출력
		System.out.println(sb);
	}
}