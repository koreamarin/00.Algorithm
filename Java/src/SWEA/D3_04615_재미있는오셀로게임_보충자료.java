package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_04615_재미있는오셀로게임_보충자료 {
	private static int N;
	private static int[][] b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 30개 테스트케이스
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 보드의 한 변의 길이 N, N은 4, 6, 8 중 하나
			int M = Integer.parseInt(st.nextToken()); // 플레이어가 돌을 놓는 횟수 M 
			b = new int[N+2][N+2]; 
			int halfN = N/2;
			b[halfN][halfN] = b[halfN+1][halfN+1] = 2;
			b[halfN][halfN+1] = b[halfN+1][halfN] = 1;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken()); 
				int c = Integer.parseInt(st.nextToken()); 
				int color = Integer.parseInt(st.nextToken()); 
				go(r,c,color);
			}
			sb.append("#").append(testCase).append(" ").append(count()).append("\n");
		} // end of for testCase 
		System.out.print(sb.toString());
	} // end of main
	private static int[] dr = {-1,-1,-1, 0, 1, 1, 1, 0}; // 좌상을 시작으로 시계방향  
	private static int[] dc = {-1, 0, 1, 1, 1, 0,-1,-1};  

	public static void go(int r, int c, int color) {
		b[r][c] = color;
		int diffColor = 3-color; 
		for (int i = 0; i < dr.length; i++) {
			if (b[r+dr[i]][c+dc[i]] != diffColor) continue;
			int cnt = 0; 
			for (int j = 2; ; j++) {
				if (b[r+dr[i]*j][c+dc[i]*j] == color) { 
					cnt = j-1; 
					break;
				} else if (b[r+dr[i]*j][c+dc[i]*j] == 0) {
					break;
				}
			}
			for (int j = 1; j <= cnt; j++) {
				b[r+dr[i]*j][c+dc[i]*j] = color;
			}
		}
	}
	public static String count() {
		int[] cnt = new int[3];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt[b[i][j]]++;
			}
		}
		return cnt[1] + " " + cnt[2];
	}
} // end of class