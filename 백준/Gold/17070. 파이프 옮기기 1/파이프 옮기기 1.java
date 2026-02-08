import java.util.*;
import java.io.*;

public class Main {
	
	static int count, n, map[][];
	static int[] dx = {1, 1, 0};
	static int[] dy = {0, 1, 1};
	
	
	private static void dfs(int cur_x, int cur_y, int dir_idx) {
		if(cur_x == n && cur_y == n) {
			count++;
			return;
		}
		
		boolean hor = false;
		boolean ver = false;
		boolean dia = false;
		
		if( (cur_x+1) <= n && map[cur_y][cur_x+1] == 0) {
			hor = true;
		}
		if( (cur_y+1) <= n && map[cur_y+1][cur_x] == 0) {
			ver = true;
		}
		if( hor && ver && map[cur_y+1][cur_x+1] == 0) {
			dia = true;
		}

		
		switch (dir_idx) {
		case 0: //(1,0)
			//move horizontally
			if(hor) {
				dfs(cur_x+1, cur_y, dir_idx);
			}
			
			// move diagonally
			if(dia) {
				dfs(cur_x+1, cur_y+1, 1);
			}
			
			break;
			
		case 1: //(1,1)
			//move horizontally
			if(hor) {
				dfs(cur_x+1, cur_y, 0);
			}
			//move vertically
			if(ver) {
				dfs(cur_x, cur_y+1, 2);
			}
			//move diagonally
			if(dia) {
				dfs(cur_x+1, cur_y+1, dir_idx);
			}
			break;
			
		case 2: //(0,1)
			//move vertically
			if(ver) {
				dfs(cur_x, cur_y+1, dir_idx);
			}
			//move diagonally
			if(dia) {
				dfs(cur_x+1, cur_y+1, 1);
			}
			break;
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i+1][j+1] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;

		dfs(2, 1, 0);
		System.out.println(count);
	}

}
