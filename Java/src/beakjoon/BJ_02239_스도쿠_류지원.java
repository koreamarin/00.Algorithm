package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * @author 류지원
 * 메모리 : 16396KB
 * 시간 : 737ms
 * 풀이방법 : 
 * 숫자가 각 자리에 들어갈 수 있는지 없는지를 검증하는 방식으로 백트래킹을 사용하였다.
 */

public class BJ_02239_스도쿠_류지원 {
	static int[][] sudoku;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		
		// 입력 받기 및 배열 생성
		for(int i=0; i<9; i++) {
			String line=br.readLine();
			for(int j=0; j<9; j++) {
				sudoku[i][j]=Character.getNumericValue(line.charAt(j));
				// 0인 구간, 즉 빈칸인 곳들의 위치를 list에 넣음ㄴ
				if(sudoku[i][j]==0) list.add(new int[] {i,j});
			}
		}
		
		dfs(0);
		
		// 배열 출력
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	
	// 백트래킹
	public static boolean dfs(int cnt){
		// 기저조건
		if(cnt==list.size()) return true;	// 모든 빈칸이 완료되었다면 true 반환
		
		// 운용조건
		int[] lct = list.get(cnt);		// 빈칸인 곳들의 위치를 뽑음
		int ti = lct[0], tj = lct[1];	// 빈칸인 곳들의 위치를 뽑아서 i좌표와 j좌표로 저장
		for(int i=1; i<10; i++) {		// 빈칸에 1부터 9까지 넣어보기 위한 반복문
			sudoku[ti][tj]=i;			// 빈칸에 i를 넣기.
			if(totalValid(ti, tj)) {	// 빈칸에 i를 넣었을 때, i가 해당 빈칸에 들어갈수 있으면(totalValid메서드로 검증)
				if(dfs(cnt+1)) return true;		// 다음 빈칸에 1~9까지 넣어보기 위한 dfs(cnt+1)을 실행, 기저조건을 찍었다면 true를 연쇄적으로 반환하여 모든 dfs를 탈출하게 됨.
			}
		}
		sudoku[ti][tj]=0;				// 1~9까지 반복할 동안에 모든 숫자가 빈칸에 들어가는게 불가능하다면 0으로 만듦. 0으로 만들지 않으면 9가 남게되어 백트래킹되었을 때 이전 자리수에서 잘못된 계산이 발생하게 됨.
		return false;					// 1~9까지 반복할 동안에 모든 숫자가 빈칸에 들어가는게 불가능하다면 false를 반환.
	}
	
	
	// 통합 검증
	public static boolean totalValid(int ti, int tj) {
		// 가로 검증
		for(int j=0; j<9; j++) {
			if(j==tj) continue;
			if(sudoku[ti][j]==sudoku[ti][tj]) return false;
		}
		
		// 세로 검증
		for(int i=0; i<9; i++) {
			if(i==ti) continue;
			if(sudoku[i][tj]==sudoku[ti][tj]) return false;
		}
				
		// 3*3 검증
		int stti=(ti/3)*3;
		int stpi=((ti/3)*3)+3;
		int sttj=(tj/3)*3;
		int stpj=((tj/3)*3)+3;
		
		for(int i=stti; i<stpi; i++) {
			for(int j=sttj; j<stpj; j++) {
				if(i==ti && j==tj) continue;
				if(sudoku[i][j]==sudoku[ti][tj]) return false;
			}
		}
		
		return true;
	}

}
