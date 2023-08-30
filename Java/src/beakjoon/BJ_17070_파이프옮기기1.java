package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		int[][][] dp=new int[N][N][3];
		
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) map[i][j]=Integer.parseInt(ST.nextToken());
		}
		
		for(int j=0; j<N; j++) Arrays.fill(dp[0][j], 1);
		
		dp[0][1][0]=dp[0][1][1]=dp[0][1][2]=1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(Arrays.toString(dp[i][j]));
			}
			System.out.println();
		}
		
		////////////////////////////////////////////////////////
		
		for(int j=1; j<N; j++) {
			if(map[0][j]==1) {
				for(int jj=j; jj<N; jj++) {
					dp[0][jj][0]=dp[0][jj][1]=dp[0][jj][2]=0;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(Arrays.toString(dp[i][j]));
			}
			System.out.println();
		}
		
		// dp[][][0]은 대각선에서 온 것. dp[][][1]은 왼쪽에서 온 것. dp[][][2]는 위쪽에서 온 것.
		for(int i=1; i<N; i++) {
			for(int j=2; j<N; j++) {
				if(map[i-1][j]!=1 && map[i][j-1]!=1 && map[i][j]!=1) {
					dp[i][j][0]=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
				}
				if(map[i][j]!=1) {
					dp[i][j][1]=dp[i][j-1][0]+dp[i][j-1][1];
					dp[i][j][2]=dp[i][j-2][0]+dp[i][j-1][2];
				}
			}
		}
		
		
//		for(int i=0; i<N; i++) System.out.println(Arrays.toString(dp[i]));
//		System.out.println(dp[N-1][N-1]);
	}
}
