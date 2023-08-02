package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N과M2_류지원 {
	static int N;
	static int[] numbers;
	static int M;
	static StringBuilder SB;
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        N = Integer.parseInt(ST.nextToken());
        M = Integer.parseInt(ST.nextToken());
        numbers = new int[M];
        SB=new StringBuilder();
        NM(0);
        System.out.println(SB);
    }
    
    public static void NM(int cnt) {
    	if(cnt==M) {
    		for(int i=0;i<M;i++) SB.append((numbers[i]+1)+" ");
    		SB.append("\n");
    		return;
    	}
    	
    	for(int i=cnt; i<N; i++) {
    		if(cnt==0) {
				numbers[cnt]=i;
				NM(cnt+1);
    		} else if(numbers[cnt-1]<i) {
    			numbers[cnt]=i;
    			NM(cnt+1);
    		}
		}
    }
}
