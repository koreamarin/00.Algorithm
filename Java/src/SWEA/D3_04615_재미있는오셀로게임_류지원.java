package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 19208kb
 * 시간 : 111ms
 * 풀이방법 : 
 * 1. 초기 돌들을 배치한다.
 * 2. 흑과 백이 차레대로 돌들을 배치한다.
 * 3. 배치할 때마다 팔방으로 탐색한다. 상하좌우가 같은 색 돌이거나 비어있는 경우에는 해당 방향 탐색을 중지하고
 * 	다른색 돌이라면 해당 방향으로 더 쭉 나아가서 배치한 색 돌과 같은 색돌이 있다면 해당 경로에 있는 모든 돌들의 색을 배치한 색으로 바꾼다.
 *
 */

public class D3_04615_재미있는오셀로게임_류지원 {
	static int[] di= {-1, -1, 0, 1, 1, 1, 0, -1}, dj= {0, 1, 1, 1, 0, -1, -1, -1}; 	// 상부터 시계방향으로 0~7
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST=new StringTokenizer(br.readLine());
			N = Integer.parseInt(ST.nextToken());	// 보드의 크기 (4,6,8)
			int M = Integer.parseInt(ST.nextToken());	// 플레이어가 돌을 놓는 횟수 M
			int[][] board = new int[N][N];			// 보드 배열
			board[(N/2)-1][(N/2)-1]=board[N/2][N/2]=2;	board[(N/2)-1][N/2]=board[N/2][(N/2)-1]=1;	// 초기 돌 배치
			for(int tr=0; tr<M; tr++) {
				ST = new StringTokenizer(br.readLine());
				int i=Integer.parseInt(ST.nextToken())-1;		// 배치한 행
				int j=Integer.parseInt(ST.nextToken())-1;		// 배치한 열
				int k=Integer.parseInt(ST.nextToken());			// 돌 종류 (1: 흑, 2: 백)
				board[i][j]=k;									// 돌 배치
				for(int d=0; d<8; d++) {						// 배치 후 시계방향으로 탐색하기.
					int ni=i+di[d], nj = j+dj[d];
					if(!isRange(ni, nj)) continue;
					// 탐색한 곳이 비어있거나 같은색 돌일 경우에는 다음거 탐색하기. 탐색한 곳이 다른색 돌일 경우에는 그 방향으로 쭉 탐색하기. 
					if(board[ni][nj]!=(k%2)+1) continue;
					Queue<int[]> StoneLo = new ArrayDeque<>();
					// 그 방향으로 쭉 탐색하면서
					for(int nni=ni, nnj=nj; true; nni+=di[d], nnj+=dj[d]) {
						if(!isRange(nni, nnj)) break;		// 배열을 벗어났다면 queue를 비우고 break
						else if(board[nni][nnj]==0) break;	// 0이 발견됐다면 queue를 비우고 break
						else if(board[nni][nnj]==(k%2)+1) StoneLo.add(new int[] {nni, nnj});	// 배치한색 돌이 아니라면 위치 추가하기.
						else if(board[nni][nnj]==k) {		// 배치한 색 돌을 만나면 탐색방향 전부 배치한 색 돌로 바꾸기
							while(!StoneLo.isEmpty()) {
								int[] crtLo = StoneLo.poll();
								board[crtLo[0]][crtLo[1]]=k;
							}
							break;
						}
					}
				}
			}
			int w=0, b=0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(board[r][c]==1) b++;
					else if(board[r][c]==2) w++;
				}
			}
			System.out.println("#" + t + " " + b + " " + w);
		}
	}
	public static boolean isRange(int i, int j) {
		if(i<0 || N<=i || j<0 || N<=j) return false;
		return true;
	}
}
