import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, M, K;
	static List<micro> list;
	static int[] dx = {0, 0, 0, -1, 1}; //상 하 좌 우
	static int[] dy = {0, -1, 1, 0, 0};
	
	static class micro{
		int y, x, dir;
		long num;
		public micro(int y, int x, long num, int dir) {
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				list.add(new micro(y, x, num, dir));
			}
			
			for (int i = 0; i < M; i++) {
				move();
				checkCrash();
			}
			
			long result = 0;
			for (int i = 0; i < K; i++) {
				micro temp = list.get(i);
				if(temp.num != 0) {
					result += temp.num;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}


	private static void checkCrash() {
		List<Integer>[][] map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int k = 0; k < K; k++) {
			micro mi = list.get(k);
			if(mi.num == 0) continue;
			// 가장자리 확인
			if (mi.x == 0 || mi.x == N-1 || mi.y == 0 || mi.y == N-1) {
				mi.num /= 2;
				switch (mi.dir) {
				case 1:
					mi.dir = 2;
					break;
				case 2:
					mi.dir = 1;
					break;
				case 3:
					mi.dir = 4;
					break;
				case 4:
					mi.dir = 3;
					break;

				}
			}
			// 위치  map에 표시
			else {
				map[mi.y][mi.x].add(k);
			}
		}
			// 같은 위치에 여러 군집 있으면 최대 미생물 개수있는거로 합치고 나머지 list에서 제거
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {
				if(map[i][j].size() > 1) {
					long maxNum = 0;
					int maxIdx = 0;
					long totalNum = 0;
					for (Integer idx : map[i][j]) {
						micro tmp = list.get(idx);
						totalNum += tmp.num;
						if(maxNum < tmp.num) {
							maxNum = tmp.num;
							maxIdx = idx;
						}
					}
					for (Integer idx : map[i][j]) {
						micro tmp = list.get(idx);
						if(idx == maxIdx) {
							tmp.num = totalNum;
						} else {
							tmp.num = 0;
						}
					}
				}
			}
		}
		
		
	}


	private static void move() {
		for (int i = 0; i < K; i++) {
			micro mi = list.get(i);
			if(mi.num == 0) continue;
			int d = mi.dir;
			mi.y += dy[d];
			mi.x += dx[d];
		}
	}
}