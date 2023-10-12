package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_04193_수영대회결승전_류지원 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			int N = Integer.parseInt(br.readLine());		// 수영장의 크기
			int[][] map = new int[N][N];					// 수영장 배열
			
			for(int i=0; i<N; i++) {						// 수영장 상태 입력받기, 지나갈수 있는곳 0, 장애물 1, 주기2초 소용돌이2
				ST = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {					
					map[i][j] = Integer.parseInt(ST.nextToken());
				}
			}
			
			// 시작위치
			ST = new StringTokenizer(br.readLine());
			int[] sttLo = {Integer.parseInt(ST.nextToken()),Integer.parseInt(ST.nextToken())};
			
			// 도착위치
			ST = new StringTokenizer(br.readLine());
			int[] targetLo = {Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken())};
			
			
			
			
		}

	}

}
