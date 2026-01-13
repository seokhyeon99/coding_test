
import java.util.StringTokenizer;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][n];

            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + test_case);
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.print(arr[n-j-1][i]);
                }
                System.out.print(' ');
                for(int j=0; j<n; j++){
                    System.out.print(arr[n-i-1][n-j-1]);
                }
                System.out.print(' ');                
                for(int j=0; j<n; j++){
                    System.out.print(arr[j][n-i-1]);
                }
                System.out.println();
            }
		}
	}
}