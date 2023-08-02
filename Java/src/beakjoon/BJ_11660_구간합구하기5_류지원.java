package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author 류지원
 * 문제 : BEAKJOON 11660 구간합구하기5
 *
 * 풀이 방식 :
 * 매번 값들을 더해나가는 방식으로 풀면 시간초과가 된다.
 * (0,0) 원소부터 (r,c)원소까지의 합을 모두 구한상태의 누적합 이차원 배열을 만들어 (r,c)번째 원소의 값으로 하고,
 * 구간의 합을 구할 때 누적합 배열을 참조하여 구간합을 계산한다.
 * 구간의 합을 구할 때 빼야할 곳들은 빼고, 만약 두번 빼어졌다면 두번 빼어진 구간을 한번 더하면 된다.
 * 이 같은 방식을 사용하면 아주 빠르게 답 도출이 가능하다.
 */
public class BJ_11660_구간합구하기5_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 키보드 입력을 받기위한 버퍼리더 선언 및 생성
		StringTokenizer ST;		// 문자열을 자동으로 나눠주는 StringTokenizer 선언
		StringBuilder SB = new StringBuilder();		// 스트링 빌더 선언 및 생성
		
		// 첫번째 라인 처리 : N, M 받기
		ST=new StringTokenizer(br.readLine());	// 문자열을 자동으로 나눠주는 StringTokenizer 생성
		int N=Integer.parseInt(ST.nextToken());	// StringTokenizer의 다음 문자열을 정수형으로 변환한 뒤 선언한 정수형N에 저장
		int M=Integer.parseInt(ST.nextToken());	// StringTokenizer의 다음 문자열을 정수형으로 변환한 뒤 선언한 정수형M에 저장
		
		// 두번째 인풋 처리 : arr 선언 및 값 입력
		int[][] arr=new int[N][N];	// 이차원 정수형 배열 arr 선언 및 N*N개의 배열 생성
		for(int i=0; i<N; i++) {	// 입력받은 문자열을 arr에 입력하기 위한  0~N까지 Sweep하는 배열
			ST=new StringTokenizer(br.readLine());	// 한줄 씩 입력받아 스트링토크나이저에 넣음.
			for(int j=0; j<N; j++) {		// j를 0~N까지 sweep하는 배열
				arr[i][j]=Integer.parseInt(ST.nextToken());		// arr[i][j]에 StringTokenizer에 의해 구분되어진 문자열 하나씩 입력.
			}
		}
		
		// 누적합 배열 선언 및 값 입력
		int[][] AccArr = new int[N][N];	// 구간합을 저장할 AccArr 배열 선언 및 생성
		// 첫번째로 누적합 배열(0,0)에 값 직접 입력
		AccArr[0][0] = arr[0][0];		// 첫 값은 구할 공식이 없으므로 직접 입력
		// 두번째로 누적합 배열의 1행, 1열을 구하기
		for(int i=1; i<N; i++) {		// 첫행과 첫 열을 먼저 계산하여줌.
			AccArr[0][i]=AccArr[0][i-1]+arr[0][i];
			AccArr[i][0]=AccArr[i-1][0]+arr[i][0];
		}
		// 세번째로 (1,1)부터 (N-1,N-1)까지 누적합 구하고 AccArr에 입력
		for(int i=1; i<N; i++) {
			for(int j=1; j<N; j++) {
				// 첫행과 첫열을 제외한 나머지 부분을 구하기 위한 라인
				// 원하는 위치의 누적합을 구하기 위해 1칸위쪽의 누적합과 1칸왼쪽의 누적합을 더하고,
				// 2번 더해지게 된 구간은 빼내어 현재 구하려는 위치의 누적합을 계산.
				AccArr[i][j]=AccArr[i-1][j]+AccArr[i][j-1]-AccArr[i-1][j-1]+arr[i][j];
			}
		}
		
//		// 세번째 인풋 처리 : 테스트케이스 M번 각 처리
		for(int t=0; t<M; t++) {
			ST = new StringTokenizer(br.readLine());	// 스트링토크나이저에 키보드로부터 입력받은 문자열 넣음.
			// 구간합을 구하려는 위치의 첫행을 토크나이저로부터 빼서 입력받음, 구간합을 구하려는 위치의 첫열을 토크나이저로부터 빼서 입력받음,
			int fi = Integer.parseInt(ST.nextToken())-1; int fj = Integer.parseInt(ST.nextToken())-1;
			// 구간합을 구하려는 위치의 마지막행을 토크나이저로부터 빼서 입력받음, 구간합을 구하려는 위치의 마지막열을 토크나이저로부터 빼서 입력받음,
			int bi = Integer.parseInt(ST.nextToken())-1; int bj = Integer.parseInt(ST.nextToken())-1;

			int rst = AccArr[bi][bj];	// 구간합 배열의 마지막행,열의 값을 rst에 넣음
			if (fi > 0) rst -= AccArr[fi-1][bj];	// fi가 0이상이라면 rst에서 AccArr[fi-1][bj]를 뺌
			if (fj > 0) rst -= AccArr[bi][fj-1];	// fj가 0이상이라면 rst에서 AccArr[bi][fj-1]를 뺌
			if (fi > 0 && fj > 0) rst += AccArr[fi-1][fj-1];	// fi와 fj가 0 이상이라면 두번빼어진 구간을 한번 더하기 위해 AccArr[fi-1][fj-1]를 더함
			SB.append(rst + "\n");	// rst의 값을 스트링 빌더에 추가함.
		}
		System.out.print(SB);	// 스트링빌더 출력
	}
}
