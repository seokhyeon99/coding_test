import java.io.*;
import java.util.*;

public class Solution {
	
	static int n;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			for (int i = 0; i < n+1; i++) {
				parents[i]= i; 
				
			}
			int m = Integer.parseInt(st.nextToken());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int inst = Integer.parseInt(st.nextToken());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				
				if(inst == 0) {
					union(first, second);
				} else if(inst == 1) {
					sb.append(isInSameUnion(first, second));
				}
				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int isInSameUnion(int first, int second) {
		if(findSet(first) == findSet(second)) return 1;
		else return 0;
	}

	private static int findSet(int num) {
		if(parents[num] == num) {
			return num;
		}
		return parents[num] = findSet(parents[num]);
	}

	private static void union(int first, int second) {
		if(findSet(parents[first]) == findSet(parents[second])) {
			return;
		}
		parents[findSet(parents[second])] = findSet(parents[first]);
	}
}