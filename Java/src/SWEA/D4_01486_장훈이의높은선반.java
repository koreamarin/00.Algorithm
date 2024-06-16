package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 166ms
 * 메모리 : 27528kb
 * 
 * 풀이방법 : 
 * 1. 직원들의 키를 부분집합하고 true인 것들을 더하여 선반보다 큰 값중에 최소값을 찾는다.
 * 2. 직원들의 키의 합중의 최소값과 선반의 높이를 뺀다.
 */

public class D4_01486_장훈이의높은선반 {
	static int N, B, min;
	static boolean[] isSelected;
	static int[] H;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());		// 테스트 수
		
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			N = Integer.parseInt(ST.nextToken());		// 점원수
			B = Integer.parseInt(ST.nextToken());		// 필요한 높이	
			isSelected=new boolean[N];
			ST = new StringTokenizer(br.readLine());		// 점원들의 키
			H = new int[N];
			for(int i=0; i<N; i++) 
				H[i]=Integer.parseInt(ST.nextToken());
			min=Integer.MAX_VALUE;
			subset(0);
			System.out.println("#"+t+ " " + (min-B));
		}
	}
	
	public static void subset(int cnt) {
		if(cnt==N) {
			int sum=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) sum+=H[i];
			}
			if(sum>=B) min=Math.min(sum, min);
			return;
		}
		isSelected[cnt]=false;
		subset(cnt+1);
		isSelected[cnt]=true;
		subset(cnt+1);
	}
}
