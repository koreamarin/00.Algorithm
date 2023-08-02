package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 문제 : BEAKJOON 11659 구간합구하기4
 *
 * 풀이 방식 :
 * 매번 값들을 더해나가는 방식으로 풀면 시간초과가 된다.
 * 0번쨰 원소부터 n번째 원소까지의 합을 모두 구한상태의 누적합 배열을 만들어 n번째 원소의 값으로 하고,
 * 구간의 합을 구할 때 누적합 배열을 참조하여 시작구간 전의 누적합과 마지막구간의 누적합을 서로 빼면 아주 빠르게 답 도출이 가능하다.
 */
public class BJ_11659_구간합구하기4_류지원 {
	static StringBuilder SB;		// 스트링 빌더 선언
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 키보드 입력을 받기위한 버퍼리더 선언 및 생성
		StringTokenizer ST;	// 문자열을 자동으로 나눠주는 StringTokenizer 선언
		
		ST = new StringTokenizer(br.readLine());	// 문자열을 자동으로 나눠주는 StringTokenizer 생성
		int N=Integer.parseInt(ST.nextToken());	// StringTokenizer의 다음 문자열을 정수형으로 변환한 뒤 선언한 정수형N에 저장
		int M=Integer.parseInt(ST.nextToken());	// StringTokenizer의 다음 문자열을 정수형으로 변환한 뒤 선언한 정수형M에 저장
		// 두번째 라인 처리 파트
		ST = new StringTokenizer(br.readLine());	// 문자열을 자동으로 나눠주는 StringTokenizer 생성
		int[] arr = new int[N];		// 정수형 배열 arr 선언 및 N개의 배열 생성
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(ST.nextToken());	// arr[i]에 입력받은 문자열을 정수형으로 변환하여 저장


		int[] DP = new int[N];	// 값을 저장할 배열
		DP[0]=arr[0];	// DP에 값 저장. 1부터 원소번호까지 더한 것.
		for(int i=1; i<N; i++) DP[i]=DP[i-1]+arr[i];	// DP에 값 저장. 1부터 원소번호까지 더한 것.

		SB=new StringBuilder();	// StringBuilder 객체생성
		
		// 세번째 라인부터 처리
		for(int i=0; i<M; i++) {	// i를 0부터 M까지 sweep하는 반복문 실행
			ST = new StringTokenizer(br.readLine());	// 문자열을 자동으로 나눠주는 StringTokenizer 생성
			int stt=Integer.parseInt(ST.nextToken());	// StringTokenizer의 다음 문자열을 정수형으로 변환한 뒤 선언한 정수형stt에 저장
			int stp=Integer.parseInt(ST.nextToken());	// StringTokenizer의 다음 문자열을 정수형으로 변환한 뒤 선언한 정수형stp에 저장
			if(stt==1) {			// stt가 1이라면 실행되는 조건문
				SB.append(DP[stp-1]+"\n");		// 스트링빌더 객체 SB에 해당 문자열 추가
			} else {				// 위 조건에 해당되지 않을 때 실행되는 조건문
				SB.append(DP[stp-1]-DP[stt-2]+"\n");	// 스트링빌더 객체 SB에 해당 문자열 추가
			}
		}
		
		// 스트링빌더에 저장된 문자열 출력
		System.out.println(SB);
	}
}
