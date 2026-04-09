import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M ,K, changeNum, chairNum, count, map[][];
	static boolean chk;
	static Queue<int[]> mq, q;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		mq = new ArrayDeque<>();
		q = new ArrayDeque<>();
		chairNum = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chairNum++;
				} else if (map[i][j] == 3) {
					mq.offer(new int[] {i,j});
					visited[i][j] = true;
				} else if (map[i][j] == 4) {
					q.offer(new int[] {i,j});
				}
			}
		}
		changeNum = 0;
		mBfs();

		count = 0;
		chk = false;
		if(chairNum != changeNum) {
			int[] start = q.peek();
			visited[start[0]][start[1]] = true;
			sBfs();
		}
		System.out.println(!chk? -1 : count);
	}

	private static void sBfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				int[] cur = q.poll();
				int cy = cur[0];
				int cx = cur[1];
				if (map[cy][cx] == 2) {
					chk = true;
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if (isIn(ny,nx) && !visited[ny][nx] && map[ny][nx] != 1) {
						visited[ny][nx] = true;
						q.offer(new int[] {ny,nx});
					}
				}
			}
			count++;
		}		
	}

	private static void mBfs() {
		for (int i = 0; i < K; i++) {
			int size = mq.size();
			for (int j = 0; j < size; j++) {
				int[] cur = mq.poll();
				int cy = cur[0];
				int cx = cur[1];
				if (map[cy][cx] == 2) {
					changeNum++;
				}
				map[cy][cx] = 3;
				for (int d = 0; d < 4; d++) {
					int ny = cy + dy[d];
					int nx = cx + dx[d];
					if (isIn(ny,nx) && !visited[ny][nx]) {
						visited[ny][nx] = true;
						mq.offer(new int[] {ny,nx});
					}
				}
			}
		}
		
	}

	private static boolean isIn(int y, int x) {
		if (y>=0 && y<N && x>=0 && x<M) return true;
		return false;
	}
}