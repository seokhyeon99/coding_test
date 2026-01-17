import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sw_num = Integer.parseInt(br.readLine());
        int[] sw = new int[sw_num+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<sw_num+1; i++){
            sw[i] = Integer.parseInt(st.nextToken());
        }

        int stu_num = Integer.parseInt(br.readLine());
        for(int i=1; i<stu_num+1; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            if(sex == 1){
                for(int j=1; j<sw_num+1; j++){
                    if(j % loc == 0){
                        if(sw[j] != 0){
                            sw[j] = 0;
                        } else{
                            sw[j] = 1;
                        }
                    }
                }
            }
            else{
                int count = Math.min(loc-1, sw_num-loc);
                for(int j=0; j<count+1; j++){
                    if(sw[loc-j] != sw[loc+j]) break;
                    else{
                        if(sw[loc-j] != 0){
                            sw[loc-j] = 0;
                            sw[loc+j] = 0;
                        } else{
                            sw[loc-j] = 1;
                            sw[loc+j] = 1;
                        }
                    }
                }
            }
        }
        for(int i=1; i<sw_num+1; i++){                
            sb.append(sw[i]).append(' ');
            if(i%20==0) sb.append('\n');
        }
        System.out.println(sb);
    }
}