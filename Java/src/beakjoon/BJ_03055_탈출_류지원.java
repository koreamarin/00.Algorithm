package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_03055_탈출_류지원 {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer ST= new StringTokenizer(br.readLine());
		 
		 int R=Integer.parseInt(ST.nextToken()), C=Integer.parseInt(ST.nextToken());
		 
		 // 배열 생성 및 입력받기
		 char[][] map = new char[R][];
		 for(int r=0; r<R; r++) map[r]=br.readLine().toCharArray();
		 
		 // 비버의 굴 저장할 Integer 변수 배열
		 int[] targetLo;
		 
		 Queue<int[]> dochi = new ArrayDeque<>();	// 고슴도치의 BFS를 위한 큐
		 Queue<int[]> water = new ArrayDeque<>();	// 물의 BFS를 위한 큐
		 
		 for(int r=0; r<R; r++) {
			 for(int c=0; c<C; c++) {
				 if(map[r][c]=='D') targetLo=new int[] {r,c};			// 비버의 굴 위치 변수에 비버굴 위치 저장
				 else if(map[r][c]=='*') water.add(new int[] {r,c});	// 물 위치를 담을 큐에 물 위치를 넣음
				 else if(map[r][c]=='S') dochi.add(new int[] {r,c});	// 초기 고슴도치 위치를 고슴도치 큐에 넣음
			 }
		 }
		 
		 
		 // 
		 while(!water.isEmpty() || !dochi.isEmpty()) {
			 water.poll();
			 // 물 증가
			 
			 
			 dochi.poll();
			 // 도치 증가
			 
			 
			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	}

}
