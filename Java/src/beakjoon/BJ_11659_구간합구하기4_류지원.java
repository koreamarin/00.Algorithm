package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4_류지원 {
	static StringBuilder SB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		ST = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken());
		int M=Integer.parseInt(ST.nextToken());
		// 두번째 라인 처리
		ST = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(ST.nextToken());
		// 값을 저장할 배열
		int[] DP = new int[N];
		
		// DP에 값 저장. 1부터 원소번호까지 더한 것.
		DP[0]=arr[0];
		for(int i=1; i<N; i++) DP[i]=DP[i-1]+arr[i];
		
		// StringBuilder 객체생성
		SB=new StringBuilder();
		
		// 세번째 라인부터 처리
		for(int i=0; i<M; i++) {
			ST = new StringTokenizer(br.readLine());
			int stt=Integer.parseInt(ST.nextToken());
			int stp=Integer.parseInt(ST.nextToken());
			if(stt==1) {
				SB.append(DP[stp-1]+"\n");
			} else {
				SB.append(DP[stp-1]-DP[stt-2]+"\n");
			}
		}
		
		// 출력
		System.out.println(SB);
	}
}
