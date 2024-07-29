package beakjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 시간 : 316ms
 * 메모리 : 32156kb
 * 풀이방법 : DFS와 그리디
 */

public class BJ_03109_빵집_류지원2 {
	static boolean isVisited[][];
	static int R, C, count=0;
	static int[] dr = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		R = Integer.parseInt(ST.nextToken());
		C = Integer.parseInt(ST.nextToken());
		isVisited = new boolean[R][C];
		for(int r=0; r<R; r++) {
			String line = br.readLine();
			for(int c=0; c<C; c++) if(line.charAt(c)=='x') isVisited[r][c]=true;
		}
		for(int r=0; r<R; r++) if(dfs(r, 0)) count++;
		System.out.println(count);
	}
	
	public static boolean dfs(int r, int c) {
		isVisited[r][c]=true;
		if(c==C-1) return true;
		for(int i=0; i<3; i++) {
			if(isRange(r+dr[i]) && !isVisited[r+dr[i]][c+1] && dfs(r+dr[i], c+1)) return true;
		}
		return false;
	}
	
	public static boolean isRange(int r) {
		if(r<0 || R<=r) return false;
		return true;
	}
}
