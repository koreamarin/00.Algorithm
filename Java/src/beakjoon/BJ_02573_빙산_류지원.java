package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 메모리 : 168344KB
 * 시간 : 756ms
 * 풀이방법 : 
 * 1. 빙산 배열을 저장해놓고 1년 후 빙산 배열을 반환하는 메서드를 구현한다.
 * 2. 1년 후 빙산배열을 받아서, 그 빙산배열에서 0을 제외한 모든 곳들을 방문했는지 flood fill로 확인하기
 * 3. flood fill을 했을 때, flood fill 로직에서 1번이상의 fill 작업이 수행된다면 빙산이 2개로 나뉜것이다.
 */


public class BJ_02573_빙산_류지원 {
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(ST.nextToken());
		M = Integer.parseInt(ST.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int n=0; n<N; n++) {
			ST = new StringTokenizer(br.readLine());
			for(int m=0; m<M; m++) {
				map[n][m]=Integer.parseInt(ST.nextToken());
			}
		}
		
		loop1:
		for(int year=0; ; year++) {
			if(!floodFill(map)) {
				System.out.println(year);
				break loop1; 
			}
			int confirm = 0;
			
			loop2:
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					confirm+=map[n][m];
					if(confirm>0) {
						map = nextYearMap(map);
						break loop2;
					}
				}
			}
			
			if(confirm==0) {
				System.out.println(0);
				break loop1;
			}
		}
	}
	
	public static int[][] nextYearMap(int[][] map){
		int[][] nextYearMap = new int[N][M];
		for(int n=0; n<N; n++) Arrays.fill(nextYearMap[n], 0);
				
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m]!=0) {
					int melt=0;
					
					if(n>0 && map[n-1][m]==0) 		melt++;
					if(n<N-1 && map[n+1][m]==0) 	melt++;
					if(m>0 && map[n][m-1]==0) 		melt++;
					if(m<M-1 && map[n][m+1]==0) 	melt++;
					
					nextYearMap[n][m]=(map[n][m]-melt)>0 ? map[n][m]-melt : 0;
				}
			}
		}
		return nextYearMap;
	}
	
	public static boolean floodFill(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		for(int n=0; n<N; n++) Arrays.fill(visited[n], false);
		int count = 0;
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(count>1) return false;
				if(!visited[n][m] && map[n][m]!=0) {
					count++;
					
					Queue<int[]> q = new ArrayDeque<int[]>();
					
					q.add(new int[] {n,m});
					visited[n][m]=true;
					
					while(!q.isEmpty()) {
						int[] crt = q.poll();
						
						if(crt[0]>0 && map[crt[0]-1][crt[1]]!=0 && !visited[crt[0]-1][crt[1]]) {
							q.add(new int[] {crt[0]-1, crt[1]});
							visited[crt[0]-1][crt[1]]=true;
						}
						if(crt[0]<N-1 && map[crt[0]+1][crt[1]]!=0 && !visited[crt[0]+1][crt[1]]) {
							q.add(new int[] {crt[0]+1, crt[1]});
							visited[crt[0]+1][crt[1]]=true;
						}
						if(crt[1]>0 && map[crt[0]][crt[1]-1]!=0 && !visited[crt[0]][crt[1]-1]) {
							q.add(new int[] {crt[0], crt[1]-1});
							visited[crt[0]][crt[1]-1]=true;
						}
						if(crt[1]<M-1 && map[crt[0]][crt[1]+1]!=0 && !visited[crt[0]][crt[1]+1]) {
							q.add(new int[] {crt[0], crt[1]+1});
							visited[crt[0]][crt[1]+1]=true;
						}
					}
				}
			}
		}
		return true;
		
	}
	
	public static void printMap(int[][] map) {
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				System.out.print(map[n][m] + " ");
			}
			System.out.println();
		}
	}

}
