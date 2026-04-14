import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean[][] height = new boolean[N][N];
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				height[a][b] = true;
			}

			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (i == j)
							continue;
						if (height[i][j])
							continue;
						if (height[i][k] && height[k][j]) {
							height[i][j] = true;
						}
					}
				}
			}

			int totalCnt = 0;
			for (int i = 0; i < N; i++) {
				int count = 0;
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (height[i][j] || height[j][i]) {
						count++;
					}
				}
				if (count == N - 1) {
					totalCnt++;
				}
			}
			sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
		}
		System.out.println(sb);
	}
}