import java.util.*;
import java.io.*;

public class Solution {
	
	static int N, B, min;
	static int[] height;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case < T+1; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			Combination(0, 0);
			
			sb.append("#").append(test_case).append(" ").append(min - B).append("\n");
		}
		System.out.println(sb);
	}

	private static void Combination(int idx, int sum) {
		if(idx == N) {
			if(sum >= B) {
				min = Math.min(min, sum);
			}
			return;
		}
		
		//선택
		Combination(idx+1, sum+height[idx]);
        
		//미선택
		Combination(idx+1, sum);
	}
}