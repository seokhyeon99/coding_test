import java.io.*;
import java.util.*;

public class Main {

	static int N, M, count, map[][];
	static boolean chk, visited[][][];
	static Queue<int[]> q;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}
		q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 });
		visited[0][0][0] = true;
		count = 1;

		bfs();

		System.out.println(chk ? count : -1);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] cur = q.poll();
				int cy = cur[0];
				int cx = cur[1];
				int breakWall = cur[2];
//				System.out.println("y: " + cy + " x: " + cx + " break: " + breakWall + " count: " + count);
				if (cy == N - 1 && cx == M - 1) {
					chk = true;
					return;
				}
				for (int j = 0; j < 4; j++) {
					int ny = cy + dy[j];
					int nx = cx + dx[j];
					if (isIn(ny, nx)) {
						if (map[ny][nx] == 0 && !visited[ny][nx][breakWall]) {
							q.offer(new int[] { ny, nx, breakWall });
							visited[ny][nx][breakWall] = true;
						} else if (map[ny][nx] == 1 && breakWall == 0 && !visited[ny][nx][1]) {
							q.offer(new int[] { ny, nx, breakWall + 1 });
							visited[ny][nx][1] = true;
						}
					}
				}
			}
			count++;
		}
	}

	private static boolean isIn(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < M)
			return true;
		return false;
	}
}