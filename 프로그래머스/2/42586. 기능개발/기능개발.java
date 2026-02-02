import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> q1 = new ArrayDeque<>();
        for(int prog: progresses){
            q1.offer(prog);
        }
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int sp: speeds){
            q2.offer(sp);
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!q1.isEmpty()){
            int days = 0;
            int t1 = q1.peek();
            int t2 = q2.peek();

            days = (100 - t1)/t2;
            if((100-t1) % t2 != 0) days++;
            
            int count = 0;

            while(!q1.isEmpty() && (q1.peek()+days*q2.peek()) >= 100){
                q1.poll();
                q2.poll();
                count++;
            }
            result.add(count);

        }
                  
        answer = result.stream().mapToInt(i -> i).toArray();
    
        return answer;
    }
}
     