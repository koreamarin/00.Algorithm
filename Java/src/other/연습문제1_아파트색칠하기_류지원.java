package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 류지원
 * 풀이방법 : 
 * f(n) = (f(n-1)의 맨 위 노랭이 개수 * 2) + (f(n-1)의 맨 위 파랭이 개수)
 * 이 점화식을 세웠다. 그리고 여러번 재귀가 일어나지 않도록 각 계산된 값들을 배열에 저장하여 DP방식으로 풀었다.
 */

public class 연습문제1_아파트색칠하기_류지원 {
	static long[][] memo;				// 각 케이스의 꼭대기 층의 파란색 지붕과 노란색 지붕의 개수를 저장할 배열
	static boolean[] memochecked;		// memo의 같은 원소번호가 계산이 된 값인지 아닌지 표시하는 용도의 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new long[N+1][2];
		memochecked = new boolean[N+1];
		memo[0][0] = memo[0][1] = 1;
		memochecked[0]=true;
		long[] F = fibo(N);	// 메모리제이션 안쓴 메서드.
		System.out.println("메모 안쓴거 " + (F[0] + F[1]));
		
		long[] m = memory(N-1);	// 메모리제이션 쓴 메서드.
		System.out.println("메모    쓴거 " +  (m[0] + m[1]));
		
	}
	
	private static long[] fibo(int n) {
		if(n<2) return new long[] {1,1};
		long[] F = fibo(n-1);
		long B = F[1];
		long Y = F[1]+F[0];
		return new long[] {B,Y};
	}

	private static long[] memory(int n) {
		if(!memochecked[n]) {
			long[] M = memory(n-1);
			memo[n]= new long[] {M[1], M[0]+M[1]};
			memochecked[n]=true;
		}
		return memo[n];
	}
}
