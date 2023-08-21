package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 류지원
 * 메모리 : 12120kb
 * 시간 : 84ms
 * 풀이 방법 :
 * Flood Fill을 DFS로 구현하여 각 구간의 개수를 세었다.
 * 색맹이 보는 구간을 셀 때에는 R,G를 같은 색으로 변환하여 구간을 세었다.
 *
 */

public class BJ_10026_적록색약_류지원 {
	static char[][] map; static int N;
	static boolean[][] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		isSelected=new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String mapLine = br.readLine();
			for(int j=0; j<N; j++) map[i][j]=mapLine.charAt(j);
		}
		
		int J=0; int B=0;	// 정상인이 보는 구간 개수, 비정상인이 보는 구간 개수
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isSelected[i][j]) {		// 이 지점이 선택되지 않았다면
					isSelected[i][j]=true;	// 이 지점의 구간이 탐색하였음.
					DFS(i, j, map[i][j]);	// DFS로 구간을 모두 선택함
					J+=1;					// 한 구간 탐색 완료하였으므로 1을 추가
				}
			}
		}
		
		isSelected=new boolean[N][N];		// isSlected 초기화
		for(int i=0; i<N; i++) for(int j=0; j<N; j++) if(map[i][j]=='G') map[i][j]='R';	// R과 C의 색을 같게 만듦
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!isSelected[i][j]) {		// 이 지점이 선택되지 않았다면
					isSelected[i][j]=true;	// 이 지점의 구간이 탐색하였음.
					DFS(i, j, map[i][j]);	// DFS로 구간을 모두 선택함
					B+=1;					// 한 구간 탐색 완료하였으므로 B에 1을 추가
				}
			}
		}
		
		System.out.print(J + " " + B);
	}
	
	public static void DFS(int i, int j, char C) {
		if(i+1<N && map[i+1][j]==C && !isSelected[i+1][j]) {	// 배열을 벗어나지 않으면서 다음 탐색구간이 현재 탐색구간과 색이 같으면서 , 탐색하지 않은 것일때
			isSelected[i+1][j]=true;		// 이 지점의 구간이 탐색하였음.
			DFS(i+1, j, C);					// 다음 구간 탐색하러 재귀
		}
		if(0<=i-1 && map[i-1][j]==C && !isSelected[i-1][j]) {	// 배열을 벗어나지 않으면서 다음 탐색구간이 현재 탐색구간과 색이 같으면서 , 탐색하지 않은 것일때
			isSelected[i-1][j]=true;		// 이 지점의 구간이 탐색하였음.
			DFS(i-1, j, C);					// 다음 구간 탐색하러 재귀
		}
		if(j+1<N && map[i][j+1]==C && !isSelected[i][j+1]) {	// 배열을 벗어나지 않으면서 다음 탐색구간이 현재 탐색구간과 색이 같으면서 , 탐색하지 않은 것일때
			isSelected[i][j+1]=true;		// 이 지점의 구간이 탐색하였음.
			DFS(i, j+1, C);					// 다음 구간 탐색하러 재귀
		}
		if(0<=j-1 && map[i][j-1]==C && !isSelected[i][j-1]) {	// 배열을 벗어나지 않으면서 다음 탐색구간이 현재 탐색구간과 색이 같으면서 , 탐색하지 않은 것일때
			isSelected[i][j-1]=true;		// 이 지점의 구간이 탐색하였음.
			DFS(i, j-1, C);					// 다음 구간 탐색하러 재귀
		}
	}

}
