import java.util.*;
import java.io.*;

public class Solution {
	//구조물 타입에 따른 이동 가능 방향 배열 
	public static boolean[][] structure = new boolean[][]{{false, false, false, false},
														  {true, true, true, true},
														  {true, false, true, false},
														  {false, true, false, true},
														  {true, true, false, false},
														  {false, true, true, false},
														  {false, false, true, true},
														  {true, false, false, true}};
	public static int[] dir_x = {0, 1, 0, -1};
	public static int[] dir_y = {-1, 0, 1, 0};
	public static int[][] map;
	public static boolean[][] visited;
	//N: 세로, M: 가로, L: 제한시간, count: 갈 수 있는 위치 개수, time: 현재까지의 시간
	public static int N, M, L, count, time;
	public static Queue<int[]> q;					
														  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<T+1; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			q = new ArrayDeque<>();	
			visited = new boolean[N][M];
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//초기값 큐에 담기
			q.offer(new int[] {R,C});
			visited[R][C] = true;
			count = 1;
			time = 1;
			bfs();
			sb.append("#").append(test_case).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			// 제한시간 도달 시 종료 
			if(time == L) return;
			// (현재+1)시간 내에 갈 수 있는 곳 -> 현재 큐에 들어있는 위치를 다 꺼내서 탐색
			int len = q.size();
			int[] loc;
			for(int i=0; i<len; i++) {
				loc = q.poll();
				int cur_y = loc[0];
				int cur_x = loc[1];
				int cur_type = map[cur_y][cur_x]; // 현재 위치의 구조물 타입 확인
				for(int t=0; t<4; t++) {
					if(structure[cur_type][t]) { // 구조물 타입에 따른 진행 가능 방향 확인
						int next_y = cur_y + dir_y[t];
						int next_x = cur_x + dir_x[t];
						if(next_x<0 || next_x>=M || next_y<0 || next_y>=N) continue;
						int next_type = map[next_y][next_x];
						// 이전에 방문하지 않았고 다음 위치에서의 구조물 타입의 이동 가능 방향을 확인하여 연결되어 있는지 확인
						if(!visited[next_y][next_x] && structure[next_type][(t+2)%4]) { 
							q.offer(new int[]{next_y, next_x});
							visited[next_y][next_x] = true;
							count++;
						}
					}
				}
			}
			time++;
		}
	}
}