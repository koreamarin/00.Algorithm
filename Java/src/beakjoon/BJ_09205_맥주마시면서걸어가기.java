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
 * 시간 : 
 * 메모리 : 
 * 
 * 풀이방법 : 
 * 1. bfs 사용방법
 * 		1-1. 초기값 집 위치를 queue에 넣기
 * 		1-2. queue에 있는 위치를 꺼내서 1000m 이내인 것들 queue에 넣기 
 * 			a. visited 사용해서 이미 들른것들이나 들를것들은 계산에서 제외
 * 			b. 만약 페스티벌이 있다면 "happy" 출력한 뒤 프로그램 종료
 * 		1-3. 1-2에서 페스티벌이 발견될때까지 1-2 계속반복. 만약 1-2 while문을 탈출한다면 "sad" 출력후 프로그램 종료
 * 
 * 2. 플루이드 워셜 사용방법
 * 		2-1. 
 * 		2-2. 
 * 
 */

public class BJ_09205_맥주마시면서걸어가기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int T=Integer.parseInt(br.readLine());		// 테스트케이스 개수
		for(int t=0; t<T; t++) {
			int N=Integer.parseInt(br.readLine()); 	// 편의점의 개수
			int[][] Lct = new int[N+2][2];				// 집, N개의 편의점들, 페스티벌 위치 배열
			
			// 집, N개의 편의점들, 페스티벌 위치를 배열에 저장하기 위한 반복문
			for(int i=0; i<N+2; i++) {
				ST=new StringTokenizer(br.readLine());
				Lct[i]= new int[] {Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken())};
			}
			
			// BFS를 이용한 방법
			System.out.println(bfs(Lct, N));
		}
	}
	
	public static String bfs(int[][] Lct, int N) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N+2];
		
		queue.offer(Lct[0]);
		isVisited[0]=true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int i=0; i<N+2; i++) {
				if(isVisited[i]==false) {
					int x=current[0]-Lct[i][0];
					int y=current[1]-Lct[i][1];
					
					double distance= Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
					
					if(distance<=1000) {
						queue.offer(Lct[i]);
						isVisited[i]=true;
					}
				}
			}
			if(isVisited[N+1]) return "happy";
		}
		return "sad";
	}
}
