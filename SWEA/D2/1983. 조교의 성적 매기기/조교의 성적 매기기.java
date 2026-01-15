import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // SB는 밖에서 한 번만 선언

        int T = Integer.parseInt(br.readLine());
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken()) - 1; // 0-based index로 변환

            // [0]: 점수, [1]: 원래 인덱스 
            // (점수만 필요하지만 정렬 후 원래 인덱스를 찾아야 하므로 둘 다 저장)
            double[][] students = new double[n][2];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int fin = Integer.parseInt(st.nextToken());
                int hw = Integer.parseInt(st.nextToken());
                
                // 총점 계산
                double total = mid * 0.35 + fin * 0.45 + hw * 0.20;
                
                students[i][0] = total;
                students[i][1] = i; // 원래 번호 저장
            }

            // 점수 기준 내림차순 정렬
            Arrays.sort(students, (o1, o2) -> Double.compare(o2[0], o1[0]));

            // 정렬된 배열에서 K번째 학생(원래 인덱스가 k인 학생) 찾기
            for (int i = 0; i < n; i++) {
                if ((int) students[i][1] == k) {
                    // i는 현재 등수(0등 ~ n-1등)
                    // N/10 명씩 같은 등급을 가짐
                    int gradeIndex = i / (n / 10);
                    sb.append("#").append(test_case).append(" ").append(grades[gradeIndex]).append("\n");
                    break; // 찾았으면 반복 종료 (효율성)
                }
            }
        }
        System.out.println(sb);
    }
}