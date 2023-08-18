package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 888ms
 * 메모리 : 12908KB
 * 풀이 방식:
 * dfs로 갈 수 있는 구간을 최대한 간 후, 최대값을 max에 저장하였다.
 */

public class BJ_01987_알파벳_류지원 {
	static int[] dr={-1,1,0,0};	// 상 하 좌 우
	static int[] dc={0,0,-1,1};	// 상 하 좌 우
	static boolean[] visited=new boolean[26];	// 알파벳 방문 추가.
	static int R,C, max=1;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		R=Integer.parseInt(ST.nextToken());
		C=Integer.parseInt(ST.nextToken());
		arr=new int[R][C];
		for(int i=0; i<R; i++) {
			String S=br.readLine();
			for(int j=0; j<C; j++) arr[i][j]=S.charAt(j)-65;
		}
		dfs(0, 0, 1);
		System.out.println(max);
	}
	public static void dfs(int r, int c, int cnt) {
		visited[arr[r][c]]=true;	// visited에 해당 알파벳 방문 추가
		for(int i=0; i<4; i++)		// 상하좌우 탐색
			if(r+dr[i]>=0 && r+dr[i]< R && c+dc[i]>=0 && c+dc[i]< C && 	// 배열 밖으로 나가지 않았는지
			!visited[arr[r+dr[i]][c+dc[i]]])							// 방문하지 않은곳인지
				dfs(r+dr[i], c+dc[i], cnt+1);	// 갈 수 있다면 재귀
		visited[arr[r][c]]=false;	// visited에 해당 알파벳 방문 안함으로 추가.
		if(max<cnt) max=cnt;		// 아무데도 갈 수 없다면 기저조건이 되고, 이동거리와 Max를 비교하고 max가 작을 경우 max 갱신
	}
}
