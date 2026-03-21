import java.io.*;
import java.util.*;

public class Solution {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, map[][];

	static class Vertex implements Comparable<Vertex> { // for pq
		int y, x, cost;

		Vertex(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp.charAt(j) - '0';
				}
			}

//			ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
//			for (int i = 0; i < args.length; i++) {
//				
//			}

			int[][] minDist = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(minDist[i], Integer.MAX_VALUE);
			}

			int result = 0;

			PriorityQueue<Vertex> pq = new PriorityQueue<>();
			pq.offer(new Vertex(0, 0, 0));

			minDist[0][0] = 0;

			while (!pq.isEmpty()) {
				Vertex cur = pq.poll();

				if (cur.y == N - 1 && cur.x == N - 1) {
					result = cur.cost;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (!isIn(ny, nx))
						continue;
					int ncost = cur.cost + map[ny][nx];
					if (minDist[ny][nx] <= ncost)
						continue;
					minDist[ny][nx] = ncost;
					pq.offer(new Vertex(ny, nx, ncost));

				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isIn(int ny, int nx) {
		if (ny >= 0 && ny < N && nx >= 0 && nx < N)
			return true;
		return false;
	}
}