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
		 
		 int[] targetLo;
		 
		 Queue<int[]> dochi = new ArrayDeque<>();
		 Queue<int[]> water = new ArrayDeque<>();
		 
		 for(int r=0; r<R; r++) {
			 for(int c=0; c<C; c++) {
				 if(map[r][c]=='D') targetLo=new int[] {r,c};
				 else if(map[r][c]=='*') water.add(new int[] {r,c});
				 else if(map[r][c]=='S') dochi.add(new int[] {r,c});
			 }
		 }
		 
		 while(!water.isEmpty() || !dochi.isEmpty()) {
			 water.poll();
			 // 물 증가
			 
			 
			 dochi.poll();
			 // 도치 증가
			 
			 
			 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	}

}
