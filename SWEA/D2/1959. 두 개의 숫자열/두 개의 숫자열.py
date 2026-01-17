import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String args[]) throws IOException {
		// 빠른 입력을 위한 BufferedReader와 출력을 모으기 위한 StringBuilder
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for(int test_case=1; test_case <= T; test_case++) {
			// 두 배열의 크기(N, M) 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			// 첫 번째 배열 입력
			int[] ary1 = new int[n1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n1; i++) {
				ary1[i] = Integer.parseInt(st.nextToken());
			}
			
			// 두 번째 배열 입력
			int[] ary2 = new int[n2];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n2; i++) {
				ary2[i] = Integer.parseInt(st.nextToken());
			}
			
			// [핵심] ary1은 항상 '짧은 배열', ary2는 '긴 배열'이 되도록 설정 (Swap)
			if(n1 > n2) {
				int[] temp_arr = ary1; ary1 = ary2; ary2 = temp_arr;
				int temp_num = n1; n1 = n2; n2 = temp_num;
			}
			
			// 최댓값 비교를 위해 가장 작은 정수값으로 초기화
			int cur_max = Integer.MIN_VALUE;
			
			// 긴 배열(ary2) 구간 안에서 짧은 배열(ary1)을 이동시키며 계산
			for(int i=0; i < n2-n1+1; i++) {
				int sum = 0;
				// 마주보는 숫자끼리 곱의 합 구하기
				for(int j=0; j<n1; j++) {
					sum += ary1[j] * ary2[i+j];
				}
				// 더 큰 값이 나오면 갱신
				if(cur_max < sum) cur_max = sum;
			}
			
			// 결과 포맷팅하여 저장
			sb.append('#').append(test_case).append(' ').append(cur_max).append('\n');
		}
		// 전체 정답 출력
		System.out.println(sb);
	}
}