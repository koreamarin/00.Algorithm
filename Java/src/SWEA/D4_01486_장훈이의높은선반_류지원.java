package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 20604KB
 * 시간 : 165ms
 * 풀이방법 : 
 * 1. 부분집합을 사용하여 모든 경우의 수에서 가장 크기차이가 많이 나지 않는 값을 찾아내었다.
 */

public class D4_01486_장훈이의높은선반_류지원 {
	static int N, B, min;
	static int[] height;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			N = Integer.parseInt(ST.nextToken());		// N명의 점원 (점원 수)
			B = Integer.parseInt(ST.nextToken());		// 선반의 높이
			min = Integer.MAX_VALUE;					// 최소값 초기화
			height = new int[N];						// 각 점원들의 키 배열
			isSelected = new boolean[N];				// 점원이 선택되었는지 아닌지 체크할 배열
			ST = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) height[i] = Integer.parseInt(ST.nextToken());
			subset(0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	// 부분집합 메서드
	public static void subset(int cnt) {
		// 기저조건, 각 점원들 수만큼 선택을 완료하였다면 기저조건실행하여 필요한 연산 수행
		if(cnt==N)	{
			int sum=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sum+=height[i];
				}
			}
			if(sum>=B) min=Math.min(min, sum-B);
			return;
		}
		// 운용조건
		isSelected[cnt]=true;
		subset(cnt+1);
		isSelected[cnt]=false;
		subset(cnt+1);
	}
}
