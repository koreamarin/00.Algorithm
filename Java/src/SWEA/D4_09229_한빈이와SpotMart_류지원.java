package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 
 * @author 류지원
 * 메모리 : 29776kb
 * 실행시간 : 182ms
 * 
 * 풀이방법: 이중반복문으로 2개씩 탐색하며 조건에 해당하는 값을 찾았다.
 */

public class D4_09229_한빈이와SpotMart_류지원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int TC = Integer.parseInt(br.readLine());	// 테스트 케이스 입력받기
		for(int t=1; t<TC+1; t++) {		// 테스트케이스만큼 반복
			ST = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(ST.nextToken());	// N 생성 및 값 할당
			int M=Integer.parseInt(ST.nextToken());	// M 생성 및 값 할당
			ST = new StringTokenizer(br.readLine());
			int[] arr = new int[N];	// 배열 선언 및 N크기 배열 생성, 할당
			for(int i=0; i<N; i++) arr[i]=Integer.parseInt(ST.nextToken());	// 입력된 값 배열에 할당
			int max = -1;	// max는 -1이 초기값
			for(int i=0; i<N-1; i++) {	// 탐색할 첫번쨰 원소
				for(int j=i+1; j<N; j++) {	// 탐색할 두번째 원소. j의 값을 i+1로 두는 것이 핵심
					int sum = arr[i]+arr[j];	// 첫번쨰 원소와 두번째 원소를 더한값 sum
					if(M>=sum && sum>max) max=sum;	// sum의 값이 M이하이면서 max보다 크다면 max에 sum값을 할당
				}
			}
			System.out.println("#" + t + " " + max);	// max 값 출력
		}
	}
}
