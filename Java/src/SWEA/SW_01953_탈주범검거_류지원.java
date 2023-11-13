package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 133ms
 * 메모리 : 26704jb
 * 
 * 풀이방법 :
 * 1. BFS를 적용하여 너비우선탐색으로 탈주범이 있을 수 있는 위치를 탐색한다.
 * 2. BFS를 적용할 때, 탐색중인 배열의 인덱스의 값에 따라 다음 탐색 위치가 결정된다. 이것만 적용하면 끝이다.
 */
// 1번 상하좌우		pipe1 = {0, 1, 2, 3}
// 2번 상,하 		pipe2 = {0, 1, 5, 5}
// 3번 좌,우  		pipe3 = {2, 3, 5, 5}
// 4번 상,우		pipe4 = {0, 3, 5, 5}
// 5번 우,하		pipe5 = {3, 1, 5, 5}
// 6번 하,좌		pipe6 = {1, 2, 5, 5}
// 7번 상,좌		pipe7 = {0, 2, 5, 5}

public class SW_01953_탈주범검거_류지원 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int[] di = {-1, 1, 0, 0, 0};	// 상하좌우그
		int[] dj = {0, 0, -1, 1, 0};	// 상하좌우그
		int[][] pipe = new int[7][];
		
		pipe[0] = new int[] {0, 1, 2, 3};
		pipe[1] = new int[] {0, 1, 4, 4};
		pipe[2] = new int[] {2, 3, 4, 4};
		pipe[3] = new int[] {0, 3, 4, 4};
		pipe[4] = new int[] {1, 3, 4, 4};
		pipe[5] = new int[] {1, 2, 4, 4};
		pipe[6] = new int[] {0, 2, 4, 4};
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			N = Integer.parseInt(ST.nextToken());	// 세로 크기
			M = Integer.parseInt(ST.nextToken());	// 가로 크기
			int R = Integer.parseInt(ST.nextToken());	// 맨홀뚜껑의 세로 위치
			int C = Integer.parseInt(ST.nextToken());	// 맨홀뚜껑의 가로 위치
			int L = Integer.parseInt(ST.nextToken())-1;	// 탈출 후 소요된 시간
			
			int[][] map = new int[N][M];
			for(int i=0; i<N; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}

			// BFS
			Queue<int[]> queue = new ArrayDeque<int[]>();	
			boolean[][] isVisited = new boolean[N][M];		// 방문 위치 배열
			
			queue.add(new int[] {R,C});		// 시작위치 주입
			isVisited[R][C]=true;			// 시작위치 방문 체크
			
			while(!queue.isEmpty() && L>0) {
				int size = queue.size();
				for(int s=0; s<size; s++) {
					int[] crtLo = queue.poll();
					int r = crtLo[0], c = crtLo[1];
					int pipeNum = map[r][c];			// 파이프번호 꺼내기
					int[] direction = pipe[pipeNum-1];	// 파이프번호에 해당하는 파이프방향 배열 꺼내기
					
					for(int pd=0; pd<4; pd++) {
						int d = direction[pd];
						int ni = r+di[d], nj = c+dj[d];
						if(isRange(ni,nj) && !isVisited[ni][nj]) {
							if((d==0 && map[ni][nj]!=1 && map[ni][nj]!=2 && map[ni][nj]!=5 && map[ni][nj]!=6) ||	// 방향이 상일때, 위쪽의 파이프가 하를 받을수 있는 파이프라면 
								(d==1 && map[ni][nj]!=1 && map[ni][nj]!=2 && map[ni][nj]!=4 && map[ni][nj]!=7) ||	// 방향이 하일때, 아래쪽의 파이프가 상을 받을수 있는 파이프라면 
								(d==2 && map[ni][nj]!=1 && map[ni][nj]!=3 && map[ni][nj]!=4 && map[ni][nj]!=5) ||	// 방향이 좌일때, 왼쪽의 파이프가 우를 받을수 있는 파이프라면 
								(d==3 && map[ni][nj]!=1 && map[ni][nj]!=3 && map[ni][nj]!=6 && map[ni][nj]!=7))		// 방향이 우일때, 오른쪽의 파이프가 좌를 받을수 있는 파이프라면 
								continue;
							queue.add(new int[] {ni, nj});	// 
							isVisited[ni][nj] = true;
						}
					}
				}
				L-=1;	// 시간 1 단축
			}
			
			int sum=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++)
					if(isVisited[i][j]) sum+=1;
			}
			System.out.println("#" + t + " " + sum);
		}
	}
	
	public static boolean isRange(int i, int j) {
		if(i<0 || N<=i) return false;
		if(j<0 || M<=j) return false;
		return true;
	}
}
