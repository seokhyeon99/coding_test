import java.util.*;
import java.io.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int last = k;
        int result = 0;
        // String[] num_str = number.split("");
        // int[] numbers = new int[number.length()];
        // for(int i=0; i<number.length(); i++){
        //     numbers[i] = Integer.parseInt(num_str[i]);
        // }
        
        for(int i =0; i<number.length() - k; i++){
            char max = 0;
            int max_idx = 0;
            for(int j=start; j<=last; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    max_idx = j;
                }
            }
            sb.append(max);
            start = max_idx+1;
            last++;
        }
        return sb.toString();
    }
}