package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_02239_스도쿠_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] sudoku = new char[9][9];
		
		// 입력 받기 및 배열 생성
		for(int i=0; i<9; i++) {
			String line=br.readLine();
			for(int j=0; j<9; j++) {
				sudoku[i][j]=line.charAt(j);
			}
		}
		
		
		
		
		
		

	}
	
	// 가로 검증
	
	// 세로 검증
	
	// 3*3 검증
	

}
