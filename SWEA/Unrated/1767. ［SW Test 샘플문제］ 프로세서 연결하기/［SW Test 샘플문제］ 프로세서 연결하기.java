import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, min, c_max;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<int[]> cores;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<T+1; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cores = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i!=0 && i!=N-1 && j!=0 && j!=N-1 && map[i][j] == 1) {
						cores.add(new int[] {i, j});
					}
				}
			}
			c_max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			dfs(0, 0, 0);
			
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int c_idx, int count, int c_count) {
		
		if(c_idx == cores.size()) {
			if(c_max < c_count) {
				c_max = c_count;
				min = count;
			} else if(c_max == c_count){
				min = Math.min(min, count);
			}
			return;
		}
		
		int[] core = cores.get(c_idx);
		for(int i=0; i<4; i++) {
			int j = 1;
			int ny = core[0] + j * dy[i];
			int nx = core[1] + j * dx[i];
			boolean chk = false;
			while(ny>=0 && ny<N && nx>=0 && nx<N) {
				if(map[ny][nx] != 0) {
					chk = true;
					break;
				}
				ny = core[0] + j * dy[i];
				nx = core[1] + j * dx[i];
				j++;
			}
			if(!chk) {
				for(int k=1; k<j-1; k++) {
					ny = core[0] + k * dy[i];
					nx = core[1] + k * dx[i];
					map[ny][nx] = 2;
				}
				dfs(c_idx+1, count+j-2, c_count+1);
				for(int k=1; k<j-1; k++) {
					ny = core[0] + k * dy[i];
					nx = core[1] + k * dx[i];
					map[ny][nx] = 0;
				}
			}
		}
		dfs(c_idx+1, count, c_count);
	}
}