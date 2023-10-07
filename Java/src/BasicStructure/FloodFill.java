package BasicStructure;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * FloodFill => 구역탐색, BFS나 DFS로 구현가능
 * isVisited[][] 사용해야함.
 * 
 * 섬의 개수를 세는 프로그램등으로 많이 나옴.
 * 구역을 나눠서 필요한 연산을 수행하는 느낌으로다가.
 * ex) 섬의 개수 세기, 섬의 각 지역에 인구수 세기 등
 * 
 */

/**
 * 아래 알고리즘 내용.
 * map이 주어진다. 숫자가 0인 곳은 바다이고, 0이상인 곳은 섬이며, 그 지역에 사는 인구수이다.
 * 섬의 총 개수를 먼저 출력하고
 * 그 밑으로 각 섬별 총 인구수를 출력하라.(출력순서 상관 X)
 */
public class FloodFill {

	public static void main(String[] args) {
		int[][] map = {
				{1,5,0,0},
				{5,0,0,6,},
				{0,10,0,2},
				{5,7,1,1}
				};
		
		boolean[][] isVisited = new boolean[4][4];
		
		int[] di = {-1, 1, 0, 0};
		int[] dj = {0, 0, -1, 1};
		
		
		Queue<int[]> lo = new ArrayDeque<int[]>();
		for(int i=0; i<4; i++) {
			for(int j =0; j<4; j++) {
				
				if(isVisited[i][j]==false && )
				
				
				
				
			}
		}
		
		

	}

}
