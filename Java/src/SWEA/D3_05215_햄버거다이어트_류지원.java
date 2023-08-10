package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 수행시간 : 736ms
 * 메모리 : 21084kb
 * 
 * 풀이방법 : 원소선택개수에 제한이 없고, 순서가 의미가 없으므로 부분집합문제이다.
 * 재귀를 이용한 부분집합으로 풀이하였다.
 */

public class D3_05215_햄버거다이어트_류지원 {
	static int[] flavor;	// 맛을 담을 배열
	static int[] kcal;		// 칼로리를 담을 배열
	static boolean[] isSelected;	// 재료 선택을 했는지 안했는지 담을 배열
	static int N; static int L; static int FlavorMax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			// 각 테스트 케이스의 N,L 입력받기
			ST=new StringTokenizer(br.readLine());
			N=Integer.parseInt(ST.nextToken());
			L=Integer.parseInt(ST.nextToken());
			flavor=new int[N]; kcal=new int[N];
			FlavorMax=0; isSelected=new boolean[N];
			// 각 테스트 케이스의 재료의 맛과 칼로이 입력받기
			for(int n=0;n<N;n++) {
				ST=new StringTokenizer(br.readLine());
				flavor[n]=Integer.parseInt(ST.nextToken());
				kcal[n]=Integer.parseInt(ST.nextToken());
			}
			FlavorMax(0);	// 재귀 시작.
			System.out.println("#"+t+" "+FlavorMax);	// 최대 맛 출력
		}
	}
	
	public static void FlavorMax(int cnt) {
		if(cnt==N) {	// 기저조건
			int KcalSum=0; int FlavorSum=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {	// 재료를선택했을경우
					KcalSum+=kcal[i];	// 칼로리 더하기
					FlavorSum+=flavor[i];	// 맛 더하기
				}
			}
			// 칼로리의 총합이 칼로리제한을 이하이면서, 맛 총합이 기존맛의 총합을 넘을경우 조건문 수행
			if(KcalSum<=L && FlavorSum>FlavorMax) FlavorMax=FlavorSum;
			return;
		}
		// 수행부
		isSelected[cnt]=true;	// 재료를 선택했을때
		FlavorMax(cnt+1);
		isSelected[cnt]=false;	// 재료를 선택안했을때
		FlavorMax(cnt+1);
	}
}
