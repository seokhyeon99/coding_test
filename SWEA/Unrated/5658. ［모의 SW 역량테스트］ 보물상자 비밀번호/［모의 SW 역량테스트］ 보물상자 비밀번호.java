import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc < T + 1; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Set<Integer> set = new HashSet<>();
			String nums = br.readLine();
			int unit = N / 4;
			for (int i = 0; i < unit; i++) { // 회전
				char[] hex = new char[unit];
				for (int j = 0; j < 4; j++) { // 자릿수 단위로 시작점(각 변의 첫번째 숫자) 이동 
					int tmpNum = 0;
					for (int k = 0; k < unit; k++) { // 자릿수마다 변환 
						tmpNum *= 16;
						tmpNum += Character.digit(nums.charAt((i + j * unit + k) % N), 16);
					}
					set.add(tmpNum);
				}
			}
			int[] result = new int[set.size()];
			int idx = 0;
			for (int s : set) {
				result[idx++] = s;
			}
			Arrays.sort(result);
			sb.append("#").append(tc).append(" ").append(result[idx - K]).append("\n");
		}
		System.out.println(sb);
	}
}