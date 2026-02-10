import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] sudoku = new int[9][9];
	static List<int[]> loc = new ArrayList<>();
	static boolean[][] available;
	static boolean finish = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j] == 0) {
					loc.add(new int[] {i,j});
				}
			}
		}
		available = new boolean[loc.size()][10];
		dfs(0);
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(sudoku[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	private static void dfs(int idx) {
		if(idx == loc.size()) {
			finish = true;
			return;
		}
		
		Arrays.fill(available[idx], false);
		
		int y = loc.get(idx)[0];
		int x = loc.get(idx)[1];
		//check vertically
		for(int i=0; i<9; i++) {
			if(!available[idx][sudoku[i][x]]) {
				available[idx][sudoku[i][x]] = true;
			}
		}
		
		//check horizontally
		for(int i=0; i<9; i++) {
			if(!available[idx][sudoku[y][i]]) {
				available[idx][sudoku[y][i]] = true;
			}
		}
		
		//check 3*3 block
		int y_section = y / 3;
		int x_section = x / 3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(!available[idx][sudoku[y_section*3+i][x_section*3+j]]) {
					available[idx][sudoku[y_section*3+i][x_section*3+j]] = true;
				}
			}
		}
		
		for(int i=1; i<=9; i++) {
			if(!available[idx][i]) {
				sudoku[y][x] = i;
				dfs(idx+1);
				if(finish) return;
				sudoku[y][x] = 0;
			}
		}
	}
}