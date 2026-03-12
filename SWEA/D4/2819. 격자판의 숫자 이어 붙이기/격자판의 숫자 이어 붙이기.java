import java.io.*;
import java.util.*;

public class Solution {

	static int[][] map;
	static Set<Integer> set;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			set = new HashSet<>();
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0, 0);
				}
			}
			sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cy, int cx, int count, int num) {
		if (count == 7) {
			set.add(num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if (isIn(ny, nx)) {
				dfs(ny, nx, count + 1, 10 * num + map[cy][cx]);
			}
		}
	}

	private static boolean isIn(int y, int x) {
		if (x >= 0 && x < 4 && y >= 0 && y < 4)
			return true;
		return false;
	}
}