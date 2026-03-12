import java.io.*;
import java.util.*;

public class Solution {

	static int N, W, H, map[][], min;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			dfs(0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int count) {
		if (count == N) {
			int num = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] != 0)
						num++;
				}
			}
			min = Math.min(min, num);
			return;
		}

		for (int i = 0; i < W; i++) {
			int[][] tmp = new int[H][W];
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					tmp[r][c] = map[r][c];
				}
			}
			dropStone(i); // ???
			dfs(count + 1); // ???
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = tmp[r][c];
				}
			}
		}
	}

	private static void dropStone(int x) {
		int y = 0;
		while (map[y][x] == 0) {
			y++;
			if (y == H)
				return;
		}
		int power = map[y][x];
		map[y][x] = 0;
		explode(y, x, power);
		gravity(power);
	}

	private static void gravity(int power) {
		for (int i = 0; i < W; i++) {
			int idx = H - 1;
			for (int j = H - 1; j >= 0; j--) {
				if (map[j][i] == 0)
					continue;
				map[idx--][i] = map[j][i];
			}
			for (int j = idx; j >= 0; j--) {
				map[j][i] = 0;
			}
		}

	}

	private static void explode(int y, int x, int power) {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < power; j++) {
				int ny = y + dy[i] * j;
				int nx = x + dx[i] * j;
				if (isIn(ny, nx)) {
					int curPower = map[ny][nx];
					if (curPower == 0) {
						continue;
					}
					map[ny][nx] = 0;
					if (curPower > 1) {
						explode(ny, nx, curPower);
					}
				}
			}
		}
	}

	private static boolean isIn(int ny, int nx) {
		if (ny >= 0 && ny < H && nx >= 0 && nx < W)
			return true;
		return false;
	}

}
