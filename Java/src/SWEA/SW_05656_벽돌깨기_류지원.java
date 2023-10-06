package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 109568KB
 * 시간 : 1329ms
 * 풀이방법
 * 1. 큐에 넣어서 벽돌 파괴한다.
 * 2. 파괴된 벽돌은 0으로 만든다.
 * 4. 아래로 착착 다시 쌓는다.
 * 5. 이것들을 중복순열로 공을 쏜다.
 */

public class SW_05656_벽돌깨기_류지원 {
	static int N, W, H, min;
	static int[] numbers;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			N = Integer.parseInt(ST.nextToken());	// 구슬 쏘는 횟수
			W = Integer.parseInt(ST.nextToken());	// Width
			H = Integer.parseInt(ST.nextToken());	// height
			numbers=new int[N];
			min=Integer.MAX_VALUE;
			
			map = new int[H][W];
			
			for(int i=0; i<H; i++) {
				ST = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}
			
			dfs(0);
			
			System.out.println("#" + t + " " + min);
		}

	}
	
	public static void dfs(int cnt) {
		// 기저조건
		if(cnt==N) {
			int[][] mapClone = new int[H][];
			for(int i=0; i<H; i++) mapClone[i]=Arrays.copyOf(map[i], W);
			
			for(int i=0; i<numbers.length; i++) {
				mapClone = destroy(mapClone, numbers[i]);
			}

			int sum=0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(mapClone[i][j]>0) sum++;
				}
			}
			min=Math.min(min, sum);
			return;
		}
		// 운용조건
		for(int i=0; i<W; i++) {
			numbers[cnt]=i;
			dfs(cnt+1);
		}
	}
	
	 public static int[][] destroy(int[][] mapClone, int j) {
		 Queue<int[]> queue = new ArrayDeque<int[]>();
		 for(int i=0; i<H; i++) {
			 if(mapClone[i][j]!=0) {
				 queue.add(new int[] {i, j});
				 break;
			 }
		 }
		 
		 while(!queue.isEmpty()) {
			 int[] crt = queue.poll();
			 
			 if(mapClone[crt[0]][crt[1]]!=0) {
				 int num = mapClone[crt[0]][crt[1]];
				 mapClone[crt[0]][crt[1]]=0;
				 
				 // 상 파괴, 큐에 넣기
				 for(int i=1; i<num; i++) {
					 if(crt[0]-i >= 0 && mapClone[crt[0]-i][crt[1]]!=0) {
						 queue.add(new int[] {crt[0]-i, crt[1]});
					 }
				 }
				 
				 // 하 파괴, 큐에 넣기
				 for(int i=1; i<num; i++) {
					 if(crt[0]+i < H && mapClone[crt[0]+i][crt[1]]!=0) {
						 queue.add(new int[] {crt[0]+i, crt[1]});
					 }
				 }
				 
				 // 좌 파괴, 큐에 넣기
				 for(int i=1; i<num; i++) {
					 if(crt[1]-i >= 0 && mapClone[crt[0]][crt[1]-i]!=0) {
						 queue.add(new int[] {crt[0], crt[1]-i});
					 }
				 }
				 
				 // 우 파괴, 큐에 넣기
				 for(int i=1; i<num; i++) {
					 if(crt[1]+i < W && mapClone[crt[0]][crt[1]+i]!=0) {
						 queue.add(new int[] {crt[0], crt[1]+i});
					 }
				 }
			 }
		 }
		 mapClone = brickDrop(mapClone);
		 
		 return mapClone;
	 }
	 
	 public static int[][] brickDrop(int[][] map){
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

}
