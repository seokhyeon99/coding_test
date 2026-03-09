import java.io.*;
import java.util.*;

import org.omg.CORBA.UnionMember;

public class Solution {
	
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parents[i] = i; 	
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				union(first, second);
			}
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(parents[i] == i) {
					count++;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static void union(int first, int second) {
		if(findSet(first) == findSet(second)) {
			return;
		}
		parents[findSet(second)] = findSet(first);
	}

	private static int findSet(int first) {
		if(parents[first] == first) {
			return first;
		}
		return parents[first] = findSet(parents[first]);
	}
}
