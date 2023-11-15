package SWEA;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW_05650_핀볼게임_보충자료 {
	private static int[] dr = {-1, 1, 0, 0}; // 0상, 1하, 2좌, 3우
	private static int[] dc = { 0, 0,-1, 1};
	private static int[][] blockChangeDir = { // 블록을 부딪혔을때 바뀔 방향, [블록번호][0상, 1하, 2좌, 3우]
			{}, // 0 번 블록 없음
			{1,3,0,2}, // 1번 블록 
			{3,0,1,2}, // 2번 블록
			{2,0,3,1}, // 3번 블록
			{1,2,3,0}, // 4번 블록
			{1,0,3,2}, // 5번 블록
	};
	private static int N;
	private static int[][] map;
	private static int[][] wormhole;
	static int sr;
	static int sc;
	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int TC = scan.nextInt();
		for (int testCase = 1; testCase <= TC; testCase++) { // 50개 테스트케이스
			N = scan.nextInt(); 
			
			map = new int[N+2][N+2];
			for (int i = 0; i < map.length; i++) {
				map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 5; 
			} 
			
			wormhole = new int[11][4]; 
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					int val = map[r][c] = scan.nextInt(); 
					if (6 <= val) {
						if(wormhole[val][0] == 0) {
							wormhole[val][0] = r;
							wormhole[val][1] = c;
						} else { 
							wormhole[val][2] = r;
							wormhole[val][3] = c;
						}
					}
				}
			}
			int max = 0;
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (map[r][c] == 0) {
						for (int dir = 0; dir < 4; dir++) { 
							sr = r; sc = c;
							int point = go(r, c, dir, 0);
							if (max < point) max = point;
						}
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	private static int go(int r, int c, int dir, int point) {
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		int val = map[nr][nc];
		
		if (sr == nr && sc == nc || val == -1) {
			return point;
		} else if (val == 0) { 
			return go (nr, nc, dir, point);
		} else if (1 <= val && val <= 5) { 
			dir = blockChangeDir[val][dir];
			return go (nr, nc, dir, point + 1); 
		} else { 
			if (wormhole[val][0] == nr && wormhole[val][1] == nc) {
				nr = wormhole[val][2]; nc = wormhole[val][3];
			} else {
				nr = wormhole[val][0]; nc = wormhole[val][1];
			}
			return go (nr, nc, dir, point);
		}
	}
} // end of class
