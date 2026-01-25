import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int len = sizes.length;

        int[] l = new int[len];
        int[] s = new int[len];
        
        
        for(int i=0; i<len; i++){
            l[i] = Math.max(sizes[i][0], sizes[i][1]);
            s[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        int max_l = Arrays.stream(l).max().getAsInt();
        int max_s = Arrays.stream(s).max().getAsInt();
        
        answer = max_l * max_s;
        
        
        return answer;
    }
    
}