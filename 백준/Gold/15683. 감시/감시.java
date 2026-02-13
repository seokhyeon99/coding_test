import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M, min;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<int[]> cctv = new ArrayList<>();
	static Stack<int[]> s = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		map = new int[N][M];
		boolean[][] chk = new boolean[N][M];

		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken()); 
				if(map[i][j] >= 1 && map[i][j]<=5) {
					cctv.add(new int[] {i, j});
					chk[i][j]= true; 
				} else if(map[i][j] == 6) {
					chk[i][j]= true; 
				}
			}
		}
		
		monitor(chk, 0);
		
		System.out.println(min);
		
	}

	private static void monitor(boolean[][] chk, int idx) {
		if(idx == cctv.size()) {
			int Monitored = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(chk[i][j]) {
						Monitored ++;
					}
				}
			}
			min = Math.min(min, N * M - Monitored);
			return;
		}
		
		int[] cur = cctv.get(idx);
		int cy = cur[0];
		int cx = cur[1];
		int[] dir_4 = {0, 1, 2, 3};
		int[] dir_2 = {0, 1};
		switch (map[cy][cx]) {
			case 1:
				for(int dir_idx : dir_4) { // 4개 방향 중 하나 채워넣기
					int ny = cy + dy[dir_idx];
					int nx = cx + dx[dir_idx];
					int count = 0;
					while(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]!=6) {
						if(!chk[ny][nx]) {
							chk[ny][nx] = true;
							s.push(new int[] {ny, nx});
							count++;
						}
						ny += dy[dir_idx];
						nx += dx[dir_idx];
					}
					//재귀 호출
					monitor(chk, idx+1);
					//false로 다시 변환
					for(int i=0; i<count; i++) {
						int[] tmp = s.pop();
						chk[tmp[0]][tmp[1]] = false;
					}
				}
				break;
			case 2:
				for(int dir_idx : dir_2) {
					int count = 0;
					for(int k : new int[] {0, 2}){
						int ny = cy + dy[dir_idx+k];
						int nx = cx + dx[dir_idx+k];
						while(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]!=6) {
							if(!chk[ny][nx]) {
								chk[ny][nx] = true;
								s.push(new int[] {ny, nx});
								count++;
							}
							ny += dy[dir_idx+k];
							nx += dx[dir_idx+k];
						}
					}
					//재귀 호출
					monitor(chk, idx+1);
					//false로 다시 변환
					for(int i=0; i<count; i++) {
						int[] tmp = s.pop();
						chk[tmp[0]][tmp[1]] = false;
					}
				}
				break;
			case 3:
				for(int dir_idx : dir_4) {
					int count = 0;
					for(int k : new int[] {0, 1}){
						int ny = cy + dy[(dir_idx+k)%4];
						int nx = cx + dx[(dir_idx+k)%4];
						while(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]!=6) {
							if(!chk[ny][nx]) {
								chk[ny][nx] = true;
								s.push(new int[] {ny, nx});
								count++;
							}
							ny += dy[(dir_idx+k)%4];
							nx += dx[(dir_idx+k)%4];
						}
					}
					//재귀 호출
					monitor(chk, idx+1);
					//false로 다시 변환
					for(int i=0; i<count; i++) {
						int[] tmp = s.pop();
						chk[tmp[0]][tmp[1]] = false;
					}
				}
				break;
			case 4:
				for(int dir_idx : dir_4) {
					int count = 0;
					for(int k : new int[] {0, 1, 3}){
						int ny = cy + dy[(dir_idx+k)%4];
						int nx = cx + dx[(dir_idx+k)%4];
						while(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]!=6) {
							if(!chk[ny][nx]) {
								chk[ny][nx] = true;
								s.push(new int[] {ny, nx});
								count++;
							}
							ny += dy[(dir_idx+k)%4];
							nx += dx[(dir_idx+k)%4];
						}
					}
					//재귀 호출
					monitor(chk, idx+1);
					//false로 다시 변환
					for(int i=0; i<count; i++) {
						int[] tmp = s.pop();
						chk[tmp[0]][tmp[1]] = false;
					}
				}
				break;
			case 5:
				int count = 0;
				for(int k : new int[] {0, 1, 2, 3}){
					int ny = cy + dy[k];
					int nx = cx + dx[k];
					while(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]!=6) {
						if(!chk[ny][nx]) {
							chk[ny][nx] = true;
							s.push(new int[] {ny, nx});
							count++;
						}
						ny += dy[k];
						nx += dx[k];
					}
				}
				//재귀 호출
				monitor(chk, idx+1);
				//false로 다시 변환
				for(int i=0; i<count; i++) {
					int[] tmp = s.pop();
					chk[tmp[0]][tmp[1]] = false;
				}
				break;
		}
		
	}
}
