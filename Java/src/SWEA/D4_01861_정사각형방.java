package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 30240kb
 * 실행시간 : 287ms
 * 풀이방법 :
 * DFS를 쓰려고 했는데, 각 노드에 딸린 노드가 한개뿐이라서 DFS라고 해도 되는지 모르겠다..
 * 아무튼 재귀를 써서 Depth를 추출했다.
 */

public class D4_01861_정사각형방 {
	
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		// 테스트케이스 T 입력받기
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			// N 입력받기
			int N=Integer.parseInt(br.readLine());
			// 배열 입력받기.
			arr=new int[N][N];
			for(int i=0; i<N; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) arr[i][j]=Integer.parseInt(ST.nextToken());
			}
			
			// 원소마다 DFS 시작.
			int k=0; int max=0; int min=Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					int S=recursion(N,i,j,1);
					if(S>=max) {
						max=S;
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(recursion(N,i,j,1)==max) {
						if(arr[i][j]<min) min=arr[i][j];
					}
				}
			}
			
			System.out.println("#"+t+" "+min+" " +max);
		}
	}
	
	public static int recursion(int N, int i, int j, int sum) {
		int prst=arr[i][j];
		if(j<N-1 && arr[i][j+1]==prst+1) return recursion(N,i,j+1,sum+1);		// 동
		else if(j>0 && arr[i][j-1]==prst+1) return recursion(N,i,j-1,sum+1);	// 서
		else if(i<N-1 && arr[i+1][j]==prst+1) return recursion(N,i+1,j,sum+1);	// 남
		else if(i>0 && arr[i-1][j]==prst+1) return recursion(N,i-1,j,sum+1);	// 북
		return sum;	// 기저조건 : 위 사항에 해당하지 않을 때.
	}
}
