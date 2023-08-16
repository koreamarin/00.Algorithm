package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 풀이방법:
 * 분할정복을 이용하여 이차원배열을 4조각으로 분할하여,
 * 분할된 배열이 조건에 해당되는지 안되는지 비교하며 나간다.
 */
public class BJ_01992_쿼드트리_류지원 {
	static StringBuilder SB=new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] bnImg=new int[N][N];
		for(int i=0; i<N; i++) {
			String Line=br.readLine();
			for(int j=0; j<N; j++) bnImg[i][j]=Line.charAt(j)-48;
		}
		divided(bnImg);		// 분할정복 시작
		System.out.println(SB);	// 문자열 출력
	}
	
	public static void divided(int[][] bnImg) {
		int S=bnImg.length;	// 배열의 크기
		// 유도파트.
		int sum=0;			// sum은 현재 배열이 어떻게 이루어졌는지 비교하게 될 변수
		for(int i=0; i<S; i++) for(int j=0; j<S; j++) sum+=bnImg[i][j];	// 배열 원소의 모든 숫자를 더하기.

		if(sum==0) SB.append(0);				// 유도파트 & 기저조건, sum이 0이면 모두 하얀색인 것임. 0을 출력
		else if(sum==S*S) SB.append(1);			// 유도파트 & 기저조건, sum이 1이면 모두 검정색인 것임. 1을 출력
		else {									// 유도파트, sum이 0과 1 모두 아니면 하얀색과 검정색이 섞인 것이므로 아래 분할정복 시작.
			int HS=S/2;							// size를 반으로 나눔
			int[][] LTbnImg=new int[HS][HS];	// 배열의 2사분면쪽을 배열로 만듦
			int[][] RTbnImg=new int[HS][HS];	// 배열의 1사분면쪽을 배열로 만듦
			int[][] LBbnImg=new int[HS][HS];	// 배열의 3사분면쪽을 배열로 만듦
			int[][] RBbnImg=new int[HS][HS];	// 배열의 4사분면쪽을 배열로 만듦

			for(int i=0; i<HS; i++) {
				LTbnImg[i]=Arrays.copyOfRange(bnImg[i], 0, HS);	// 배열의 2사분면쪽 값을 채움
				RTbnImg[i]=Arrays.copyOfRange(bnImg[i], HS, S);			// 배열의 1사분면쪽 값을 채움
				LBbnImg[i]=Arrays.copyOfRange(bnImg[i+HS], 0, HS);	// 배열의 3사분면쪽 값을 채움
				RBbnImg[i]=Arrays.copyOfRange(bnImg[i+HS], HS, S);		// 배열의 4사분면쪽 값을 채움
			}
			SB.append("(");			// 세세한 파트로 나뉘었으므로 괄호가 필요. 괄호 열기.
			divided(LTbnImg);		// 2사분면 분할정복
			divided(RTbnImg);		// 1사분면 분할정복
			divided(LBbnImg);		// 3사분면 분할정복
			divided(RBbnImg);		// 4사분면 분할정복
			SB.append(")");			// 괄호 닫기.
		}
	}
}

