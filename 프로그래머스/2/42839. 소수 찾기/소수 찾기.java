import java.util.*;
import java.io.*;

// 문제 1: 순서대로만 뽑는다 -> O
// 문제 2: 중복된 값을 배제 X

class Solution {
    public int[] permutation(int input_idx, int[] input, int output_idx, int[] output, int term){
        if(input_idx == term){ //n번 순회했으면
            if(output_idx == 0)
                return new int[]{};
            int num = 0;
            for(int i=0; i<output_idx; i++){
                    num = num * 10 + output[i];
            }
            if(num <= 1) return new int[]{};
            for(int i=2; i<num/2+1; i++){
                if(num%i == 0) return new int[]{};
            }
            System.out.println(Arrays.toString(input));
            System.out.println(num);
            return new int[]{num};
        }
        
        List<Integer> result = new ArrayList<>();
        //선택하지 않는 경우
        int[] values = permutation(input_idx+1, input, output_idx, output, term);
        for(int v : values){
                result.add(v);
            }
        //선택하는 경우
        for(int i=0; i<input.length - input_idx; i++){
            output[output_idx] = input[i];
            int[] temp = Arrays.copyOf(input, input.length);
            temp[i] = temp[input.length-input_idx-1];
            values = permutation(input_idx+1, temp, output_idx+1, output, term);
            for(int v : values){
                result.add(v);
            }
        }
        output[output_idx] = input[input_idx]; 

        return result.stream().mapToInt(Integer::intValue).distinct().toArray();
    }
    public int solution(String numbers) {
        
        int len = numbers.length();
        
        int[] numbers_int = new int[len];
        for(int j=0; j<len; j++){
            numbers_int[j] = numbers.charAt(j) - '0';
        }
                                
        int[] values = permutation(0, numbers_int, 0, new int[len], len);
        // System.out.println(Arrays.toString(values));
        
        Set<Integer> final_values = new HashSet();
        for(int v : values){
            final_values.add(v);
        }
        int answer = final_values.size();
        return answer;
    }
}