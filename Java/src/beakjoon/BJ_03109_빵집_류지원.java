package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 308ms
 * 메모리 : 31620kb
 * 풀이방법 : dfs를 이용하였다.
 * 
 */
public class BJ_03109_빵집_류지원 {
	static int[] pipeNums, di= {-1, 0, 1};
	static int pipeAmount, R, C, cnt=0;
	static boolean[][] map; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		R=Integer.parseInt(ST.nextToken());
		C=Integer.parseInt(ST.nextToken());	// 배열크기 행,열
		map = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String S = br.readLine();
			for(int j=0; j<C; j++) if(S.charAt(j)=='x') map[i][j]=true;
		}
		for(int i=0; i<R; i++) dfs(i, 0);
		for(int i=0; i<R; i++) if(map[i][C-1]==true) cnt+=1;
		System.out.println(cnt);	
	}
	public static boolean dfs(int i, int j) {
		map[i][j]=true;
		if(j==C-1) return true;
		for(int d=0; d<3; d++) {
			int ni=i+di[d];
			if(ni>=0 && ni<R && map[ni][j+1]==false && dfs(ni, j+1)) return true;
		}
		return false;
	}	
}
