import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M,localCnt, map[][];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static List<int[]> list1;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list1 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]= Integer.parseInt(st.nextToken()); 
				if(map[i][j]== 1) {
					list1.add(new int[] {i,j});
				}
			}
		}
		q = new ArrayDeque<>();
		q.offer(new int[] {0,0});
		map[0][0] = 9;
		setAirBFS();
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		localCnt = 0;
		int time = 0;
		while(!list1.isEmpty()) {
			MeltingArea();
			time++;
//			System.out.println();
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
		}
		
		System.out.println(time);
		System.out.println(localCnt);
	}

	private static void MeltingArea() {
		List<int[]> list1to9 = new ArrayList<>();
		List<Integer> removeList = new ArrayList<>();
		int idx = 0;
		for (int[] ls1 : list1) {
			for (int d = 0; d < 4; d++) {
				int ny = ls1[0] + dy[d];
				int nx = ls1[1] + dx[d];
				if (isIn(ny, nx) && map[ny][nx]==9) {
					list1to9.add(new int[] {ls1[0], ls1[1]});
					removeList.add(idx);
					break;
				}
			}
			idx++;
		}
		localCnt = list1to9.size();
		for (int[] li : list1to9) {
			map[li[0]][li[1]] = 9;
		}
		for (int i = removeList.size()-1; i >=0 ; i--) {
			int rm = removeList.get(i);
			list1.remove(rm);
		}
		
		//9와 맞닿은 0 다 9로 바꾸기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (isIn(ny, nx) && map[ny][nx]==9) {
							q.offer(new int[] {i,j});
							setAirBFS();
							break;
						}
					}
				}
			}
		}
	}
	
	private static void setAirBFS() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
//			map[cur[0]][cur[1]] = 9;
			for (int i = 0; i < 4; i++) {
				int ny = cur[0] + dy[i];
				int nx = cur[1] + dx[i];
				if(isIn(ny, nx) && map[ny][nx]==0) {
					map[ny][nx]= 9; 
					q.add(new int[] {ny,nx});
				}
			}
		}
	}

	//DFS는 콜 스택 때문에 스택오버플로우 에러 남.
	private static void setAirDFS(int cy, int cx) {
		map[cy][cx] = 9;
		for (int i = 0; i < 4; i++) {
			int ny = cy + dy[i];
			int nx = cx + dx[i];
			if(isIn(ny, nx) && map[ny][nx]==0) {
				setAirDFS(ny, nx);
			}
		}
	}

	private static boolean isIn(int y, int x) {
		if(y>=0 && y<N && x>=0 && x<M) return true;
		return false;
	}
}