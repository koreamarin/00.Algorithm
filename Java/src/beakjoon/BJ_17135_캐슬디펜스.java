package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(ST.nextToken());	// 행의 수
		int M = Integer.parseInt(ST.nextToken());	// 열의 수
		int D = Integer.parseInt(ST.nextToken());	// 공거거리
		
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {					// 배열 입력받기
			ST = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j]=Integer.parseInt(ST.nextToken());
		}
		
		int terminatedEnemy = 0;
		
		
		
	}
	
}
