package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 147ms
 * 메모리 : 27740kb
 * 
 * 풀이방법 : DP를 사용하였다.
 */

public class D3_03307_최장증가부분수열_류지원 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        StringBuffer sb = new StringBuffer();
        
        int T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
        	int N=Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] dp = new int[N];

            // 수열 입력받기
            ST=new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(ST.nextToken());
            
            int max=0;
            Arrays.fill(dp, 1);							// 초기값, dp의 모든 원소에 전부 1 할당
            
            for (int i=1; i<N; i++) {
                for(int j=0; j<i; j++) { 				// 현재 참조하고있는 i보다 원소번호가 작은 곳까지 dp를 순회하기 위한 반복문
                    if (arr[j]<arr[i]) 					// 현재 참조하고 있는 dp[i]의 원소값이 i이하의 원소들보다 클때,
                    	if(dp[i]<=dp[j]) 				// 전 dp값이 현재 dp값보다 크거나 같으면 (즉, 갱신되고 있는 현재 dp가 전 dp보다 작다면)
                    		dp[i]=dp[j]+1;				// dp[i]는 전dp값인 dp[j]보다 +1 큰 수를 할당
                }
                if(dp[i]>max) max=dp[i];		// dp의 모든 원소중 가장 큰 수를 max에 저장
            }
            System.out.println("#" + t + " " + max);
        }
    }
}