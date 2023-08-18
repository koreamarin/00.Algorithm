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
 * 메모리 : 12064kb
 * 시간 : 96ms
 * 
 * 풀이방법: 
 * bfs를 이용하여 탐색된 순서대로 1씩 증가시켜, N,M에 몇번째로 도달했는지 출력한다.
 * 
 */

public class BJ_02178_미로탐색_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken());
		int M=Integer.parseInt(ST.nextToken());
		// 배열 생성 및 키보드 입력 값 할당
		int[][] maze=new int[N][M];
		for(int i=0; i<N; i++) {
			String mazeLine=br.readLine();
			for(int j=0; j<M; j++) maze[i][j]=(int) mazeLine.charAt(j) - 48;
		}
		bfs(maze);		// bfs로 N,M에 몇번째로 도달했는지 출력하는 함수.
	}
	
	public static void bfs(int[][] maze) {
		int rowSize=maze.length;			
		int colSize=maze[0].length;
		Queue<int []> queue = new ArrayDeque<>();	// bfs 순회 순서를 저장할 큐
		int[][] visited = new int[rowSize][colSize];	// maze 크기의 배열을 본따서 각 각 노드들에 몇번째로 도달했는지를 정수형으로 저장할 배열
		
		queue.offer(new int []{0,0});		// 큐에 초기값 0,0 저장
		visited[0][0]=1;					// 첫번쨰 노드부터 1로 세므로, visited[0][0] 에 첫번째로 도달했다는 숫자 1 저장.
		
		int[] Rmove=new int[] {-1, 1,  0, 0};	// 상하좌우 Row 좌표
		int[] Cmove=new int[] { 0, 0, -1, 1};	// 상하좌우 Col 좌표
		
		while(!queue.isEmpty()) {				// 큐가 비어있지 않으면
			int[] current = queue.poll();		// 큐에서 하나 꺼냄.
			for(int i=0; i<4; i++) {			// 상하좌우 탐색
				if(		0<=current[0]+Rmove[i] && 		// 배열 밖이 아니면
						current[0]+Rmove[i]<rowSize && 	// 배열밖이 아니면
						0<=current[1]+Cmove[i] &&		// 배열밖이 아니면
						current[1]+Cmove[i]<colSize && 	// 배열밖이 아니면
						maze[current[0]+Rmove[i]][current[1]+Cmove[i]]!=0 &&			// 0이 아니라서 갈 수 있는 길이면
						visited[current[0]+Rmove[i]][current[1]+Cmove[i]]==0) {			// 0 이상은 방문한 곳이므로, 방문한곳이 아니라면
					queue.offer(new int[] {current[0]+Rmove[i], current[1]+Cmove[i]});	// 다음 방문지를 큐에 다음에 가야할 곳으로 추가.
					visited[current[0]+Rmove[i]][current[1]+Cmove[i]]=visited[current[0]][current[1]]+1;	// 다음 방문지에 현재 방문지의 값 +1 을 추가.
				}
			}
		}
		System.out.println(visited[rowSize-1][colSize-1]);	// N,M의 값을 출력
	}
}

