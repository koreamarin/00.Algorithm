package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 메모리 : 16332kb
 * 시간 : 124ms
 * 
 * 풀이방법 :
 * 분할정복으로 풀이하였다. 
 * 전체가 파란색종이인지, 하얀색종이 확인 후, 파란색종이이거나 하얀색종이이면 카운팅한다.
 * 잡색 종이일경우 4분할 하여 다시 확인한다.
 */

public class BJ_02630_색종이만들기_류지원2 {
	static int Bcount = 0; static int Wcount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) arr[i][j]=Integer.parseInt(ST.nextToken());
		}
		divider(arr, N);
		System.out.println(Wcount+"\n"+Bcount);
	}
	

	public static void divider(int[][] arr, int N) {
		// 색종이 전체가 파란색인지 하얀색인지 확인한다.
		int sum=0;
		for(int i=0; i<N; i++) for(int j=0; j<N; j++) sum+=arr[i][j];
		if(sum==N*N) Bcount++;		// 색종이 전체가 파란색이라면 파란색 카운트 +1
		else if(sum==0) Wcount++;	// 색종이 전체가 하얀색이라면 하얀색 카운트 +1
		else {	// 색종이 전체가 같은색이 아니라면 4조각으로 분할한다.
			int HN = N/2;
			int[][] LTArr = new int[HN][HN];
			int[][] RTArr = new int[HN][HN];
			int[][] LBArr = new int[HN][HN];
			int[][] RBArr = new int[HN][HN];
			for(int n=0; n<HN; n++) {
				LTArr[n]=Arrays.copyOfRange(arr[n], 0, HN);
				RTArr[n]=Arrays.copyOfRange(arr[n], HN, N);
				LBArr[n]=Arrays.copyOfRange(arr[n+HN], 0, HN);
				RBArr[n]=Arrays.copyOfRange(arr[n+HN], HN, N);
			}
			divider(LTArr, HN);
			divider(RTArr, HN);
			divider(LBArr, HN);
			divider(RBArr, HN);
		}
	}
}
