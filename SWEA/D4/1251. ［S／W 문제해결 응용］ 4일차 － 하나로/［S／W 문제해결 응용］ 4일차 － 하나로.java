import java.io.*;
import java.util.*;

public class Solution {
	
	static int N;
	static int[] x, y;
	static double taxRate;
	static List<Edge> list;
	static int[] parents;
	static int[] rank;
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;
		Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			x = new int[N];
			y = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken()); 				
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken()); 				
			}
			taxRate = Double.parseDouble(br.readLine());
			
			list = new ArrayList<>();
			parents = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {
				parents[i] = i; 
			}
			
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					double w = Math.pow((x[i]- x[j]), 2) + Math.pow((y[i]- y[j]), 2);
					list.add(new Edge(i, j, w));
				}
			}
			
			Collections.sort(list);
			
			int count = 0;
			double cost = 0.0;
			for (Edge e : list) {
				if(union(e.from, e.to)) {
					count++;
					cost += e.weight;
				}
				if(count == N-1) break;
			}
			sb.append("#").append(tc).append(" ").append(Math.round(cost*taxRate)).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		if(rank[aRoot] >= rank[bRoot]) {
			parents[bRoot] = aRoot;
			rank[aRoot] += rank[bRoot];
			rank[bRoot] = 0;
		} else {
			parents[aRoot] = bRoot;
			rank[bRoot] += rank[aRoot];
			rank[aRoot] = 0;
		}
		return true;
	}

	private static int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
}