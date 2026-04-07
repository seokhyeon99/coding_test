import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, maxHouse, map[][][], cost[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N][N + 2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j][1] = Integer.parseInt(st.nextToken());
				}
			}
			cost = new int[N + 2];
			for (int i = 1; i <= N + 1; i++) {
				if (cost[i] != 0)
					continue;
				cost[i] = i * i + (i - 1) * (i - 1);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 2; k <= N + 1; k++) {
						int localCnt = 0;
						for (int i2 = i - k + 1; i2 <= i + k - 1; i2++) {
							for (int j2 = j - k + 1; j2 <= j + k - 1; j2++) {
								if (!isIn(i2, j2))
									continue;
								if (Math.abs(i2 - i) + Math.abs(j2 - j) != k - 1)
									continue;
								if (map[i2][j2][1] == 1)
									localCnt++;
							}
						}
						map[i][j][k] = map[i][j][k - 1] + localCnt;
					}
				}
			}

			maxHouse = 0;
			getMax();
			sb.append("#").append(tc).append(" ").append(maxHouse).append("\n");
		}
		System.out.println(sb);
	}

	private static void getMax() {
		for (int k = N + 1; k > 0; k--) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cost[k] <= maxHouse)
						return;
					if (map[i][j][k] * M >= cost[k]) {
						maxHouse = Math.max(maxHouse, map[i][j][k]);
					}
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