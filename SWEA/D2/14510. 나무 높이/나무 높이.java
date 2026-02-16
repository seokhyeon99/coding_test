import java.util.*;
import java.io.*;

public class Solution {
	
	static int[] tree;
	static int two, one;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			tree = new int[N];
			two = one = 0;
			st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			for(int i=0; i<N; i++) {
				int diff = max - tree[i];
				two += diff / 2;
				one += diff % 2;
			}
			if(two > one) {
				while(true) {
					if(Math.abs(two - one) <= 1) break;
					two -= 1;
					one += 2;
				}
			}
			int days = 0;
			if(two >= one) {
				days += two * 2;
			} else {
				days += two * 2 + (one - two) * 2 - 1;
			}	
			sb.append("#").append(tc).append(" ").append(days).append("\n");
		}
		System.out.println(sb);
	}	
}