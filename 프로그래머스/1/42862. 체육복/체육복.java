import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] extra = new boolean[n+1];
        boolean[] lost_array = new boolean[n+1];
        for(int i : reserve){
            extra[i] = true; 
        }
        for(int lo : lost){
            lost_array[lo] = true; 
        }
        for(int i=1; i<n+1; i++){
            if(lost_array[i] && extra[i]){
                extra[i] = false;
                lost_array[i] = false;
            } 
        }  
        for(int i=1; i<=n; i++){
            if(lost_array[i] && i >= 2 && extra[i-1]){
                extra[i-1] = false;
                lost_array[i] = false;
            } else if(lost_array[i] && i < n && extra[i+1]){
                extra[i+1] = false;
                lost_array[i] = false;
            } 
        }  
        
        int count = 0;
        for(int i=1; i<n+1; i++){
            if(lost_array[i]) count++;
        }

        int answer = n - count;
        System.out.println(answer);
        return answer;
    }
}