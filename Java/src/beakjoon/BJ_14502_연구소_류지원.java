package beakjoon;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 
 * 시간 : 
 * 
 * 풀이 방법 : 
 * 0인 구간 완전탐색으로 3개를 골라서 벽을 세운다.
 * 벽을 세운 뒤에는 flood fill로 바이러스를 퍼쳐서 0인 구간의 총합을 찾는다.
 * 벽 3개를 세운 모든 경우에서 안전구역의 최대값을 찾아낸다.
 */

public class BJ_14502_연구소_류지원 {
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		ST=new StringTokenizer(br.readLine());
		N=Integer.parseInt(ST.nextToken());
		M=Integer.parseInt(ST.nextToken());
		
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) map[i][j]=Integer.parseInt(ST.nextToken());
		}
		
		dfs(0, 0, 0);
	}
	
	static void dfs(int cnt, int si, int sj) {
		// 기저조건
		if(cnt==3) {
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			return;
		}
		
		
		// 유도파트
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (si>i) continue;
				if (si==i && sj>j) continue;
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(cnt+1, i, j);
					map[i][j]=0;
				}
			}
		}
		
		
	}
	
	static void flood_fill(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					
				}
			}
		}
	}
	
	
	

}
