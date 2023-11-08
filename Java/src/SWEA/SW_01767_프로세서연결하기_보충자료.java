package SWEA;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 최대한 많은 코어를 전원(외곽)에 연결하자, 전선의 길이의 합을 출력
 * 가능한 방법이 많다면, 전선의 길이의 합이 최소인 것을 선택해서 출력
 * 
 * 각 코어의 좌표를 매번 탐색해서 얻는 것이 아니라, 미리 자료구조에 코어의 위치정보를 저장해두지
 * 각 코어에서 연결해 볼 수 있는 방법은 상하좌우 연결하지 않음.
 * 
 */
public class SW_01767_프로세서연결하기_보충자료 {
	private static int N;
	private static int[][] m;
	private static int maxCoreCnt;
	private static int minWireSum;
	private static ArrayList<Point> coreList;
	private static int totalCoreCnt;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = { 0, 0,-1, 1};
	private static class Point {	// 코어가 놓인 위치 정보를 저장할 클래스
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 테스트케이스 50개
			N = Integer.parseInt(br.readLine()); // 7 ≤ N ≤ 12
			m = new int[N][N];	
			int outLineCoreCnt = 0;				// 외곽에 붙어있는 코어의 개수
			coreList = new ArrayList<Point>(); 	// 전원이 연결되지 않은 코어의 좌표
			for (int i = 0; i < m.length; i++) {
				String s = br.readLine();
				for (int j = 0, index = 0; j < m.length; j++, index += 2) {
					m[i][j] = s.charAt(index);
					if (m[i][j] == '1') {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
							outLineCoreCnt++;
						} else { 
							coreList.add(new Point(i, j)); 
						}
					}
				}
			}
			
			totalCoreCnt = coreList.size() + outLineCoreCnt;	// 전체 코어의 개수
			maxCoreCnt = 0;					// 작업해서 만들 수 있는 전원이 최대 연결된 코어의 개수
			minWireSum = Integer.MAX_VALUE;	// 전선길이의 합(가능하면 최소)
			dfs(0, outLineCoreCnt, 0, 0);	
			sb.append("#").append(testCase).append(" ").append(minWireSum).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	
	
	/** index : Core 순번, coreCnt : 현재까지 전원이 연결된 Core의 개수, wireSum : 전선 길이의 합, noCore : 연결안한 Core의 개수 */
	public static void dfs(int index, int coreCnt, int wireSum, int noCore) {
		if (maxCoreCnt > totalCoreCnt - noCore) {	// 더이상 최대값을 갱신할 가능성이 없는 경우
			return;
		}
		
		if (index == coreList.size()) {
			if (maxCoreCnt < coreCnt) {
				maxCoreCnt = coreCnt;
				minWireSum = wireSum;
			} else if (maxCoreCnt == coreCnt && minWireSum > wireSum) {
				minWireSum = wireSum;
			}
			return;
		}
		Point core = coreList.get(index);
		dfs(index+1, coreCnt, wireSum, noCore+1);	//연결 안함
		for (int dir = 0; dir < dr.length; dir++) {	// 상하좌우 각 방향으로 연결해보기
			if (check(core.r, core.c, dir)) {		
				int cntWire = fill(core.r, core.c, dir, '2');	// 전선깔기
				dfs(index+1, coreCnt+1, wireSum+cntWire, noCore);	// 연결함
				fill(core.r, core.c, dir, '0');		// 원복하기
			}
		}
	}
	/** core 위치에서 외곽으로 직선연결이 가능한지 체크, (r,c) core의 좌표, dir 방향(0123상하좌우) */
	public static boolean check(int r, int c, int dir) {
		for (int i = 1; ; i++) {
			int nr = r + dr[dir] * i;
			int nc = c + dc[dir] * i;
			if (0>nr || nr>=N || 0>nc || nc>=N) {
				return true;
			}
			if (m[nr][nc] != '0') return false;
		}
	}
	/** core 위치에서 외곽으로 직선연결/해제, 해당맵에 작성, 사용한 전선길이를 리턴 */
	public static int fill(int r, int c, int dir, int val) {
		int cntWire = 0;
		for (int i = 1; ; i++) {
			int nr = r + dr[dir] * i;
			int nc = c + dc[dir] * i;
			if (0>nr || nr>=N || 0>nc || nc>=N) {
				return cntWire;
			}
			m[nr][nc] = val;
			cntWire++;
		}
	}
} // end of class
























