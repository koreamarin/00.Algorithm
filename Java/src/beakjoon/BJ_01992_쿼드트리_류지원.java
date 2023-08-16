package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
		divided(bnImg);
		System.out.println(SB);
	}
	
	public static int divided(int[][] bnImg) {	
		int S=bnImg.length;
		
		// 기저조건
		if(S==1) return bnImg[0][0];

		// 유도파트.
		int HS=S/2;
		int[][] LTbnImg=new int[HS][HS];
		int[][] RTbnImg=new int[HS][HS];
		int[][] LBbnImg=new int[HS][HS];
		int[][] RBbnImg=new int[HS][HS];
		
		for(int i=0; i<HS; i++) {
			LTbnImg[i]=Arrays.copyOfRange(bnImg[i], 0, HS);
			RTbnImg[i]=Arrays.copyOfRange(bnImg[i], HS, S);
			LBbnImg[i]=Arrays.copyOfRange(bnImg[i+HS], 0, HS);
			RBbnImg[i]=Arrays.copyOfRange(bnImg[i+HS], HS, S);
		}
		
		SB.append("(");
		divided(LTbnImg);
		divided(RTbnImg);
		divided(LBbnImg);
		divided(RBbnImg);
		SB.append(")");

		
	}
	
	
	
}

