package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시뮬레이션, BFS
 * 
 */
public class SW_01953_탈주범검거_보충자료 {
	private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	private static int[] dc = { 0, 0,-1, 1};
	/** 터널 구조물 타입 */
	private static int[][] dir = {	{}, // 0, 터널 없음
									{0,1,2,3}, // 1, 상하좌우
									{0,1}, // 2, 상하
									{2,3}, // 3, 좌우
									{0,3}, // 4, 상우
									{1,3}, // 5, 하우
									{1,2}, // 6, 하좌
									{0,2}};// 7, 상좌
	/** 연결가능한지 체크 [상하좌우0~3][터널구조물번호0~7] */
	private static boolean[][] check = {{false,true,true,false,false,true,true,false}, // 상 : 하 존재해야함
										{false,true,true,false,true,false,false,true}, // 하 : 상 존재해야함
										{false,true,false,true,true,true,false,false}, // 좌 : 우 존재해야함
										{false,true,false,true,false,false,true,true}};// 우 : 좌 존재해야함

	public static class Pos {
		int r,c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public String toString() {
			return "[" + r + "," + c + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 50개 테스트케이스
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 지하 터널의 세로 N, (5 ≤ N, M ≤ 50)
			int M = Integer.parseInt(st.nextToken()); // 지하 터널의 가로 M, (5 ≤ N, M ≤ 50)
			int R = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 위치 세로 R, (0 ≤ R ≤ N-1, 0 ≤ C ≤ M-1)
			int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑 위치 가로 C, (0 ≤ R ≤ N-1, 0 ≤ C ≤ M-1)
			int L = Integer.parseInt(st.nextToken()); // 탈출 후 소요된 시간 L, (1 ≤ L ≤ 20)
			
			int[][] map = new int[N][M]; // 지하 터널 지도
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < M; j++, index += 2) {
					map[i][j] = s.charAt(index) - '0'; // 1~7 터널 구조물 타입, 0 터널 없음
				}
			}
			
			int cnt = 0;
			boolean[][] visited = new boolean[N][M];
			Queue<Pos> q = new LinkedList<Pos>();
			cnt++;
			visited[R][C] = true;
			q.offer(new Pos(R,C));
			while(--L > 0) { // 큐는 이미 비었는데, 이동회수가 남아있는 경우 문제가 없는가?
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Pos pos = q.poll();
					int type = map[pos.r][pos.c];
					for (int j = 0; j < dir[type].length; j++) {
						int nr = pos.r + dr[dir[type][j]];
						int nc = pos.c + dc[dir[type][j]];
						if (0<=nr && nr<N && 0<=nc && nc<M && check[dir[type][j]][map[nr][nc]] &&!visited[nr][nc]) {
							cnt++;
							visited[nr][nc] = true;
							q.offer(new Pos(nr,nc));
						}
					}
				}
			}
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
} // end of class







