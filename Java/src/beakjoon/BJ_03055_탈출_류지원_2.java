package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/** 
 * @author 류지원
 * 메모리 : 11752KB
 * 시간 : 84ms
 * 풀이방법 : BFS 
 * 1. 물 BFS 먼저 돌리고, 고슴도치 BFS돌리고 
 * 2. 고슴도치가 비버집 위치에 도달했다면 turn 출력하고 종료.
 * 3. queue를 모두 빠져나갈떄까지 도달하지 못했다면 KAKTUS 출력하고 종료
 */

public class BJ_03055_탈출_류지원_2 {
	static char[][] map;
	static int[] di= {-1, 1, 0, 0}, dj= {0, 0, -1, 1};
	static int R, C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		R = Integer.parseInt(ST.nextToken());	// 행 개수
		C = Integer.parseInt(ST.nextToken());	// 열 개수
		int[] houseLo = null;								// 비버 굴 위치
		Queue<int[]> WLo = new ArrayDeque<>();		// 물 위치 큐
		Queue<int[]> GLo = new ArrayDeque<>();		// 고슴도치 위치 큐
		int turn=0;
		
		map=new char[R][C];
		
		for(int r=0; r<R; r++) {
			String S = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c]=S.charAt(c);
				if(map[r][c]=='D') houseLo=new int[] {r,c}; 
				else if(map[r][c]=='*') WLo.add(new int[] {r,c});
				else if(map[r][c]=='S') GLo.add(new int[] {r,c});
			}
		}
		
		while(!WLo.isEmpty() || !GLo.isEmpty()) {
			turn++;
			int size = WLo.size();
			for(int s=0; s<size; s++) {
				int[] WcrtLo = WLo.poll();
				int i=WcrtLo[0], j=WcrtLo[1];
				
				for(int d=0; d<4; d++) {
					int ni=i+di[d], nj=j+dj[d];
					if(isRange(ni, nj)) {
						if(map[ni][nj]=='.' || map[ni][nj]=='S') {
							map[ni][nj]='*';
							WLo.add(new int[] {ni, nj});
						}
					}
				}
			}
			size = GLo.size();
			for(int s=0; s<size; s++) {
				int[] GcrtLo = GLo.poll();
				int i=GcrtLo[0], j=GcrtLo[1];
				for(int d=0; d<4; d++) {
					int ni=i+di[d], nj=j+dj[d];
					if(isRange(ni, nj)) {
						if(map[ni][nj]=='D') {
							System.out.println(turn);
							return;
						}
						else if(map[ni][nj]=='.') {
							map[ni][nj]='S';
							GLo.add(new int[] {ni, nj});
						}
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
	
	public static boolean isRange(int i, int j) {
		if(i<0 || R<=i || j<0 || C<=j) return false;
		return true;
	}
}