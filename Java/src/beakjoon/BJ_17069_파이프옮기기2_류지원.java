package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 
 * 시간 : 
 * 풀이방법 : 
 * 1. 백트래킹
 * 1-1. 오른쪽으로 (벽때문에 배치못하면 사용못함)
 * 1-2. 대각선 아래로 (벽때문에 배치못하면 사용못함)
 * 1-3. 아래로 (벽때문에 배치못하면 사용못함)
 * 1-4. 리턴하여 백트래킹
 * 
 * 
 */

public class BJ_17069_파이프옮기기2_류지원 {
	static boolean[][] isVisited;
	static int[][] house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		isVisited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			ST = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				house[i][j]=Integer.parseInt(ST.nextToken());
			}
		}
		
		
		
		
		
		
		

	}

}
