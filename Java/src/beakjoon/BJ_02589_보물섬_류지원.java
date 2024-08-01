package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 시간 : 448ms
 * 메모리 : 162496KB
 * 풀이방법 : 
 * 1. 모든 map을 iterate하여 육지의 위치를 모두 찾아 리스트에 넣는다.
 * 2. 리스트에서 육지의 위치를 꺼내와서 flood fill하며 상하좌우를 몇번 반복했는지 카운팅한다.
 * 3. 리스트의 모든 원소에서 독같이 상하좌우를 반복하며 flood fill하는 작업을 거치며 카운팅을 한다.
 * 4. 카운트가 가장 큰 것을 찾으면 정답
 */

public class BJ_02589_보물섬_류지원 {
	static boolean[][] isVisited;
	static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};	// 상, 하, 좌, 우
	static int R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(ST.nextToken());
		C = Integer.parseInt(ST.nextToken());
		
		boolean[][] map = new boolean[R][C];
		isVisited = new boolean[R][C];
		
		List<int[]> land = new ArrayList<int[]>();
		
		for(int r=0; r<R; r++) {
			String S = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c]= S.charAt(c)=='W' ? true : false;	// 바다면 true, 육지면 false 
			}
		}
		
		// 1번 과정
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==false) {
					int[] location = {r,c};
					land.add(location);
				}
			}
		}
		int max=0;
		int cnt;
		
		// 2,3,4번 과정
		for(int i=0; i<land.size(); i++) {
			for(int r=0; r<R; r++) Arrays.fill(isVisited[r], false);	// 방문 배열 초기화
			
			cnt=0;
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			int[] firstLo = land.get(i);
			isVisited[firstLo[0]][firstLo[1]]=true;
			
			q.add(firstLo);
			
			while(!q.isEmpty()) {
				int qSize = q.size();
				for(int a=0; a<qSize; a++) {
					int[] crtLo = q.poll();
					
					for(int d=0; d<4; d++) {
						int nr = crtLo[0] + dr[d];
						int nc = crtLo[1] + dc[d];
						
						if(isRange(nr, nc) && !isVisited[nr][nc] && !map[nr][nc]) {	// 범위 안 and 방문 X and 육지일 때
							isVisited[nr][nc]=true;
							q.add(new int[] {nr, nc});
						}
					}
				}
				cnt++;
			}
			max=Math.max(max, cnt);
		}
		System.out.println(max-1);
	}
	
	public static boolean isRange(int r, int c) {
		if(r<0 || R<=r || c<0 || C<=c) return false;
		return true;
	}
}