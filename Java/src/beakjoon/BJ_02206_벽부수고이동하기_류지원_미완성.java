package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_02206_벽부수고이동하기_류지원_미완성 {
	static boolean[][] isVisited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(ST.nextToken());
		M = Integer.parseInt(ST.nextToken());
		
		boolean[][] map = new boolean[N][M];
		List<int[]> wall = new ArrayList<int[]>();
		
		int min=Integer.MAX_VALUE;
		
		for(int n=0; n<N; n++) {
			String s = br.readLine();
			
			for(int m=0; m<M; m++) {
				if(s.charAt(m)-'0'==0) {
					map[n][m]=false;
				}
				else {	// 벽이면 true
					map[n][m]=true;
					wall.add(new int[] {n, m});
				}
			}
		}
		int wallSize = wall.size();
		for(int a=0; a<wallSize; a++) {
				// 벽 부수고, BFS로 N,M까지 최단거리 찾고, 벽 복구하는 과정을 iter
				int wr = wall.get(a)[0];
				int wc = wall.get(a)[1];
				int validCount = 0;
				for(int d=0; d<4; d++) {
					int nr = wr+dr[d], nc = wc+dc[d];
					if(isRange(nr, nc) && !map[nr][nc]) validCount++;
				}
				if(validCount<2) continue; 
				map[wr][wc]=false;	// 벽 부셔서 길로 만듦. 벽 부시는 조건은 벽의 상하좌우 2군데 이상이 길이어야 함.
				isVisited = new boolean[N][M];	// 방문 초기화
				// 코딩 시작
				Queue<int[]> q = new ArrayDeque<int[]>();
				q.add(new int[] {0,0});
				isVisited[0][0] = true;
				
//				System.out.println("\n이쪽 벽 뚫음 " + r + "," + c);
				
				int count = 0;
				while(!q.isEmpty() ) {
					int qSize = q.size();
					for(int i=0; i<qSize; i++) {
						int[] crt = q.poll();
						for(int d=0; d<4; d++) {
							int nr = crt[0]+dr[d];
							int nc = crt[1]+dc[d];
							if(isRange(nr, nc)) {
								if(!map[nr][nc] && !isVisited[nr][nc]) {
									q.add(new int[] {nr, nc});
									isVisited[nr][nc]=true;
								}
							}
						}
					}
					count++;
//					System.out.println("방문 배열");
//					for(int r1=0; r1<N; r1++) {
//						for(int c1=0; c1<M; c1++) {
//							System.out.print(isVisited[r1][c1]+ " ");
//						}
//						System.out.println();
//					}
				}
//				System.out.println(count + "번만에 도착");
				
//				System.out.println("방문 배열");
//				for(int r1=0; r1<N; r1++) {
//					for(int c1=0; c1<M; c1++) {
//						System.out.print(isVisited[r1][c1]+ " ");
//					}
//					System.out.println();
//				}
//				
//				System.out.println("벽 배열");
//				for(int r1=0; r1<N; r1++) {
//					for(int c1=0; c1<M; c1++) {
//						System.out.print(map[r1][c1]+ " ");
//					}
//					System.out.println();
//				}
				
				if(isVisited[N-1][M-1])	min = Math.min(min, count);
				// 코딩 끝
				map[wr][wc]=true;	// 다시 벽으로 만듦.
		}
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);

	}
	
	public static boolean isRange(int r, int c) {
		if(r<0 || N<=r || c<0 || M<=c) return false;
		return true;
	}

}
