import java.util.*;
import java.io.*;

public class Solution {

	static int N, M, count;
	static char[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<int[]> dq, hq;
	static boolean meet;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dq = new ArrayDeque<>();
			hq = new ArrayDeque<>();
			meet = false;
			map = new char[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == 'S') {
						hq.offer(new int[] { i, j });
					} else if (map[i][j] == '*') {
						dq.offer(new int[] { i, j });
					}
				}
			}

			timer();
			sb.append("#").append(tc).append(" ").append(meet ? count : "GAME OVER").append("\n");
		}
		System.out.println(sb);
	}

	private static void timer() {
		count = 0;
		// S가 D만날때까지 or S가 갈곳이 없을때까지 반복
		while (!meet && !hq.isEmpty()) {
			count++;
			devilBfs();
			humanBfs();
			if (meet)
				return;
		}
	}

	private static void humanBfs() {
		int qSize = hq.size();
		for (int i = 0; i < qSize; i++) {
			int[] cur = hq.poll();
			int cy = cur[0];
			int cx = cur[1];
			for (int j = 0; j < 4; j++) {
				int nx = cx + dx[j];
				int ny = cy + dy[j];
				if (isIn(ny, nx) && map[ny][nx] != 'X' && map[ny][nx] != '*' && !visited[ny][nx]) {
					if (map[ny][nx] == 'D') {
						meet = true;
						return;
					}
					visited[ny][nx] = true;
					hq.offer(new int[] { ny, nx });
				}
			}
		}
	}

	private static void devilBfs() {
		int qSize = dq.size();
		for (int i = 0; i < qSize; i++) {
			int[] cur = dq.poll();
			int cy = cur[0];
			int cx = cur[1];
			for (int j = 0; j < 4; j++) {
				int nx = cx + dx[j];
				int ny = cy + dy[j];
				if (isIn(ny, nx) && map[ny][nx] != 'X' && map[ny][nx] != 'D' && map[ny][nx] != '*') {
					map[ny][nx] = '*';
					dq.offer(new int[] { ny, nx });
				}
			}
		}
	}

	private static boolean isIn(int y, int x) {
		if (y >= 0 && y < N && x >= 0 && x < M)
			return true;
		return false;
	}
}