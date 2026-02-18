import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[] ary;
	static int[] sel;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		sel = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(ary);

		DupPermutation(0);

		System.out.println(sb);
	}

	private static void DupPermutation(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			sel[count] = ary[i];
			DupPermutation(count + 1);
		}
	}
}