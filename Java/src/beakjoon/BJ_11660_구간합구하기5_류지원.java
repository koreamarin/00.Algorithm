package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		// 첫번째 라인 처리 : N, M 받기
		ST=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken());
		int M=Integer.parseInt(ST.nextToken());
		
		// 두번째 인풋 처리 : arr 선언 및 값 입력
		int[][] arr=new int[N][N];
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(ST.nextToken());
			}
		}
		
		// 누적합 배열 선언 및 값 입력
		int[][] AccArr = new int[N][N];
		// 첫번째로 누적합 배열(0,0)에 값 직접 입력
		AccArr[0][0] = arr[0][0];
		// 두번째로 누적합 배열의 1행, 1열을 구하기
		for(int i=1; i<N; i++) {
			AccArr[0][i]=AccArr[0][i-1]+arr[0][i];
			AccArr[i][0]=AccArr[i-1][0]+arr[i][0];
		}
		// 세번째로 (1,1)부터 (N-1,N-1)까지 누적합 구하기
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				AccArr[i][j]=AccArr[i-1][j]+AccArr[i][j-1]-AccArr[i-1][j-1]+arr[i][j];
			}
		}
		
		// 
		for(int i=0;i<N; i++) System.out.println(Arrays.toString(AccArr[i]));
		
//		// 세번째 인풋 처리 : 테스트케이스 M번 각 처리
		for(int t=0; t<M; t++) {
			ST=new StringTokenizer(br.readLine());
			int fi = Integer.parseInt(ST.nextToken()); int fj = Integer.parseInt(ST.nextToken());
			int bi = Integer.parseInt(ST.nextToken()); int bj = Integer.parseInt(ST.nextToken());
			
			
			
			
			
		}
		
		
		
	}
}
