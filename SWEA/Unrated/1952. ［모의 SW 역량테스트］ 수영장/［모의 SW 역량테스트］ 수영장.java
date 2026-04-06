import java.io.*;
import java.util.*;

public class Solution {

	static int[] price, days, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4]; // 1day, 1month, 3months, 1year
			days = new int[13];
			dp = new int[13];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				days[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < 3; i++) {
				dp[i] = dp[i - 1] + Math.min(price[1], price[0] * days[i]);
			}

			for (int i = 3; i <= 12; i++) {
				int minMonthFee = Math.min(price[1], price[0] * days[i]);
				dp[i] = Math.min(dp[i - 3] + price[2], dp[i - 1] + minMonthFee);
			}

			sb.append("#").append(tc).append(" ").append(dp[12] > price[3] ? price[3] : dp[12]).append("\n");
		}
		System.out.println(sb);
	}
}

// f(n) = min(f(n-3)+price[2], f(n-1)+price[1], f(n-1)+price[0]*day[n])