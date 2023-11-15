package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 24464KB
 * 시간 : 252ms
 * 풀이방법 : BFS 누적합을 사용하였다.
 * 1. 상하좌우를 탐색하며 더 작은 합이 발생할 경우 그 경우를 큐에 추가한다.
 *
 */

public class BJ_04485_녹색옷입은애가젤다지_류지원 {
	static int N;
	static int[] di= {-1, 1, 0, 0}, dj= {0, 0, -1, 1};	// 상하좌우
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map = new int[125][125];
	static int[][] PrefixSum = new int[125][125];
	
	public static void main(String[] args) throws IOException {
		StringTokenizer ST;
		int turn=0;
		while(inputN()) {
			turn+=1;
			for(int i=0; i<N; i++) {
				ST = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) map[i][j]=Integer.parseInt(ST.nextToken());
			}
			int total = bfs();
			System.out.println("Problem " + turn + ": " + total);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=0;
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					PrefixSum[i][j]=0;
				}
			}
		}		
	}
	
	public static boolean inputN() throws IOException {
		N=Integer.parseInt(br.readLine());
		if(N==0) return false;
		return true;
	}
	
	public static int bfs() {
		int INF = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				PrefixSum[i][j]=INF;
			}
		}
		PrefixSum[0][0]=map[0][0];
		
		Queue<int[]> queue = new ArrayDeque<>();
		int[] addQueue = {0,0};
		queue.add(addQueue);
		
		while(!queue.isEmpty()) {
			int[] cLo = queue.poll();
			int ci=cLo[0], cj=cLo[1];
			
			for(int d=0; d<4; d++) {
				int ni=ci+di[d], nj=cj+dj[d];
				if(isRange(ni, nj) && PrefixSum[ni][nj]>PrefixSum[ci][cj]+map[ni][nj]) {
					PrefixSum[ni][nj]=PrefixSum[ci][cj]+map[ni][nj];
					queue.add(new int[] {ni,nj});
				}
			}
		}
		return PrefixSum[N-1][N-1];
	}
	
	public static boolean isRange(int i, int j) {
		if(i<0 || N<=i || j<0 || N<=j) return false;
		return true;
	}
}
