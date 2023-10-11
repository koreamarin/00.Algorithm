package SWEA;

import java.io.*;
import java.util.*;
/**
 * 직접안품. 보충수업자료
 */
public class SW_05644_무선충전_보충자료{
	static int[] dx={0,0,1,0,-1};//무상우하좌 : 문제 그대로 사용
	static int[] dy={0,-1,0,1,0};
	static int M,bcCnt,bc[][],A[],pathA[],B[],pathB[];
	
	public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_d9_5644.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=null;
		int T=Integer.parseInt(br.readLine());		
		for(int tc=1; tc<=T; tc++){
			st=new StringTokenizer(br.readLine()," ");
			M=Integer.parseInt(st.nextToken()); //총 이동시간 
			bcCnt=Integer.parseInt(st.nextToken()); // BC 개수
			
			A=new int[]{1,1};
			B=new int[]{10,10};
			
			pathA=new int[M+1];
			pathB=new int[M+1];
			StringTokenizer stA=new StringTokenizer(br.readLine()," ");
			StringTokenizer stB=new StringTokenizer(br.readLine()," ");
			for(int i=1; i<=M; i++){
				pathA[i]=Integer.parseInt(stA.nextToken());
				pathB[i]=Integer.parseInt(stB.nextToken());
			}
			
			bc=new int[bcCnt][4];
			for(int i=0; i<bcCnt; i++){
				st=new StringTokenizer(br.readLine()," ");
				bc[i][0]=Integer.parseInt(st.nextToken()); // X
				bc[i][1]=Integer.parseInt(st.nextToken()); // Y
				bc[i][2]=Integer.parseInt(st.nextToken()); // 충전 범위 Coverage
				bc[i][3]=Integer.parseInt(st.nextToken()); // 성능 Performance
			}
			sb.append("#").append(tc).append(" ").append(move()).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	static int move(){
		int total=0;
		for(int t=0; t<=M; t++){
			A[0]+=dx[pathA[t]]; A[1]+=dy[pathA[t]];
			B[0]+=dx[pathB[t]]; B[1]+=dy[pathB[t]];
			total+=getMaxCharge();
		}
		return total;
	}
	static int getMaxCharge(){ // 중복순열 3ㅠ2=3^2=9 x  0  1  2
		int max=0;                                 // 0 00 01 02
		for(int a=0; a<bcCnt; a++) {               // 1 10 11 12
			for(int b=0; b<bcCnt; b++) {           // 2 20 21 22
				int sum=0;
				int amountA=check(a,A[0],A[1]);
				int amountB=check(b,B[0],B[1]);
				if(a!=b) sum=amountA+amountB;
				else     sum=Math.max(amountA,amountB);
				max=Math.max(max,sum);
			}
		}
		return max;
	}
	static int check(int a,int x,int y){ // 거리로 충전량 체크
		return Math.abs(bc[a][0]-x)+Math.abs(bc[a][1]-y)<=bc[a][2]? bc[a][3]:0;
	}
}