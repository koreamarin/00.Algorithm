package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 12108KB, 시간 : 84ms
 * 풀이방법 : 점화식을 세워서 DP로 풀었다.
 * 첫번쨰 집을  빨강으로 했을때의 최소값, 그린으로 했을때의 최소값, 블루로 헀을때의 최소값을 뽑아서 세가지중 가장 작은 값을 출력하였다.
 * 첫번쨰 집의 각 색상별로 최소값을 구하기 위해서 첫번쨰 색상을 고른 후의 전 집 색깔과 다른 색깔을 골랐을때의 경우들을 더하여 dp배열에 저장하였다.
 */

public class BJ_01149_RGB거리_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int N = Integer.parseInt(br.readLine());
        int paint[][] = new int[N+1][3];
        int dp[][] = new int[N+1][3];
        int MIN = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) paint[i][j]=Integer.parseInt(ST.nextToken());
        }
        for(int i=1; i<=N; i++) {
            for(int j=0; j<3; j++) {
                int min = Integer.MAX_VALUE;
                for(int k=0; k<3; k++) {
                    if(j==k) continue;
                    min=(min>dp[i-1][k])? dp[i-1][k] : min;
                }
                dp[i][j] = min + paint[i][j];
            }
        }
        for(int i=0; i<3; i++) MIN=(MIN>dp[N][i]) ? dp[N][i] : MIN;
        System.out.println(MIN);
    }
}