import java.util.*;

class Solution {
    public int solution(String name) {
        
        int[] name_ary = new int[name.length()];
        int[] flipped = new int[name.length()];
        for(int i=0; i<name.length(); i++){
            int temp = (int) name.charAt(i) - 'A';
            if(temp <= 13) name_ary[i] = temp;
            else name_ary[i] = 26 - temp;
        }
        int ver_cnt = 0;
        for(int n : name_ary){
            ver_cnt += n;
        }
        int hor_cnt = get_horizon(name_ary);
        
        int answer = hor_cnt + ver_cnt;
        return answer;
    }
    
    public int get_horizon(int ary[]){
        int min_dist = ary.length - 1;
        for(int i=0; i<ary.length; i++){
            int next = i + 1;
            while(next<ary.length && ary[next] == 0){
                next++;
            }
        min_dist = Math.min(min_dist, 2*i + ary.length - next);
        min_dist = Math.min(min_dist, i + 2*(ary.length - next));
        }
        return min_dist;
    }
    


    public int get_horizontal_oneway(int ary[]){
        int prev_val = ary[0];
        int prev_idx = 0;
        int series=0;
            
        for(int i=1; i<ary.length; i++){
            if(prev_val == 0){
                if(ary[i] == 0) continue;
                else{
                    series += i - prev_idx - 1;
                    prev_val = ary[i];
                    prev_idx = i;
                }
            } else{
                if(ary[i] == 0){
                    prev_val = ary[i];
                    prev_idx = i;
                }
            }                
        }
        return ary.length - 1 - series;
    }
}