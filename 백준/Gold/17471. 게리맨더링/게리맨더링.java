import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] graph;
	static int N;
	static int[] population;
	static boolean[] sel;
	static int min;
	static Queue<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		population = new int[N + 1];
		sel = new boolean[N + 1];
		min = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int adj_N = Integer.parseInt(st.nextToken());
			for (int j = 0; j < adj_N; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		Subset(1, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	private static void Subset(int idx, int count) {
		if (idx == N + 1) {
			// 연결되었는지 확인 후
			if (count > 0 && count < N && isConnected(count)) {
				// 차가 최소인지 비교
				minDifference(count);
			}
			return;
		}
		if (count == N / 2 + 1) {
			return;
		}
		// selected
		sel[idx] = true;
		Subset(idx + 1, count + 1);
		sel[idx] = false;
		// unselected
		Subset(idx + 1, count);
	}

	private static void minDifference(int count) {
		int[] sub1 = new int[count];
		int[] sub2 = new int[N - count];
		int j = 0;
		int k = 0;
		for (int i = 1; i <= N; i++) {
			if (sel[i]) {
				sub1[j++] = i;
			} else {
				sub2[k++] = i;
			}
		}
		int val1 = 0;
		for (int s : sub1) {
			val1 += population[s];
		}
		int val2 = 0;
		for (int s : sub2) {
			val2 += population[s];
		}
		min = Math.min(min, Math.abs(val1 - val2));

	}

	private static boolean isConnected(int count) {
		int[] sub1 = new int[count];
		int[] sub2 = new int[N - count];
		int j = 0;
		int k = 0;
		for (int i = 1; i <= N; i++) {
			if (sel[i]) {
				sub1[j++] = i;
			} else {
				sub2[k++] = i;
			}
		}

		boolean[] v1 = new boolean[count];
		boolean[] v2 = new boolean[N - count];

		q = new ArrayDeque<>();
		boolean chk1 = bfs(sub1, v1);
		q = new ArrayDeque<>();
		boolean chk2 = bfs(sub2, v2);

		return chk1 && chk2;

	}

	private static boolean bfs(int[] sub, boolean[] v) {
		q.offer(sub[0]);
		v[0] = true;
		while (!q.isEmpty()) {
			int num = q.size();
			for (int i = 0; i < num; i++) {
				int cur = q.poll();
				for (int c : graph[cur]) { // cur와 연결된 노드 c
					for (int j = 0; j < sub.length; j++) {
						if (!v[j] && c == sub[j]) { // cur와 연결되어있으면
							q.offer(c);
							v[j] = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < v.length; i++) {
			if (!v[i]) {
				return false;
			}
		}
		return true;
	}
}
