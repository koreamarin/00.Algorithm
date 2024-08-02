package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_02207_벽부수고이동하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(ST.nextToken());
		int M = Integer.parseInt(ST.nextToken());
		
		boolean[][] map = new boolean[N][M];
		
		for(int n=0; n<N; n++) {
			String s = br.readLine();
			
			for(int m=0; m<M; m++) {
				if(s.charAt(m)-'0'==0) {
					map[n][m]=false;	// false는 길
				} else if(s.charAt(m)-'0'==1) {
					map[n][m]=true;		// true는 벽
				}
				
			}
		}
		
		

	}

}
