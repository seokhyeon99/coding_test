import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] ary, sel;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ary = new int[N];
		sel = new int[M];
		
		for(int i=1; i<=N; i++) {
			ary[i-1] = i;
		}
		
		DupPerm(0);
		
		System.out.println(sb);
		
	}

	private static void DupPerm(int count) {
		if(count == M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			sel[count] = ary[i];
			DupPerm(count+1);
		}
	}
}