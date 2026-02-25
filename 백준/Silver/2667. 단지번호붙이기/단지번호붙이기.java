import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int[][] map;
    static int N, complexNum, count;
    static List<Integer> houseNum = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = tmp.charAt(j)-'0';
            }
        }

    // dfs();
        complexNum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != 0){
                    complexNum++;
                    count = 0;
                    findNum(i, j);
                    houseNum.add(count);
                }
            }
        }

        Collections.sort(houseNum);

        System.out.println(complexNum);
        for(int i=0; i<complexNum; i++){
            System.out.println(houseNum.get(i));
        }
        
    }

    static void findNum(int cy, int cx){
        map[cy][cx] = 0;
        count++;
        int ny = 0;
        int nx = 0;
        for(int i=0; i<4; i++){
            ny = cy + dy[i];
            nx = cx + dx[i];
            if(nx >= 0 && nx < N && ny>=0 && ny<N && map[ny][nx] != 0){
                findNum(ny, nx);
            }
        }
    }
    
}