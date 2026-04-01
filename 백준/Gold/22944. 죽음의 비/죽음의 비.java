import java.io.*;
import java.util.*;

public class Main {

	static int N, H, D, minCount, moveCount;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		visited = new int[N][N];
		minCount = Integer.MAX_VALUE;

		int sx = 0;
		int sy = 0;

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == 'S') {
					sy = i;
					sx = j;
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			Arrays.fill(visited[i], -1);
//		}
		
		q = new ArrayDeque<>();
		
		visited[sy][sx] = H+1;
		q.offer(new int[] {sy, sx, H+1, 0});
		moveCount = 0;
		bfs();
		
//		dfs(sy, sx, H + 1, 0, 0, 0);

		System.out.println(minCount == Integer.MAX_VALUE ? -1 : minCount);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int nums = q.size();
			for (int i = 0; i < nums; i++) {
				int[] cur = q.poll();
				int cy = cur[0];
				int cx = cur[1];
				int hp = cur[2];
				int umb = cur[3];
				
				if (map[cy][cx] == 'E') {
					minCount = Math.min(minCount, moveCount);
					return;
				}

				if (map[cy][cx] == 'U') {
					umb = D;
				}
					
				if (hp == 0)
					continue;

				if (umb > 0)
					umb--;
				else
					hp--;

				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (isIn(ny, nx) && visited[ny][nx] < hp+umb) {
						visited[ny][nx] = hp + umb;
						q.offer(new int[] {ny, nx, hp, umb});
					}
				}
			}
			moveCount++;
			
		}
	}

	private static void dfs(int cy, int cx, int hp, int umb, int moveCount, int umbCount) {
//		System.out.println(cy+ " " + cx + " " + hp + " " + umb + " " + map[cy][cx]);
		if (map[cy][cx] == 'E') {
			minCount = Math.min(minCount, moveCount);
		}

		if (moveCount >= minCount)
			return;

		if (hp == 0)
			return;

//		if (map[cy][cx] == 'U') {
//			umb = D;
//			umbCount++;
//			map[cy][cx] = 'X';
//		}

		if (umb > 0)
			umb--;
		else
			hp--;

		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if (isIn(ny, nx) && visited[ny][nx] < hp+umb) {
				if(visited[ny][nx] < umbCount)
//				int temp = visited[ny][nx];
				visited[ny][nx] = umbCount;
				dfs(ny, nx, hp, umb, moveCount + 1, umbCount);
//				visited[ny][nx] = temp;
				if (map[cy][cx] == 'X') {
					map[cy][cx] = 'U';
					umbCount--;
				}
			}

		}

	}

	private static boolean isIn(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < N)
			return true;
		return false;
	}
}
