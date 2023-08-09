package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 59524KB
 * 시간 : 488ms
 * 풀이방법 : 따로 알고리즘이 필요없는 구현문제이므로 그냥 풀었다.
 *
 */

public class BJ_16935_배열돌리기3_류지원 {
	static int N;
	static int M;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫번쨰 입력
		StringTokenizer ST = new StringTokenizer(br.readLine());
		N=Integer.parseInt(ST.nextToken());
		M=Integer.parseInt(ST.nextToken());
		int R=Integer.parseInt(ST.nextToken());
		// 두번째 입력 : 배열 입력
		arr=new int[N][M];
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(ST.nextToken());
			}
		}
		// 세번째 입력 : 수행해야하는 연산 번호.
		int[] cal=new int[R];
		ST=new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) cal[i]=Integer.parseInt(ST.nextToken());
		
		// 연산 번호에 대한 연산 수행.
		for(int r=0; r<R; r++) {
			switch (cal[r]) {
				case 1:
					arr=TBreverse();
					break;
				case 2:
					arr=LBreverse();
					break;
				case 3:
					arr=RRotaion();
					break;
				case 4:
					arr=LRotaion();
					break;
				case 5:
					arr=GRRotaion();
					break;
				case 6:
					arr=GLRotaion();
					break;
			}
		}
		
		// 배열 출력
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	
	// 1번 연산 : 상하 반전
	public static int[][] TBreverse() {
		int[][] Rarr=new int[N][M];
		for(int i=0; i<N/2; i++) {
			Rarr[i]=arr[N-i-1];
			Rarr[N-i-1]=arr[i];
		}
		return Rarr;
	}
	
	// 2번 연산 : 좌우 반전
	public static int[][] LBreverse() {
		int[][] Rarr=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				Rarr[i][j]=arr[i][M-j-1];
				Rarr[i][M-j-1]=arr[i][j];
			}
		}
		return Rarr;
	}
	
	// 3번 연산 : 오른쪽 90도 회전
	public static int[][] RRotaion() {
		int[][] Rarr=new int[M][N];
		for(int i=0; i<M; i++) for(int j=0; j<N; j++) Rarr[i][j]=arr[N-1-j][i];
		int swap=M;	M=N; N=swap;
		return Rarr;
	}
	
	// 4번 연산 : 왼쪽 90도 회전
	public static int[][] LRotaion() {
		int[][] Rarr=new int[M][N];
		for(int i=0; i<M; i++) for(int j=0; j<N; j++) Rarr[i][j]=arr[j][M-1-i];
		int swap=M;	M=N; N=swap;
		return Rarr;
	}
	
	// 5번 연산 : 4개 그룹으로 나눠서 1->2, 2->3, 3->4, 4->1번으로 그룹 이동
	public static int[][] GRRotaion() {
		int[][] Rarr=new int[N][M];
		int GN=N/2; int GM=M/2;
		for(int i=0; i<GN; i++) {
			for(int j=0; j<GM; j++) {
				Rarr[i][GM+j]=arr[i][j];		// Group1을 2번쪽으로 이동
				Rarr[GN+i][GM+j]=arr[i][GM+j];	// Group1을 2번쪽으로 이동
				Rarr[GN+i][j]=arr[GN+i][GM+j];	// Group3을 4번쪽으로 이동
				Rarr[i][j]=arr[GN+i][j];		// Group4을 5번쪽으로 이동
			}
		}
		return Rarr;
	}
	
	// 6번 연산 : 4개 그룹으로 나누어서 4->3, 3->2, 2->1, 1->4번으로 그룹 이동.
	public static int[][] GLRotaion() {
		int[][] Rarr=new int[N][M];
		int GN=N/2; int GM=M/2;
		for(int i=0; i<GN; i++) {
			for(int j=0; j<GM; j++) {
				Rarr[GN+i][GM+j]=arr[GN+i][j];	// Group4을 3번쪽으로 이동
				Rarr[i][GM+j]=arr[GN+i][GM+j];	// Group3을 2번쪽으로 이동
				Rarr[i][j]=arr[i][GM+j];		// Group2을 1번쪽으로 이동
				Rarr[GN+i][j]=arr[i][j];		// Group1을 4번쪽으로 이동
			}
		}
		return Rarr;
	}
}
