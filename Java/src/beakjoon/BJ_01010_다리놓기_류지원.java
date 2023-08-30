package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 12372kb
 * 시간 : 112ms
 * 풀이방법1 : 문제가 조합의 수를 구하는 문제이므로 조합의 수 계산식 nCr=n!/(r!*(n-r)!) 공식을 사용하였다.
 * 풀이방법2 : 파스칼 삼각형을 DP로 만들어서 배열에 nCm에 해당하는 배열을 만든 후, nCm을 출력함.
 */
public class BJ_01010_다리놓기_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<T+1; t++) {
            ST = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(ST.nextToken());	// StringTokenizer의 첫번째 문자열을 정수형으로바꾼 후 M에 저장
            int M = Integer.parseInt(ST.nextToken());	// StringTokenizer의 두번째 문자열을 정수형으로바꾼 후 N에 저장
            System.out.println(DP(M,N));				// DP로 파스칼 삼각형형태의 배열을 만들어 조합배열을 만든 후, N,M에 해당하는 경우의 수 출력.
//            System.out.println(Math.round(factorial(M)/(factorial(N)*factorial(M-N)))); // 조합을 나열할 수 있는 함수 실행
        }
    }
    
    public static int DP(int N, int M) {
    	int[][] B = new int[N+1][M+1];
		for(int i=0; i<=N; i++) {
			for(int j=0, end=Math.min(i, M); j<=end; j++) {
				if(j==0 || i==j) B[i][j]=1;
				else B[i][j] = B[i-1][j-1] + B[i-1][j];
			}
		}
		return B[N][M];
	}

    public static double factorial(int F) {
        double A=1;
        for(int i=2; i<F+1; i++) A*=i;
        return A;
    }
}