import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, max, count;
	static int[][] map;
	static List<int[]> loc, loc2;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		loc = new ArrayList<>();
		loc2 = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					loc.add(new int[]{i,j});
				} else if(map[i][j] == 2) {
					loc2.add(new int[]{i,j});
				}
			}
		}
		max = Integer.MIN_VALUE;
		
		dfs(0, 0);
		
		System.out.println(max);
	}

	private static void dfs(int selected, int idx) { //벽 3개 세우는 위치 탐색
		if(selected == 3) {
			for(int i=0; i<loc2.size(); i++) {
				int cy = loc2.get(i)[0];
				int cx = loc2.get(i)[1];
				fillBlack(cx, cy);
			}
			getCount();
			max = Math.max(max, count);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 3) {
						map[i][j] = 0;
					}
				}
			}
			return;
		}
		
		if(idx == loc.size()) {
			return;
		}
		
		//선택
		int y = loc.get(idx)[0];
		int x = loc.get(idx)[1];
		map[y][x] = 1;
		dfs(selected+1, idx+1);
		map[y][x] = 0;
		//미선택
		dfs(selected, idx+1);
	}

	private static void fillBlack(int cx, int cy) {// 2와 연결된 0부분 다 3으로 채우기
		for(int j=0; j<4; j++) {
			int nx = cx + dx[j];
			int ny = cy + dy[j];
			if(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]==0) {
				map[ny][nx] = 3;
				fillBlack(nx, ny);
			}
		}
	}

	private static void getCount() {//빈 칸을 2로 채우고 남은 0 개수 세기
		count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					count++;
				}
			}
		}
	}
}