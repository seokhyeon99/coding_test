import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	
	public static void permutation(int[] ary, int[] result, int count, boolean[] v) {
		if(count == result.length) {
			for(int value: result) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<ary.length; i++) {
			if(!v[i]) {
				v[i] = true;
				result[count] = ary[i];
				permutation(ary, result, count+1, v);
				v[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] ary = new int[n];
		for(int i=0; i<n; i++) {
			ary[i] = i+1;
		}
		
		permutation(ary, new int[m], 0, new boolean[n]);
		
		System.out.println(sb);
	}

}
