import java.util.*;

class Solution {
    
    static int[][] map;
    static int idx = 1;
    static List<Integer> mass;
    static int[] dx={1, 0, -1, 0};
    static int[] dy={0, 1, 0, -1};
    static int ySize, xSize;
    static int count;
    static Queue<int[]> q;
    
    public int solution(int[][] land) {
        ySize = land.length;
        xSize = land[0].length;
        q = new ArrayDeque<>();
        mass = new ArrayList<>();
        map = new int[ySize][xSize];
        for(int i=0; i<ySize; i++){
            for(int j=0; j<xSize; j++){
                map[i][j] = -land[i][j];
            }
        }
        numbering();
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<xSize; i++){
            boolean[] v = new boolean[mass.size()];
            for(int j=0; j<ySize; j++){
                if(map[j][i] != 0 && !v[map[j][i]-1]){
                    v[map[j][i]-1] = true;
                }
            }
            int localCnt = 0;
            for(int j=0; j<v.length; j++){
                if(v[j]){
                    localCnt += mass.get(j);
                }
            }
            max = Math.max(max, localCnt);
        }
        return max;
    }
    
     public void numbering()   {
         for(int i=0; i<ySize; i++){
            for(int j=0; j<xSize; j++){
                if(map[i][j] == -1){
                    map[i][j] = idx;
                    count = 1;
                    q.offer(new int[]{i,j});
                    // dfs(i, j);
                    bfs();
                    mass.add(count);
                    idx++;
                }
            }
        }
    }
    
    public void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                if(isIn(ny, nx) && map[ny][nx]==-1){
                    map[ny][nx] = idx;
                    count++;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
    }
    
    // public void dfs(int cy, int cx){
    //     for(int i=0; i<4; i++){
    //         int ny = cy + dy[i];
    //         int nx = cx + dx[i];
    //         if(isIn(ny, nx) && map[ny][nx]==-1){
    //             map[ny][nx] = idx;
    //             count++;
    //             bfs(ny, nx);
    //         }
    //     }
    // }
    
    public boolean isIn(int y, int x){
        if(y>=0 && y<ySize && x>=0 && x<xSize) return true;
        return false;
    }
}