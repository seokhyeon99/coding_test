/*
* bfs
*/

import java.io.*;
import java.util.*;

class Org{
	int x, y;
	Org(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = 16;
		Deque<Org> q = new ArrayDeque<>();
		int[][] map = new int[N][N];
		
		for(int test_case = 0; test_case<10; test_case++) {
			boolean[][] visited = new boolean[N][N];
			int flag = 0;
			int T = Integer.parseInt(br.readLine());
			int cur_x = 0, cur_y = 0;
			int end_x = 0, end_y = 0;
			for(int i=0; i<N; i++) {
				String[] tmp = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					if(map[i][j] == 2) {
						cur_x = j;
						cur_y = i;
						visited[cur_y][cur_x] = true;
					}
				}
			}
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			q.offer(new Org(cur_x, cur_y));
			
			while(!q.isEmpty()) {
				int[] dx = {1, 0, -1, 0};
				int[] dy = {0, 1, 0, -1};
				int next_x, next_y;
				Org tmp = q.poll();
				cur_x = tmp.x;
				cur_y = tmp.y;
				if(map[cur_y][cur_x] == 3) {
					flag = 1;
					while(!q.isEmpty()) {
						q.poll();
					}
					break;
				}
				for(int i=0; i<4; i++) {
					next_x = cur_x + dx[i];
					next_y = cur_y + dy[i];
					if(next_x>=0 && next_x<N && next_y>=0 && next_y<N && map[next_y][next_x] != 1 && visited[next_y][next_x] == false) {
						q.offer(new Org(next_x, next_y));
						visited[next_y][next_x] = true;
					}
				}
			}
			
			
			
			sb.append("#").append(T).append(" ").append(flag).append("\n");
			
			
		}
		System.out.println(sb);
	}
}



/*
*	dfs
*/

/*
import java.util.*;
import java.io.*;

public class Solution {
	static int N = 16;
	static int[][] map = new int[N][N];
	
	static int cur_x = 0, cur_y = 0;
	static int flag = 0;
	
	static boolean[][] visited = new boolean[N][N];
	
	
	static void dfs(int cur_x, int cur_y) {
		if(map[cur_y][cur_x] == 3) {
			flag = 1;
		}
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int next_x, next_y;
		for(int i=0; i<4; i++) {
			next_x = cur_x + dx[i];
			next_y = cur_y + dy[i];
			if(next_x>=0 && next_x<N && next_y>=0 && next_y<N && map[next_y][next_x] != 1 && visited[next_y][next_x] == false) {
				visited[next_y][next_x] = true;
				dfs(next_x, next_y);
				visited[next_y][next_x] = false;
			}
		}		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 0; test_case<10; test_case++) {
			flag = 0;
			int T = Integer.parseInt(br.readLine());
			int end_x = 0, end_y = 0;
			for(int i=0; i<N; i++) {
				String[] tmp = br.readLine().split("");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(tmp[j]);
					if(map[i][j] == 2) {
						cur_x = j;
						cur_y = i;
					}
				}
			}
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			dfs(cur_x, cur_y);
			sb.append("#").append(T).append(" ").append(flag).append("\n");
			
			
		}
		System.out.println(sb);
	}
}
*/