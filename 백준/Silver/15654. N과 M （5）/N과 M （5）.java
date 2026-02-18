import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] ary;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		sel = new int[M];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ary);

		Permutation(0);

		System.out.println(sb);
	}

	private static void Permutation(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[count] = ary[i];
				Permutation(count + 1);
				visited[i] = false;
			}

		}

	}

}