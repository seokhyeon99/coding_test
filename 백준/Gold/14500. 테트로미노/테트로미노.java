import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int N, M, max;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true; 
				dfs(i, j, 0, 0);
				visited[i][j] = false;
				cross(i, j);
			}
		}
		System.out.println(max);
	}

	private static void cross(int y, int x) {
		List<int[]> list = new ArrayList<>();
		int sum = map[y][x];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isIn(ny, nx)) {
				list.add(new int[] {ny, nx});
				sum += map[ny][nx];
			}
		}
		if(list.size() == 2) return;
		else if(list.size() == 3) max = Math.max(max, sum);
		else {
			for (int[] coor : list) {
				max = Math.max(max, sum - map[coor[0]][coor[1]]);
			}
		}
	}

	private static void dfs(int y, int x, int count, int sum) {
		if(count == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isIn(ny, nx) && !visited[ny][nx]) {
				visited[ny][nx] = true;
				dfs(ny, nx, count+1, sum+map[y][x]);
				visited[ny][nx] = false;
			}
		}
	}

	private static boolean isIn(int ny, int nx) {
		if(ny>=0 && ny<N && nx>=0 && nx<M) return true;
		return false;
	}
}