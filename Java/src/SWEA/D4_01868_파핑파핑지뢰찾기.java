package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 252ms
 * 메모리 : 45368kb
 * 
 * 풀이방법 : 
 * 1. 0,0부터 N,N까지 Sweep한다.
 * 2. Sweep 과정에 *가 발견되면 주위의 모든 인접한곳에 +1을 해준다.
 * 3. Sweep이 끝난 후, 다시한번 Sweep을 한다.
 * 4. Sweep도중에 0이 발견되면 0에서 BFS를 하고 isVisited를 true로 한다. 이때 click을 1올린다.
 * 5. 다른 숫자가 발견되면 BFS를 더 하지않고 isVisited를 true로 한다.
 * 6. Sweep이 끝나면 isVisited가 false이면서 map이 0이 아닌 숫자인 구간의 개수를 세어 click에 더한다.
 */

public class D4_01868_파핑파핑지뢰찾기 {
	static char[][] map;
	static boolean[][] isVisited;
	static int[] di = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dj = {0, 0, -1, 1, -1, 1, -1, 1};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<T+1; t++) {
			N=Integer.parseInt(br.readLine());	// 맵의 크기
			map = new char[N][N];
			isVisited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {		// 맵상태 입력받기
				String L = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j]=L.charAt(j);
					if(map[i][j]=='.') {
						map[i][j]='0';
					}
				}
			}
			
			for(int i=0; i<N; i++) {		// 맵 완성상태 만들기.
				for(int j=0; j<N; j++) {
					if(map[i][j]=='*') {
						isVisited[i][j]=true;
						for(int d=0; d<8; d++) {
							int ni=i+di[d];	int nj=j+dj[d];
							if(ni>=0 && ni<N && nj>=0 && nj<N) {
								if(map[ni][nj]-'0' >= 0 && map[ni][nj]-'0' <= 9){
									map[ni][nj]+=1;
								}
							}
						}
					}
				}
			}
			
			int click=0;			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='0' && isVisited[i][j]==false) {
						click++;
						BFS(i, j);		// BFS 실행
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(isVisited[i][j]==false) {
						click++;
					}
				}
			}
			System.out.println("#" + t + " " + click);
			
		}
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		isVisited[i][j]=true;
		
		q.offer(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] current=q.poll();
			int qi=current[0]; int qj=current[1];
			
			for(int d=0; d<8; d++) {
				int ni=qi+di[d];	int nj=qj+dj[d];
				if(ni>=0 && ni<N && nj>=0 && nj<N) {
					if(map[ni][nj]=='0' && isVisited[ni][nj]==false) {
						q.offer(new int[] {ni, nj});
					}
					isVisited[ni][nj]=true;
				}
			}
		}	
	}
}
