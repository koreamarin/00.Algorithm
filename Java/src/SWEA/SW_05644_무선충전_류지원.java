package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_05644_무선충전_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(ST.nextToken());	// 총 이동시간
			int A = Integer.parseInt(ST.nextToken());	// BC의 개수
			
			int[] directionA = new int[M];				// A의 이동정보
			int[] directionB = new int[M];				// B의 이동정보
			
			ST = new StringTokenizer(br.readLine());	// A의 이동정보 입력받기
			for(int i=0; i<M; i++) directionA[i] = Integer.parseInt(ST.nextToken());
			ST = new StringTokenizer(br.readLine());	// B의 이동정보 입력받기
			for(int i=0; i<M; i++) directionB[i] = Integer.parseInt(ST.nextToken());
			
			int[][] APInfoArr = new int[A][];
			
			for(int i=0; i<A; i++) {
				ST = new StringTokenizer(br.readLine());	// AP 정보
				int[] APInfo = {Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken())};
				APInfoArr[i] = APInfo;
			}
			
			
			
		}
	}

}
