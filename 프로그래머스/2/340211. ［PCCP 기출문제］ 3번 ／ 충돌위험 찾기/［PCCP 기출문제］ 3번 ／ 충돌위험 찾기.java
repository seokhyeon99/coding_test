import java.util.*;

class Solution {
    
    static int[][] map;
    static int[] robot_y;
    static int[] robot_x;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer>[] dir;
    static int count;
    
    public int solution(int[][] points, int[][] routes) {
        robot_y = new int[routes.length];
        robot_x = new int[routes.length];
        count = 0;
        for(int i=0; i<routes.length; i++){
            int startIdx = routes[i][0] - 1;
            robot_y[i] = points[startIdx][0];
            robot_x[i] = points[startIdx][1];
        }
        // System.out.println(Arrays.toString(robot_y));
        // System.out.println(Arrays.toString(robot_x));
        
        getDir(points, routes);
        // System.out.println(Arrays.toString(dir));
        
        move();
        return count;
    }
    
    public static void move(){
        int maxSize = Integer.MIN_VALUE;
        for(int i=0; i<dir.length; i++){
            maxSize = Math.max(maxSize, dir[i].size());
        }
        
        int[][] map = new int[101][101];
        for(int j=0; j<dir.length; j++){ //0초 일때
            if(map[robot_y[j]][robot_x[j]] == 1) count++;
            map[robot_y[j]][robot_x[j]] += 1;
        }
        
        for(int i=0; i<maxSize; i++){
            map = new int[101][101];
            for(int j=0; j<dir.length; j++){
                if(i >= dir[j].size()) continue;
                int idx = dir[j].get(i);
                robot_y[j] += dy[idx];
                robot_x[j] += dx[idx];
                if(map[robot_y[j]][robot_x[j]] == 1) count++;
                map[robot_y[j]][robot_x[j]] += 1;
            }
        }
    }
    
    public static void getDir(int[][] points, int[][] routes){
        dir = new ArrayList[routes.length];
        for(int i=0; i<routes.length; i++){
            dir[i] = new ArrayList<>();
            for(int j=1; j<routes[0].length; j++){
                int nextLocIdx = routes[i][j]-1;
                int curLocIdx = routes[i][j-1]-1;
                int diff_y = points[nextLocIdx][0] - points[curLocIdx][0];
                int diff_x = points[nextLocIdx][1] - points[curLocIdx][1];
                for(int d=0; d<Math.abs(diff_y); d++){
                    if(diff_y >= 0){
                        dir[i].add(1);
                    } else {
                        dir[i].add(3);
                    }
                }
                for(int d=0; d<Math.abs(diff_x); d++){
                    if(diff_x >= 0){
                        dir[i].add(0);
                    } else {
                        dir[i].add(2);
                    }
                }
            }
        }
    }
}