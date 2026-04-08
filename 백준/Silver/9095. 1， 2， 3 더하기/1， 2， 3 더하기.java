import java.io.*;
import java.util.*;

/*
 * n = (n-1) + 1 or (n-2) + 2 or (n-3) + 3
 * 
 * dp[n] = dp[n-3] + dp[n-2] + dp[n-1]
 */

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1]; 
		}
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}

