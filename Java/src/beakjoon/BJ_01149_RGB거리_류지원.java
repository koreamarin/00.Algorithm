package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01149_RGB거리_류지원 {
	static int[] dp; static int[][] paintExp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());
		int[][] paintExp=new int[N][3];
		
		for(int n=0; n<N; n++) {
			ST=new StringTokenizer(br.readLine());
			for(int i=0; i<3; i++) paintExp[n][i]=Integer.parseInt(ST.nextToken());
		}
		
		int minExp=Integer.MAX_VALUE;
		
		for(int i=0; i<3; i++) {	// 첫 집을 레드로 했을 때. 첫 집을 그린으로 했을 때. 첫 집을 블루로 했을 때.
			dp = new int[N];
			dp[i]=i;
			
		}
		
	}
	
	public static long DP(int n) {
//		if(DP(n-1)+1%3)
		dp[n]=(int) ((DP(n-1)+1)%3);
		
		
		
//		dp[n]=(DP(n-1)+2)%3;
		
		return dp[n];
	}
}
