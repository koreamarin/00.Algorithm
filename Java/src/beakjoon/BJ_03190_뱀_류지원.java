package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

/** 
 * @author 류지원
 * 메모리 : 15264KB
 * 시간 : 164ms
 * 풀이방법 : 뱀의 위치를 큐를 이용하여 저장하고, 나머지는 단순 구현하는 시뮬레이션 문제였다.
 */

public class BJ_03190_뱀_류지원 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());	// 보드의 크기
		int[][] map=new int[N][N];					// 보드 배열
		
		int K = Integer.parseInt(br.readLine());	// 사과의 위치
		int[][] appleLo=new int[K][2];				// 사과의 위치 저장 배열
		for(int k=0; k<K; k++) {					// 사과의 위치를 입력받아 저장할 반복문
			ST=new StringTokenizer(br.readLine());
			appleLo[k]=new int[] {Integer.parseInt(ST.nextToken())-1, Integer.parseInt(ST.nextToken())-1};			
		}
		
		int L = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 정보 갯수
		String[][] snakeInfo = new String[L][2];		// 뱀의 방향 변환 정보를 저장할 배열 
		for(int l=0; l<L; l++) {					// 뱀의 방향 정보를 입력받아 저장할 반복문
			ST=new StringTokenizer(br.readLine());
			snakeInfo[l]=new String[] {ST.nextToken(), ST.nextToken()};
		}
		
		// 사과 위치를 map에 구현하기
		for(int k=0; k<K; k++) map[appleLo[k][0]][appleLo[k][1]] = 1; 
		
		// 뱀의 머리부터 꼬리까지의 위치를 저장할 큐
		Deque<int[]> snake = new ArrayDeque<>();
		
		// 뱀 초기 위치를 큐에 넣음
		snake.offer(new int[] {0,0});
		
		// 맵에 뱀의 초기 위치 구현
		map[snake.peekFirst()[0]][snake.peekFirst()[1]]=2;
		
		// 뱀의 진행방향 변수
		char[] Direction= {'U', 'R', 'D', 'L'};
		
		// 뱀의 현재 진행방향 변수
		int currentDirection = 1;
		
		// 게임 턴 수
		int turn=0;
		
		while(true) {
			turn+=1;
			
			// 뱀의 다음 위치
			int[] nextLo = Arrays.copyOf(snake.peekLast(), 2) ;
			switch(Direction[currentDirection]) {
				case 'D' : 
					nextLo[0]++;
					break;
				case 'L' :
					nextLo[1]--;
					break;
				case 'U' :
					nextLo[0]--;
					break;
				case 'R' :
					nextLo[1]++;
					break;
			}
					
			// 뱀의 다음 위치가 맵 밖이라면 종료
			if(!Invalid(nextLo, N)) break;
			
			// 뱀의 다음 위치가 뱀의 몸에 닿는다면 종료
			if(map[nextLo[0]][nextLo[1]]==2) break;
			
			// 만약 뱀이 이동한 자리에 사과가 있다면 뱀의 머리 증가
			if(map[nextLo[0]][nextLo[1]]==1) {
				map[nextLo[0]][nextLo[1]]=2;
				snake.offer(nextLo);
			}
			
			// 만약 뱀이 이동한 자리에 사과가 없다면 뱀의 꼬리는 사라지고 머리는 1 증가
			if(map[nextLo[0]][nextLo[1]]==0) {
				map[nextLo[0]][nextLo[1]]=2;
				snake.offer(nextLo);
				int[] tail = snake.pollFirst();
				map[tail[0]][tail[1]]=0;
			}
			
			// 뱀의 방향이 틀어졌는지 확인 후 방향 수정
			for(int l=0; l<L; l++) {
				if(Integer.parseInt(snakeInfo[l][0])==turn) {
					if(snakeInfo[l][1].equals("D")) currentDirection = (currentDirection + 1) % 4;
					else if(snakeInfo[l][1].equals("L")) currentDirection = (currentDirection + 3) % 4;
				}
			}
		}
		System.out.println(turn);
	}
	
	// 종료조건 : snake위치 정보를 받아 벽밖으로 나갔는지 확인, 벽밖으로 나가면 false를 반환
	public static boolean Invalid(int[] snakeLo, int N) {
		if(snakeLo[0]<0)	return false;
		if(N<=snakeLo[0])	return false;
		if(snakeLo[1]<0)	return false;
		if(N<=snakeLo[1])	return false;
		return true;
	}
	
}
