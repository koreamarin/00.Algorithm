package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 
 * 메모리 :
 * 풀이 방법 :
 * 1. DFS로 완전탐색하면서 공 떨어뜨리기 
 * 2. 파괴될 벽돌을 BFS로 큐에 넣기.
 * 3. 큐에서 하나씩 빼면서 다른 파괴될 벽돌 큐에 넣기. 만약 이미 파괴되었다면 통과.
 * 4. 2번 3번 과정을 다 하였다면 벽돌을 아래로 내리기.
 * 5. 4번 과정도 완료되었다면 다음 DFS로 공 떨어뜨리기.
 */

public class SW_05656_벽돌깨기_류지원_2 {
	static int N, W, H, min;
	static int[] selected;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			N=Integer.parseInt(ST.nextToken());
			W=Integer.parseInt(ST.nextToken());
			H=Integer.parseInt(ST.nextToken());
			min=Integer.MAX_VALUE;
			selected = new int[N];
			
			map = new int[H][W];
			
			// 배열 입력받기
			for(int i=0; i<H; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}
			
			
			dfs(0);
			
			System.out.println("#" + t + " " + min);
			
		}

	}
	// 벽돌 떨어뜨리는 순서를 결정하는 메서드. DFS로 모든 경우를 완전탐색함.
	public static void dfs(int n) {
		// 기저조건, 벽돌 떨어뜨리기 실행
		if(n==N) {
//			System.out.println();
//			System.out.println("벽돌 떨어뜨리는 순서 : " + Arrays.toString(selected));
			DropBoll();
			return;
		}
		for(int j=0; j<W; j++) {
			selected[n]=j;
			dfs(n+1);
		}
	}
	
	// 공을 떨어뜨리고 벽돌 파괴하는 메서드.
	public static void DropBoll() {
		// 맵 배열 복사
		int[][] map_copy = new int[H][];
		for(int i=0; i<H; i++) {
			map_copy[i]=Arrays.copyOf(map[i], H);
		}
		
		// 공 떨어뜨린 위치 (열)
		for(int n=0; n<N; n++) {
			loop :
			for(int ii=0; ii<H; ii++) { /// 공 떨어지는 반복문. (행 sweep)
				if(map_copy[ii][selected[n]]!=0) {
//					System.out.println("맞은 벽돌 위치 : (" + ii + " " + selected[n] + ")");
					// BFS를 돌며 파괴될 벽 위치를 넣기위한 queue
					Queue<int[]> queue = new ArrayDeque<int[]>();
					
					// 방문을 체크할 배열
					boolean[][] isVisited = new boolean[H][W];
					
					// 벽돌 파괴할 초기 위치 넣기
					queue.add(new int[]{ii, selected[n]});
					
					// 큐가 비어있지 않다면 벽돌 위치 꺼내기
					while(!queue.isEmpty()) {
						int[] Lo = queue.poll();
						int r = Lo[0]; int c = Lo[1];
						
//						// 해당 벽돌 방문했다면 pass
//						if(isVisited[r][c]) continue;
//						
//						// 해당 벽돌 방문 안했다면 아래 로직 진행
//						else if(!isVisited[r][c]) {
						
//						System.out.println("진짜뭐임?");
						// 해당 벽돌의 상 하 좌 우 큐에 넣기. 0이 아니라면 넣기, 방문한곳은 넣지않기.
						for(int i=1; i<map_copy[r][c]; i++) {
//							System.out.println("뭐냐");
							// 상
							if(isRange(r-i, c)) {	// 배열 안이라면 실행
//								System.out.println("!");
								if(map_copy[r-i][c]>0 && !isVisited[r-i][c]) {	// 방문하지 않았고, 0보다 크면 큐에 넣기
//									System.out.println("넣음상");
									queue.add(new int[] {r-i, c});
								}
							}
							
							// 하
							if(isRange(r+i, c)) {	// 배열 안이라면 실행
//								System.out.println("!");
								if(map_copy[r+i][c]>0 && !isVisited[r+i][c]) {
//									System.out.println("넣음하");
									queue.add(new int[] {r+i, c});
								}
							}
							
							// 좌
							if(isRange(r, c-i)) {	// 배열 안이라면 실행
//								System.out.println(r + " " + (c-1));
//								System.out.println("!");
								if(map_copy[r][c-i]>0) {
									if(!isVisited[r][c-i]) {
//									System.out.println("넣음좌");
										queue.add(new int[] {r, c-i});
									}
								}
							}
							
							// 우
							if(isRange(r, c+i)) {	// 배열 안이라면 실행
//								System.out.println("!");
								if(map_copy[r][c+i]>0 && !isVisited[r][c+i]) {
//									System.out.println("넣음우");
									queue.add(new int[] {r, c+i});
								}
							}
						}
						
						// 해당 벽돌 파괴 및 방문 체크
						map_copy[r][c]=0;
						isVisited[r][c]=true;
					}
					

					
					
					
					// 다 파괴됨. 그러니깐 내려야함.
					map_copy = dropBlock(map_copy);
					
					
					
					
					break loop;	// 종료하고 다음 순번의 공 쏘기
				}
				
			}
				
		}
		
//		for(int i=0; i<H; i++) {
//			System.out.println(Arrays.toString(map_copy[i]));
//		}
		
		// N번만큼 공 다 떨어뜨렸으면 남은 블록갯수 세서 min값 갱신하기.
		int sum=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map_copy[i][j]!=0) sum++;
			}
		}
		min=Math.min(min, sum);
	}
	
	
	// 벽돌 아래로 내리는 메서드.
	public static int[][] dropBlock(int[][] map) {
		int[][] mapClone = new int[H][W];
		 
		 for(int j=0; j<W; j++) {
			 int ii=H-1;
			 for(int i=H-1; i>=0; i--) {
				 if(map[i][j]!=0) {
					 mapClone[ii--][j]=map[i][j];
				 }
			 }
		 }
		 
		 return mapClone;
	}
	
	// 배열 밖으로 나갔는지 안나갔는지 체크하는 메서드.
	public static boolean isRange(int i, int j) {
		if(i<0 || H<=i) return false;
		if(j<0 || W<=j) return false;
		return true;
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
