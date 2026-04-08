import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int[] dp = new int[31];
        dp[1] = 0;
        dp[2] = 1;
        for(int i=3; i<31; i++){
            if(i%2 == 1){
                dp[i] = dp[i-1];
            } else{
                dp[i] = dp[i/2]+1;
            }
        }
        int sum = 0;
        for(int i=0; i<num_list.length; i++){
            sum += dp[num_list[i]];
        }
        return sum;
    }
}