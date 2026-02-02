import java.util.*;
import java.io.*;

public class Main {
	
	static int count = 0;
	
	static void SumofSubset(int[] ary, int ary_idx, int[] sel, int sel_idx, int target) {
		if(ary_idx == ary.length) {
			int sum = 0;
			for(int s : sel) {
				sum += s;
			}
			if(sum == target && sel_idx != 0) {
				count++;
			}
			return;
		}
		
		SumofSubset(ary, ary_idx+1, sel, sel_idx, target);

		sel[sel_idx] = ary[ary_idx];
		SumofSubset(ary, ary_idx+1, sel, sel_idx+1, target);
		sel[sel_idx] = 0;
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int[] ary = new int[n];
		for(int i=0; i<n; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		
		SumofSubset(ary, 0, new int[n], 0, s);
		System.out.println(count);
	}

}
