package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1. 다익스트라 (가중치가 있는 그래프에서의 최단거리) V
// 2. BFS 누적합

public class BJ_04485_녹색옷입은애가젤다지_류지원 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		for(int t=1;true;t++) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			int[][] map = new int[N][N];
			for(int i=0; i<N; i++) {		// 도둑루피 배치정보 입력받기.
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}
			
			int[][] mapNum = new int[N][N];	// map에 번호매기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					mapNum[i][j]=(i*N)+j;
				}
			}
			
//			for(int i=0; i<N; i++) System.out.println(Arrays.toString(mapNum[i]));
			
			// 인접행렬
			int[][] adjMatrix = new int[N*N][N*N];
			for(int i=0; i<N*N; i++) Arrays.fill(adjMatrix[i], -1);
			
			
			int[] di = {-1, 1, 0, 0};
			int[] dj = {0, 0, -1, 1};
			
			
			// 인접행렬에 간선값 넣기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					for(int d=0; d<4; d++) {	// 상하좌우
						if(inRange(i+di[d], j+dj[d])) {
							adjMatrix[mapNum[i][j]][mapNum[i+di[d]][j+dj[d]]] = map[i+di[d]][j+dj[d]];
							adjMatrix[mapNum[i+di[d]][j+dj[d]]][mapNum[i][j]] = map[i][j];
						}
					}
				}
			}
			
//			for(int i=0; i<N*N; i++) System.out.println(Arrays.toString(adjMatrix[i]));
			
			boolean[] visited = new boolean[N*N];
			int INF = Integer.MAX_VALUE;
			int[] distance = new int[N*N];
			Arrays.fill(distance, INF);
			distance[0]=map[0][0];
			int min, stopOver;
			for(int i=0; i<N*N; i++) {	// 모든 정점을 다 처리할떄까지 반복
				// step 1: 미방문 정점 중 출발지에서 가장 가까운 정점을 경유지로 선택
				stopOver = -1;
				min = INF;
				for(int j=0; j<N*N; j++) {
					if(!visited[j] && min > distance[j]) {
						min = distance[j];
						stopOver=j;
					}
				}
				if(stopOver == -1) {
					break;
				}
				
				// step 2: 방문처리
				visited[stopOver] = true;
				
				// 상황에 따라 처리 : 경유지가 곧 도착지면 끝내기 (출발지에서 모든 정점으로의 최단거리를 구할시에는 break하지 말 것!!)
				if(stopOver == N*N-1) break;
				
				// step 3: 경유지를 이용하여 미방문 정점들의 출발지에서 자신으로의 최소비용 고려
				for(int j=0; j<N*N; j++) {
					if(adjMatrix[stopOver][j]>=0) {
						if(!visited[j] && distance[j] > min+adjMatrix[stopOver][j]) {
							distance[j] = min + adjMatrix[stopOver][j];
						}
					}
				}
//				System.out.println(Arrays.toString(distance));
			}
			System.out.println("Problem " + t + ": " + distance[N*N-1]);
		}

	}
	public static boolean inRange(int i, int j) {
		if(i<0) return false;
		else if(i>N-1) return false;
		else if(j<0) return false;
		else if(j>N-1) return false;
		return true;
	}

}
