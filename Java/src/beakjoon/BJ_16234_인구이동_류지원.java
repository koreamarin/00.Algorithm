package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 728ms
 * 메모리 : 297724KB
 * 풀이방법 : bfs의 flood fill을 이용해 각 구역을 나눠서
 * 각 구역의 average를 구해서 map에 적용하는 방식을 반복하여 count 하였다.
 */

public class BJ_16234_인구이동_류지원 {
	static boolean[][] isSelected;
	static int N, L, R;
	static int maxNum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(ST.nextToken());	// 맵 크기
		L = Integer.parseInt(ST.nextToken());	// 인구 차이 L 이상
		R = Integer.parseInt(ST.nextToken());	// 인구 차이 R 이하
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) map[i][j]=Integer.parseInt(ST.nextToken());
		}
		
		int cnt = 0;
		
		while(true) {
			isSelected=new boolean[N][N];
			int[][] area = areaDivider(map);
			
			int[] sumArr = new int[maxNum];		// 구역별 숫자 합하는 변수
			int[] areaCnt = new int[maxNum];	// 구역의 칸이 몇개인지 카운팅하는 변수
			Arrays.fill(areaCnt, 0);			// 모두 0으로
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					sumArr[area[i][j]] += map[i][j];	// 구역별 숫자 합하기
					areaCnt[area[i][j]]++;				// 구역별 칸이 몇개인지 카운팅
				}
			}

			int[] avgArr = new int[maxNum];				// 구역별 숫자 평균 구하기
			for(int i=0; i<maxNum; i++) avgArr[i]=sumArr[i]/areaCnt[i];

			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=avgArr[area[i][j]];		// 구역별로 평균값을 map에 적용
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(area[i][j]==N*N-1) {
						System.out.println(cnt);		// area의 숫자가 N*N-1개까지 나타난다면 인구이동이 발생하지 않는 상태이므로 cnt를 출력하고 프로그램 종료
						return;
					}
				}
			}
			cnt +=1;
		}
	}

	// 구역나누기
	public static int[][] areaDivider(int[][] map){
		int[][] area = new int[N][N];
		boolean[][] ischoice = new boolean[N][N]; 
		
		int areaNum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				
				if(ischoice[i][j]==false) {
					
					Queue<int[]> queue = new ArrayDeque<int[]>();
					queue.add(new int[]{i,j});
					ischoice[i][j]=true;
					area[i][j]=areaNum;
					
					while(!queue.isEmpty() ) {
						int[] current = queue.poll();
						
						if(current[0]>0 && ischoice[current[0]-1][current[1]]==false
								&& L<=Math.abs(map[current[0]][current[1]]-map[current[0]-1][current[1]])
								&& R>=Math.abs(map[current[0]][current[1]]-map[current[0]-1][current[1]])) {
							queue.add(new int[] {current[0]-1, current[1]});
							ischoice[current[0]-1][current[1]]=true;
							area[current[0]-1][current[1]]=areaNum;
						}
						
						if(current[0]<N-1 && ischoice[current[0]+1][current[1]]==false
								&& L<=Math.abs(map[current[0]][current[1]]-map[current[0]+1][current[1]])
								&& R>=Math.abs(map[current[0]][current[1]]-map[current[0]+1][current[1]])) {
							queue.add(new int[] {current[0]+1, current[1]});
							ischoice[current[0]+1][current[1]]=true;
							area[current[0]+1][current[1]]=areaNum;
						}
						
						if(current[1]>0 && ischoice[current[0]][current[1]-1]==false
								&& L<=Math.abs(map[current[0]][current[1]]-map[current[0]][current[1]-1])
								&& R>=Math.abs(map[current[0]][current[1]]-map[current[0]][current[1]-1])) {
							queue.add(new int[] {current[0], current[1]-1});
							ischoice[current[0]][current[1]-1]=true;
							area[current[0]][current[1]-1]=areaNum;
						}
						
						if(current[1]<N-1 && ischoice[current[0]][current[1]+1]==false
								&& L<=Math.abs(map[current[0]][current[1]]-map[current[0]][current[1]+1])
								&& R>=Math.abs(map[current[0]][current[1]]-map[current[0]][current[1]+1])) {
							queue.add(new int[] {current[0], current[1]+1});
							ischoice[current[0]][current[1]+1]=true;
							area[current[0]][current[1]+1]=areaNum;
						}
						
					}
					areaNum+=1;
					maxNum = areaNum;
				}
				
			}
		}
		return area;
	}
}
