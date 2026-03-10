import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, count, length;
	static int[][] map, bridge;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] connected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] =  -1 * Integer.parseInt(st.nextToken());
			}
		}
		
		int countryNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]== -1) {
					fillNum(i, j, countryNum++);
				}
			}
		}
		bridge = new int[countryNum][countryNum];
		for (int i = 0; i < countryNum; i++) {
			Arrays.fill(bridge[i], Integer.MAX_VALUE);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) continue;
				findBridge(i, j, map[i][j]);
			}
		}
		connected = new int[countryNum];
		for (int i = 1	; i < countryNum; i++) {
			connected[i] = i; 
		}
		count = 0;
		length = 0;
		kruskal(countryNum);
		
		if(count < countryNum-2) {
			System.out.println(-1);
		} else {
			System.out.println(length);
		}
	}

	private static void kruskal(int countryNum) {
		for (int l = 2; l < Math.max(M, N); l++) {
			for (int i = 1; i < countryNum; i++) {
				for (int j = 1; j < countryNum; j++) {
					if(bridge[i][j] == l ) {
						if(union(i, j)) {
							count++;
							length += bridge[i][j];
						}
						if(count == countryNum-2) {
							return;
						}
					}
				}
			}
		}		
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		connected[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int n) {
		if(connected[n] == n) {
			return n;
		}
		return connected[n] = findSet(connected[n]);
	}

	private static void findBridge(int cy, int cx, int curNum) {
		for (int i = 0; i < 4; i++) { // 두 방향만 탐색해도 가능
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			int count = 0;
						
			while(isIn(ny, nx)) {
				if(map[ny][nx] == curNum) {
					break;
				}
				if(map[ny][nx] != 0) {
					if(count<2) break;
					int nextNum = map[ny][nx];
					bridge[curNum][nextNum] = Math.min(bridge[curNum][nextNum], count);
					bridge[nextNum][curNum] = Math.min(bridge[nextNum][curNum], count);
					break;
				}
				ny += dy[i];
				nx += dx[i];
				count++;
			}
		}
	}

	private static void fillNum(int cy, int cx, int num) {
		map[cy][cx] = num;

		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if(isIn(ny,nx) && map[ny][nx] == -1) {
				fillNum(ny, nx, num);
			}
		}
	}

	private static boolean isIn(int ny, int nx) {
		if(ny >=0 && ny < N && nx>=0 && nx<M) return true;
		return false;
	}
}