package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author 류지원
 * 풀이 방법 : 
 * f(n) = (f(n-1) + f(n-2)) *2 라는 점화식을 세웠다.
 *  이 점화식을 세웠다. 그리고 여러번 재귀가 일어나지 않도록 각 계산된 값들을 배열에 저장하여 DP방식으로 풀었다.
 */

public class 연습문제2_막대색칠하기_류지원 {
	static long[] memo;		// 메모리제이션 저장할 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo=new long[N+1];
		Arrays.fill(memo, -1);		// -1로 채운다. 값이 -1인 원소번호는 계산이 되지 않은 것이다.
		memo[0]=2;			// 초기값
		memo[1]=5;			// 초기값
		System.out.println(fibo(N));
	}
	public static long fibo(int n) {
		if(n<2) return memo[n];			
		if(memo[n]==-1) memo[n]=(fibo(n-1)*2)+(fibo(n-2)*2);	// 점화식 만든거.
		return memo[n];
	}
}
