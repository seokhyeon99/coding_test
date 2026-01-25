import java.util.*;
import java.io.*;

public class Solution {
	
	static boolean[] sel;
	static int max_sum;
	
	
	private static void GetPoints(int[] cal, int[] point, int idx, int limit, int cal_sum, int point_sum) {
		// TODO Auto-generated method stub
		
		if(cal_sum >= limit) {
			int cur_sum = point_sum - point[idx-1];
			if(cur_sum > max_sum) {
				max_sum = cur_sum;
			}
			return ;
		}
		
		if(idx == cal.length) {
			if(point_sum > max_sum) {
				max_sum = point_sum;
			}
			return ;
		}
			
			
		//미선택
		GetPoints(cal, point, idx+1, limit, cal_sum, point_sum);
			
			
		//선택
		sel[idx] = true;
		GetPoints(cal, point, idx+1, limit, cal_sum+cal[idx], point_sum+point[idx]);

			
			
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<T+1; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int[] point = new int[n];
			int[] cal = new int[n];
			max_sum = 0;
			sel = new boolean[n];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			GetPoints(cal, point, 0, l, 0, 0);
			
			System.out.println("#" + test_case + " " + max_sum);
		}
	}
}
