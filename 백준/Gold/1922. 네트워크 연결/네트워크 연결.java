import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N, M;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static List<Node>[] connect;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        connect = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            connect[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            connect[from].add(new Node(to, cost));
            connect[to].add(new Node(from, cost));
        }

        Prim(1);
    }

    public static void Prim(int start) {
        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        int total = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.to]) continue;

            visited[now.to] = true;
            total += now.cost;

            for(Node next : connect[now.to]) {
                if(!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(total);
    }
}