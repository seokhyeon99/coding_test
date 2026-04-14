import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		boolean[][] graph = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph[a][b] = true;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (graph[i][j])
						continue;
					if (graph[i][k] && graph[k][j]) {
						graph[i][j] = true;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				if (!graph[i][j] && !graph[j][i]) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}