package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BJ_01941_소문난칠공주_류지원 {
	static int ableCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[5][5];
		for(int i=0; i<5; i++) {
			String Line = br.readLine();
			for(int j=0; j<5; j++) {
				map[i][j]=Line.charAt(j);
			}
		}
		
		// 4개, 5개, 6개, 7개의 부분집합 경우의 수 뽑기
		// 각 부분집합 경우의 수가 서로 이어질 수 있는 형태인지 bfs(너비우선탐색)으로 확인하기
		
		
		

	}

}
