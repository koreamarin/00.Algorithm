package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
	static int[] numbers = new int[3], di={0, -1, 0,}, dj= {-1, 0, 1};
	static int N,M,D,terminatedEnemy = 0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		N = Integer.parseInt(ST.nextToken());			// 행의 수
		M = Integer.parseInt(ST.nextToken());			// 열의 수
		D = Integer.parseInt(ST.nextToken());			// 공격거리
		map = new int[N+1][M];
		for(int i=0; i<N; i++) {						// 배열 입력받기
			ST = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j]=Integer.parseInt(ST.nextToken());
		}	
		combination(0,0);
	}
	public static void combination(int cnt, int stt) {
		if(cnt==3) {					// 기저조건
			Arrays.fill(map[N], 0);
			Queue<int[]> queue = new ArrayDeque<int[]>();
			for(int index : numbers) {
				map[N][index]=2;
				queue.add(new int[] {N,index});
			}
			Loop :
			while(!queue.isEmpty()) {
				int size = queue.size();
				int turn=0; turn++;
				for(int s=0; s<size; s++) {
					int[] crtLo = queue.poll();
					int i=crtLo[0], j=crtLo[1];
					for(int d=0; d<3; d++) {
						int ni=i+di[d], nj=j+dj[d];
						if(ni==N) continue;
						if(!isRange(ni, nj)) {
							if()
						}
					}
				}
				if(turn==D) break Loop;
			}
			
			
			
			
			//			for(int i=0; i<N+1; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
			return;
		}
		for(int i=stt; i<M; i++) {
			numbers[cnt]=i;
			combination(cnt+1, i+1);
		}
	}
	
	
	public static boolean isRange(int i, int j) {
		if(i<0 || N<=i) return false;
		if(j<0 || M<=j) return false;
		return true;
	}
	
	
	
}
