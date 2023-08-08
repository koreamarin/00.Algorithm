package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1_류지원 {
	static int[][] arr;	// 멤버변수 이차원 정수형배열 arr 선언
	static int N;		// 열의 개수을 저장할 N 선언
	static int M;		// 행의 개수를 저장할 M 선언
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		// 첫번쨰 라인 입력받기
		ST = new StringTokenizer(br.readLine());	// StringTokenizer를 이용하여 키보드 입력받기
		N = Integer.parseInt(ST.nextToken());		// N 생성 및 값 할당
		M = Integer.parseInt(ST.nextToken());		// M 생성 및 값 할당
		int R = Integer.parseInt(ST.nextToken());	// 정수형 변수 R 선언,생성 및 값 할당
		
		// 배열 입력받기.
		arr = new int[N][M];		// 배열을 M*N 사이즈로 생성
		for(int i=0; i<N; i++) {	// 배열에 키보드로 입력 받은값 할당하는 반복문
			ST = new StringTokenizer(br.readLine());	
			for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(ST.nextToken());
		}
		
		RRotation(R);				// R회 회전 실행 메서드
		for(int i=0; i<N; i++)	{	// arr 원소 값 출력 반복문
			for(int j=0; j<M; j++) System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		
	}
	
	// R회 회전 실행 메서드, R만큼 회전시킨다.
	public static void RRotation(int R) {
		int G = (N>M) ? M/2 : N/2;				// 회전할 껍질 개수
		for(int r=0; r<R; r++) Rotation(G, 0);	// 회전 1회 해주는 함수를 돌려야하는 횟수만큼 재실행
	}
	
	// arr는 회전할 배열, G는 껍질 넘버. cnt는 회전할 최외각 껍질에서 안쪽으로 세는 껍질 넘버(?)
	public static void Rotation(int G, int cnt) {
		if(cnt==G) return; 			// 기저 조건
		int save = arr[cnt][cnt];	// arr[cnt][cnt]는 덮어씌워져 사라질수 있으므로 따로 빼놓음.
		for(int j=cnt; j<M-cnt-1; j++) arr[cnt][j]=arr[cnt][j+1];	// 북쪽 껍질 회전
		for(int i=cnt; i<N-cnt-1; i++) arr[i][M-cnt-1]=arr[i+1][M-cnt-1];	// 동쪽 껍질 회전
		for(int j=M-cnt-1; j>cnt; j--) arr[N-cnt-1][j]=arr[N-cnt-1][j-1];	// 남쪽 껍질 회전
		for(int i=N-cnt-1; i>cnt+1; i--) arr[i][cnt]=arr[i-1][cnt];	// 서쪽 껍질 회전
		arr[cnt+1][cnt]=save;	// 마지막 회전할 원소는 따로 저장해놓았던 save값 할당.
		Rotation(G, cnt+1);		// 다음 껍질 회전 실행. 재귀.
	}
}
