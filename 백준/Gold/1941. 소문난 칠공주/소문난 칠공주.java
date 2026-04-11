import java.util.*;
import java.io.*;

public class Main {

	static char[][] map = new char[5][5];

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int totalCnt = 0;
	static boolean[][] visited = new boolean[5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		comb(0, 0, new int[7]);

		System.out.println(totalCnt);
	}

	private static void comb(int start, int idx, int[] sel) {
		if (idx == 7) {
			if (sIsMore(sel) && isConnected(sel)) {
				totalCnt++;
			}
			return;
		}

		if (25 - start < 7 - idx) {
			return;
		}

		// unselected
		comb(start + 1, idx, sel);
		// selected
		sel[idx] = start;
		comb(start + 1, idx + 1, sel);

	}

	private static boolean sIsMore(int[] sel) {
		int[] y = new int[7];
		int[] x = new int[7];
		for (int i = 0; i < 7; i++) {
			y[i] = sel[i] / 5;
			x[i] = sel[i] % 5;
		}
		int sCnt = 0;
		for (int i = 0; i < 7; i++) {
			if (map[y[i]][x[i]] == 'S')
				sCnt++;
		}
		if (sCnt >= 4)
			return true;
		return false;
	}

	private static boolean isConnected(int[] sel) {
		Queue<int[]> q = new ArrayDeque<>();
		int[] y = new int[7];
		int[] x = new int[7];
		boolean[] v = new boolean[7];
		for (int i = 0; i < 7; i++) {
			y[i] = sel[i] / 5;
			x[i] = sel[i] % 5;
		}
		v[0] = true;
		q.offer(new int[] { y[0], x[0] });
		int localCnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if (!isIn(ny, nx))
					continue;
				for (int j = 1; j < 7; j++) {
					if (!v[j] && ny == y[j] && nx == x[j]) {
						v[j] = true;
						q.offer(new int[] { ny, nx });
						localCnt++;
					}
				}
			}
		}
		if (localCnt == 7)
			return true;
		return false;
	}

	public static boolean isIn(int y, int x) {
		if (y >= 0 && y < 5 && x >= 0 && x < 5)
			return true;
		return false;
	}
}