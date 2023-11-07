package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_05656_벽돌깨기_보충자료 {
	private static int N;
	private static int W;
	private static int H;
	private static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 구슬 쏘는 횟수 N, 1 ≤ N ≤ 4
			W = Integer.parseInt(st.nextToken()); // W, 2 ≤ W ≤ 12
			H = Integer.parseInt(st.nextToken()); // H, 2 ≤ H ≤ 15
			int[][] m = new int[H+1][W]; 
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < W; j++, index += 2) {
					m[i][j] = s.charAt(index) - '0'; // 벽돌들의 정보, 벽돌은 숫자 1 ~ 9, 0 빈공간
					if (m[i][j] > 0) m[H][j]++; 
				}
			}
			min = 0;
			for (int i = 0; i < W; i++) {
				min += m[H][i];
			}
			gogo(0, m, min);
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	
	
	public static void gogo(int step, int[][] originM, int block) {
		if (min > block) {
			min = block;
		}
		if (step == N) {
			return;
		}
		for (int col = 0; col < W; col++) {
			if (originM[H][col] == 0) continue;
			int[][] m = copyMap(originM);

			int row = 0;
			while(m[row][col]==0) row++; 
			Queue<int[]> q = new LinkedList<int[]>();
			if (m[row][col] > 1) {
				q.offer(new int[] {row, col, m[row][col]}); 
			}
			m[row][col] = 0;
			m[H][col]--;
			
			while(q.size() > 0) {
				int[] temp = q.poll();
				int r = temp[0];
				int c = temp[1];
				int num = temp[2];
				for (int i = Math.max(c-(num-1),0), limit = Math.min(c+(num-1), W-1) ; i <= limit ; i++) {
					if (m[r][i] == 0) continue;
					if (m[r][i] > 1) {
						q.offer(new int[] {r, i, m[r][i]});
					}
					m[r][i] = 0;
					m[H][i]--;
				}
				for (int i = Math.max(r-(num-1),0), limit = Math.min(r+(num-1), H-1) ; i <= limit ; i++) {
					if (m[i][c] == 0) continue;
					if (m[i][c] > 1) {
						q.offer(new int[] {i, c, m[i][c]});
					}
					m[i][c] = 0;
					m[H][c]--;
				}
			} // end of while
			for (int i = 0; i < W; i++) {
				if (m[H][i] == H || m[H][i] == 0) continue; 
				
				int iSpace = H-1;
				while(m[iSpace][i] != 0) iSpace--;
				int iBlock = iSpace - 1;

				while(true) { 
					while(0<=iBlock && m[iBlock][i]==0) iBlock--;
					if (0 > iBlock) break;
					m[iSpace][i] = m[iBlock][i];
					m[iBlock][i] = 0;
					iSpace--;
				}
			}	
			int sum = 0;
			for (int i = 0; i < W; i++) {
				sum += m[H][i];
			}
			gogo(step+1, m, sum);
		} // end of for
	}
	public static int[][] copyMap(int[][] m) {
		int[][] copyM = new int[H+1][W];
		for (int i = 0; i < H+1; i++) {
			System.arraycopy(m[i], 0, copyM[i], 0, W);
		}
		return copyM;
	}
} // end of class
