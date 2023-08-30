package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author 류지원
 * 메모리 : 37308kb
 * 시간 : 128ms
 * 풀이방법 : 
 * 각 숫자마다 연산의 최소값을 배열에 저장해 놓는다.
 * 다음 숫자를 연산할 때, 이전 값을 참조한다.
 * 
 * 3을 나눴을때의 값의 연산최소값 +1
 * 2를 나눴을때의 값의 연산최소값 +1
 * 1을 뺐을때 값의 연산최소값 +1
 * 
 * 이 세개의 경우에서 가장 연산최소값이 낮은것이 현재 연산해야할 번호의 연산최소값이 된다.
 * 
 */

public class BJ_01463_1로만들기_류지원 {
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		dp=new long[X+1];
		Arrays.fill(dp, -1);
		dp[0]=0; dp[1]=0;
		System.out.println(DP(X));
	}
	public static long DP(int n) {
		if(n>1) { 	// n이 1이상일때만, 배열 0번과 1번은 초기값이 주어졌으므로.
			if(dp[n]==-1) {		// dp[n]이 -1일때, 즉 아직 구해지지 않았을때 아래 연산을 수행
				long min=Integer.MAX_VALUE;	// integer 최대값
				if(n%3==0) {		// n이 3으로 나눠질 때
					long case1 = DP(n/3)+1;		// 3으로 나눈 값의 연산값을 불러와서 1더한 값이 3으로 나눴을때의 연산횟수
					if(min > case1) min = case1;	// Min 비교
				}
				if(n%2==0) {		// n이 2로 나눠질 때
					long case2 = DP(n/2) + 1;		// 2로 나눈 값의 연산값을 불러와서 1더한 값이 2로 나눴을때의 연산횟수
					if(min > case2) min = case2;		// Min 비교
				}
				long case3 = DP(n-1)+1;		// 1을 뺐을때의 연산값을 불러와서 1을 더한 값이 -1을 했을때의 연산횟수
				if(min > case3) min = case3;	// Min 비교
				dp[n]=min;		// dp[n]에 최소 연산값 할당
			}
		}
		return dp[n];	// dp[n] 리턴
	}
}
