package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 11936ms 
 * 시간 : 72ms
 * 풀이방법 : 
 * 물과 고슴도치의 이동을 BFS로 확장하며 풀이하였다.
 * 하나의 턴에 대해서 물이 모두 확장한 후에 고슴도치가 갈 수 있는 이동경로를 모두 확장하도록 하였다
 * 물은 고슴도치가 있는 칸에 물을 덮어쓸 수 있고, 바닥에도 물을 덮어쓸 수 있다. 비버굴은 덮어쓸 수 없다.
 * 고슴도치는 바닥을 덮어쓸 수 있으며, 물에는 덮어쓸수 없다. 비버굴을 만나면 현재까지의 카운트를 출력하고 종료한다.
 * 만약 고슴도치가 비버굴을 만나지 못하면 큐가 모두 나와서 반복문이 종료되고 "KAKTUS"를 출력한다.
 *
 */

public class BJ_03055_탈출_류지원 {
	static int R, C;

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer ST= new StringTokenizer(br.readLine());
		 
		 R=Integer.parseInt(ST.nextToken());
		 C=Integer.parseInt(ST.nextToken());
		 
		 // 배열 생성 및 입력받기
		 char[][] map = new char[R][];
		 for(int r=0; r<R; r++) map[r]=br.readLine().toCharArray();
		 
		 
		 Queue<int[]> dochi = new ArrayDeque<>();	// 고슴도치의 BFS를 위한 큐
		 Queue<int[]> water = new ArrayDeque<>();	// 물의 BFS를 위한 큐
		 
		 for(int r=0; r<R; r++) {
			 for(int c=0; c<C; c++) {
				 if(map[r][c]=='*') water.add(new int[] {r,c});	// 물 위치를 담을 큐에 물 위치를 넣음
				 else if(map[r][c]=='S') dochi.add(new int[] {r,c});	// 초기 고슴도치 위치를 고슴도치 큐에 넣음
			 }
		 }
		 
		 int[] di = {-1, 1, 0, 0};		// 상하좌우
		 int[] dj = {0, 0, -1, 1};		// 상하좌우
		 
		 // 몇 턴이 지났는지 카운팅할 변수
		 int count = 0;
		  
		 while(!water.isEmpty() || !dochi.isEmpty()) {		// 비버와 고슴도치가 이동할 수 없을때까지 반복
			 count+=1;		// 카운팅 횟수 + 1
			 int waterSize=water.size();	// 큐에 움직여야할 물의 위치가 몇개인지 확인하여 할당
			 for(int i=0; i<waterSize; i++) {	// 움직여야할 물의 위치 개수만큼 반복문 실행
				 int[] waterLo = water.poll();	// 큐에서 움직여야할 물의 위치 빼기
				 // 물 증가
				 for(int d=0; d<4; d++) {	// 상하좌우로 이동하는 반복문
					 int ni = waterLo[0] + di[d];	// 이동했을때의 행 위치
					 int nj = waterLo[1] + dj[d];	// 이동했을떄의 열 위치
					 
					 if(inRange(ni, nj) && (map[ni][nj]=='.' || map[ni][nj]=='S')) {	// 범위안에 있을때 움직인 위치가 '.' 또는 'S'라면 물이 그쪽으로 이동
						 map[ni][nj]='*';	// 위치를 '*'로 덮어씌워서 물이 차올랐음을 표시
						 water.add(new int[] {ni, nj});	// 덮어씌운 위치 물 위치 표시하기.
					 }
				 }
			 }
			 
			 int dochiSize=dochi.size();		// 큐에 움직여야할 고슴도치의 위치가 몇개인지 확인하여 할당
			 for(int i=0; i<dochiSize; i++) {	// 움직여야할 고슴도치의 위치 개수만큼 반복문 실행
				 int[] dochiLo = dochi.poll();	// 큐에서 움직여야할 고슴도치의 위치 빼기
				 // 도치 증가
				 for(int d=0; d<4; d++) {		// 상하좌우로 이동하는 반복문
					 int ni = dochiLo[0] + di[d];	// 이동했을때의 행 위치
					 int nj = dochiLo[1] + dj[d];	// 이동했을떄의 열 위치
					 
					 if(inRange(ni, nj)) {			// 이동할 위치가 범위 안에 있을 때 실행
						 if(map[ni][nj]=='D') {		// 이동할 위치가 D이면 목표에 도달했으므로 카운트 수를 출력하고 프로그램 종료
							 System.out.println(count);
							 return;
						 }
						 else if(map[ni][nj]=='.') {	// 이동할 위치가 .이면 고슴도치를 그 위치로 이동.
							 map[ni][nj]='S';
							 dochi.add(new int[] {ni, nj});
						 }
					 }
				 }
			 }
		 }
		 System.out.println("KAKTUS");		// 큐가 모두 없어질때까지 목표에 도달하지 못하고 반복문을 빠져나왔다면 KAKTUS를 출력하고 종료
	}
	
	public static boolean inRange(int i, int j) {
		if(i>R-1) 	return false;
		if(i<0) 	return false;
		if(j>C-1) 	return false;
		if(j<0) 	return false;
		return true;
	}

}
