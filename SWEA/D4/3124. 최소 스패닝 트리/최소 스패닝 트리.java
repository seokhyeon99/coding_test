import java.io.*;
import java.util.*;

class Solution {

    static int V, E;
    static int[] parents, rank;
    static class Edge implements Comparable<Edge>{
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static List<Edge> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc < T+1; tc++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V+1];
            list = new ArrayList<>();
            for(int i=1; i<=V; i++){
                parents[i] = i;
            }
            rank = new int[V+1];
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.add(new Edge(a, b, c));
            }

            int count = 0;
            long w = 0;
            Collections.sort(list);
            for(Edge e : list){
                if(union(e.from, e.to)){
                    w += e.weight;
                    count++;
                    if(count == V-1){
                        break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(w).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        if(rank[aRoot] >= rank[bRoot]){
            parents[bRoot] = aRoot;
            rank[aRoot] += rank[bRoot];
            rank[bRoot] = 0;
        } else{
            parents[aRoot] = bRoot;
            rank[bRoot] += rank[aRoot];
            rank[aRoot] = 0;
        }
        return true;
    }

    private static int findSet(int a){
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }
}