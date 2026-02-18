import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] sel;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sel = new int[M];
		
		Comb(1, 0);
		
		System.out.println(sb);
	}

	private static void Comb(int idx, int count) {
		if(count == M) {
			for(int i=0; i<M; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if(idx == N+1) {
			return;
		}
		//선택
		sel[count] = idx;
		Comb(idx+1, count+1);
		//미선택 
		Comb(idx+1, count);
	}
}