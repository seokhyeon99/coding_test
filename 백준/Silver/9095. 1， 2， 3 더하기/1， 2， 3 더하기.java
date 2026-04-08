import java.io.*;
import java.util.*;

/*
 * 1 -> 1
 * 2 -> 2 = 1 + 1 + 0
 * 3 -> 4 = 1 + 2 + 1
 * 4 -> 7 = 1 + (3+1) + 2
 * 		13 = 1 + (4+3) + (3+2)
 * 		24
 * 7 -> 44
 * 		81
 * 		149
 * 		274
 * 
 * dp[n] = dp[n-3] + dp[n-2] + dp[n-1]
 */

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int i = 4; i < 11; i++) {
				dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; 
			}
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}

