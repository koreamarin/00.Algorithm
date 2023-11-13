package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 688ms
 * 메모리 : 99496KB
 * 풀이방법 : BFS를 이용한다.
 * 1. map을 모두 순회하여 만약 모두 익어있는 상태이면 0을 출력한다.
 * 2. 모두 익어있는 상태가 아니라면 익어있는 것들을 queue에 넣고 true로 만든다. 
 * 3. queue에서 꺼내가며 상하좌우로 탐색한다. 그중에 true인 것들과 값이 -1이라면 queue에 넣지 않는다. 이 때 size를 사용하여 너비우선탐색의 turn을 카운팅한다.
 * 4. bfs가 끝났다면 모두 true인지 탐색한다. 하나라도 false라면 -1을 출력하고, 너비우선탐색의 turn을 출력한다.
 */

public class BJ_07569_토마토_류지원 {
	static int[] dh = {-1, 1, 0, 0, 0, 0}, di = {0, 0, -1, 1, 0, 0}, dj = {0, 0, 0, 0, -1, 1};
	static int M, N, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		M = Integer.parseInt(ST.nextToken());		// 상자의 열 크기
		N = Integer.parseInt(ST.nextToken());		// 상자의 행 크기
		H = Integer.parseInt(ST.nextToken());		// 상자의 높이
		
		int[][][] box = new int[H][N][M];
		
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) box[h][i][j]=Integer.parseInt(ST.nextToken());
			}
		}
		
		boolean all = true;
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][][] isVisited = new boolean[H][N][M];
		
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(all && box[h][i][j]==0) all=false;
					if(box[h][i][j]==1) {
						queue.add(new int[] {h, i, j});	
						isVisited[h][i][j]=true;
					}
				}
			}
		}
		
		if(all) {
			System.out.println(0);
			return;
		}
		
		int turn=-1;
		
		while(!queue.isEmpty()) {
			int Size = queue.size();
			turn+=1;
			for(int s=0; s<Size; s++) {
				int[] crtLo = queue.poll();
				int h=crtLo[0], i=crtLo[1], j=crtLo[2];
				
				for(int d=0; d<6; d++) {
					if(isRange(h+dh[d], i+di[d], j+dj[d])) {
						if(box[h+dh[d]][i+di[d]][j+dj[d]]==0 && !isVisited[h+dh[d]][i+di[d]][j+dj[d]]) {
							queue.add(new int[] {h+dh[d], i+di[d], j+dj[d]});
							isVisited[h+dh[d]][i+di[d]][j+dj[d]]=true;
						}
					}
				}
			}
		}
		
		for(int h=0; h<H; h++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(box[h][i][j]==0 && !isVisited[h][i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}	
		}
		
		System.out.println(turn);
	}
	
	public static boolean isRange(int h, int i, int j) {
		if(h<0 || H<=h) return false;
		if(i<0 || N<=i) return false;
		if(j<0 || M<=j) return false;
		return true;
	}

}
