package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/** 
 * @author "Ryu jiwon"
 * 시간 : 660ms 
 * 메모리 : 112116 KB
 * 풀이방법 : 
 * 1. combination으로 7개를 뽑음. 동시에 이다솜파 4명 이상인지 확인
 * 2. 그 7개가 인접했는지 확인 (flood fill, BFS)
 */

public class BJ_01941_소문난칠공주_류지원 {
	static int count = 0;
	static char[][] map = new char[5][5];
	static boolean[][] isSelected = new boolean[5][5];
	static boolean[][] isVisited = new boolean[5][5];
	static char[] princess = new char[7];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        combination(0, 0, 0, 0);
        System.out.println(count);
    }
	
	public static void combination(int cnt, int nr, int nc, int sCount) {
		if(cnt==7) {
			if(sCount >= 4) {
				if(bfs()==true) count++;	// 인접했는지 검증, 둘다 통과했다면 count + 1
			}
			return;
		}
		

		for(int r=nr; r<5; r++) {
			for(int c = (r == nr ? nc : 0); c<5; c++) {
				princess[cnt]=map[r][c];
				isSelected[r][c]=true;
				if (map[r][c] == 'S') combination(cnt+1, r, c+1, sCount+1);
				else combination(cnt+1, r, c+1, sCount);
				isSelected[r][c]=false;
			}
		}
	}
	
	public static boolean bfs() {
		int[] start = new int[2];
		int[] cnt = new int[2];
		int nr, nc;
		int visitedCount = 1;
		for(int r=0; r<5; r++) Arrays.fill(isVisited[r], false);
		
		loop :
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				if(isSelected[r][c]) {
					start[0] = r;
					start[1] = c;
					break loop;
				}
			}
		}
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(start);
		isVisited[start[0]][start[1]]=true;
		
		while(!queue.isEmpty()) {
			cnt = queue.poll();
			
			for(int i=0; i<4; i++) {
				nr = cnt[0] + dr[i];
				nc = cnt[1] + dc[i];
				if(0<=nr && nr<5 && 0<=nc && nc<5) {
					if(isSelected[nr][nc]==true && isVisited[nr][nc]==false) {
						isVisited[nr][nc]=true;
						int[] next = {nr, nc};
						queue.add(next);
						visitedCount++;
					}
				}
			}
		}
		if(visitedCount==7) return true;
		return false;
	}
}
