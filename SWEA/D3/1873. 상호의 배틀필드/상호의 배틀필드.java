import java.util.*;
import java.io.*;

public class Solution {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for(int test_case=1; test_case<T+1; test_case++) {
				st = new StringTokenizer(br.readLine());
				int h = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				char[][] map = new char[h][w];
				int cur_x = 0, cur_y = 0, next_x = 0, next_y = 0;
				char cur_status = ' ';
				for(int i=0; i<h; i++) {
					String tmp = br.readLine();
					for(int j=0; j<w; j++) {
						map[i][j] = tmp.charAt(j);
						if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
							cur_x = j;
							cur_y = i;
							cur_status = map[i][j];
						}
					}
				}
				
				int n = Integer.parseInt(br.readLine());
				char[] keys = new char[n];
				String input = br.readLine();
				for(int i=0; i<n; i++) {
					keys[i] = input.charAt(i);
				}
				
//				for(int i=0; i<h; i++) {
//						System.out.println(Arrays.toString(map[i]));
//				}
//				System.out.println(Arrays.toString(key));
				
				for(int k=0; k<n; k++) {
					switch(keys[k]) {
					case 'U':
						next_x = cur_x;
						next_y = cur_y - 1;
						cur_status = '^';
						if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h && map[next_y][next_x] == '.') {
							map[cur_y][cur_x] = '.';
							cur_x = next_x;
							cur_y = next_y;
						}
						map[cur_y][cur_x] = cur_status;

						break;
					case 'D':
						next_x = cur_x;
						next_y = cur_y + 1;
						cur_status = 'v';
						if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h && map[next_y][next_x] == '.') {
							map[cur_y][cur_x] = '.';
							cur_x = next_x;
							cur_y = next_y;
						}
						map[cur_y][cur_x] = cur_status;

						break;
					case 'L':
						next_x = cur_x - 1;
						next_y = cur_y;
						cur_status = '<';
						if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h && map[next_y][next_x] == '.') {
							map[cur_y][cur_x] = '.';
							cur_x = next_x;
							cur_y = next_y;
						}
						map[cur_y][cur_x] = cur_status;

						break;
					case 'R':
						next_x = cur_x + 1;
						next_y = cur_y ;
						cur_status = '>';
						if(next_x >= 0 && next_x < w && next_y >= 0 && next_y < h && map[next_y][next_x] == '.') {
							map[cur_y][cur_x] = '.';
							cur_x = next_x;
							cur_y = next_y;
						}
						map[cur_y][cur_x] = cur_status;

						break;
					case 'S':
//						int dir_x, dir_y;
						boolean meet_steel_wall = false;
						switch(cur_status) {
						case '^':
//							dir_x = 0;
//							dir_y = -1;
							
							for(int loc_b = 1; -loc_b+cur_y>=0; loc_b++) {
								if(meet_steel_wall) break;
								switch(map[cur_y-loc_b][cur_x]) {
								case '*':
									map[cur_y-loc_b][cur_x] = '.';
									meet_steel_wall = true;
									break;
								case '#':
									meet_steel_wall = true;
									break;
								}
							}
							break;
							
						case 'v':
//							dir_x = 0;
//							dir_y = 1;
							
							for(int loc_b = 1; loc_b+cur_y<h; loc_b++) {
								if(meet_steel_wall) break;
								switch(map[cur_y+loc_b][cur_x]) {
								case '*':
									map[cur_y+loc_b][cur_x] = '.';
									meet_steel_wall = true;
									break;
								case '#':
									meet_steel_wall = true;
									break;
								}
							}
							break;
							
						case '<':
//							dir_x = -1;
//							dir_y = 0;
							for(int loc_b = 1; -loc_b+cur_x>=0; loc_b++) {
								if(meet_steel_wall) break;
								switch(map[cur_y][cur_x-loc_b]) {
								case '*':
									map[cur_y][cur_x-loc_b] = '.';
									meet_steel_wall = true;
									break;
								case '#':
									meet_steel_wall = true;
									break;
								}
							}
							break;
							
						case '>':
//							dir_x = 1;
//							dir_y = 0;
							for(int loc_b = 1; loc_b+cur_x<w; loc_b++) {
								if(meet_steel_wall) break;
								switch(map[cur_y][loc_b+cur_x]) {
								case '*':
									map[cur_y][loc_b+cur_x] = '.';
									meet_steel_wall = true;
									break;
								case '#':
									meet_steel_wall = true;
									break;
								}
							}
							break;
						}
					}
						
				}

				sb.append("#").append(test_case).append(" ");
				for(int r=0; r<h; r++) {
					for(int c=0; c<w; c++) {
						sb.append(map[r][c]);
					}
					sb.append("\n");
				}

			}
			
			System.out.println(sb);

		}

	}
