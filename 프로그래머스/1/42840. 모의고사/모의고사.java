import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length; // 문제의 총 개수 파악
        
        // 1. 각 수포자가 찍는 모든 답안을 저장할 배열 생성 (문제 수만큼의 길이)
        int[] m1 = new int[len];
        int[] m2 = new int[len];
        int[] m3 = new int[len];
        
        // 2. 반복되는 찍기 패턴 정의
        int[] m2_pattern = {2, 1, 2, 3, 2, 4, 2, 5}; // 수포자 2의 반복 패턴
        int[] m3_pattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 수포자 3의 반복 패턴
        
        // 3. 각 수포자의 맞힌 개수를 저장할 배열 (0번: 수포자1, 1번: 수포자2, 2번: 수포자3)
        int[] count = {0, 0, 0};

        // 4. 반복문을 돌며 각 문제의 정답과 수포자의 답을 비교
        for(int i = 0; i < len; i++){
            // 수포자 1의 답 결정: 1, 2, 3, 4, 5 반복 (나머지 연산 활용)
            m1[i] = i % 5 + 1;
            // 수포자 2의 답 결정: 패턴 배열을 순환
            m2[i] = m2_pattern[i % m2_pattern.length];
            // 수포자 3의 답 결정: 패턴 배열을 순환
            m3[i] = m3_pattern[i % m3_pattern.length];
            
            // 실제 정답(answers[i])과 비교하여 점수(count) 가산
            if(answers[i] == m1[i]) count[0]++;
            if(answers[i] == m2[i]) count[1]++;
            if(answers[i] == m3[i]) count[2]++;
        }
        
        // 5. 세 명 중 가장 높은 점수(최댓값) 찾기
        int max_count = count[0];
        for(int i = 1; i < 3; i++){
            if(max_count < count[i]) max_count = count[i];
        }
        
        // 6. 가장 높은 점수를 받은 사람(들)을 찾아서 리스트에 추가
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max_count == count[i])
                temp.add(i + 1); // 사람 번호는 1번부터 시작하므로 i+1
        }
        
        // 7. 가변 리스트(ArrayList)를 문제 요구 사항인 고정 배열(int[])로 변환
        int[] answer = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            answer[i] = temp.get(i);
        }
        // answer = temp.stream().mapToInt(i -> i).toArray();  
        
        return answer; // 최종 결과 반환
    }
}       



