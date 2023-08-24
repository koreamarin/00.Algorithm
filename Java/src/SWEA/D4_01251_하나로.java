package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D4_01251_하나로 {
	static class Vertex implements Comparable<Vertex> {
		int no; double weight;
		public Vertex(int no, double weight) {
			this.no=no;
			this.weight=weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {						// 테스트 케이스
			int N=Integer.parseInt(br.readLine());		// 섬의 개수
			double[][] islandLo=new double[N][2];		// 각 섬들의 위치배열
			for(int j=0; j<2; j++) {					// 각 섬들의 위치배열에 입력받은 값 할당
				ST=new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) islandLo[i][j]=Double.parseDouble(ST.nextToken());
			}
			double E=Double.parseDouble(br.readLine());	// 세율
			
			// 가중치 구하기
			double[][] adjMatrix=new double[N][N];
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					double money=Math.pow(Math.abs(islandLo[i][0]-islandLo[j][0]),2)+Math.pow(Math.abs(islandLo[i][1]-islandLo[j][1]),2);
					adjMatrix[i][j]=adjMatrix[j][i]=money*E;
				}
			}
			// 방문정점(트리정점표시)
			boolean[] visited=new boolean[N];
			
			PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
			
			pQueue.offer(new Vertex(0, 0));
			
			double result=0;	// 최소신장트리 비용
			double min=0; int minVertex=0, cnt=0;
			
			while(!pQueue.isEmpty()) {
				// step1 : 미방문(비트리) 정점 중 최소간선비용의 정점을 선택
				Vertex current = pQueue.poll();
				minVertex=current.no;
				min=current.weight;
				
				if(visited[minVertex]) continue;
				
				// step2 : 방문(트리) 정점에 추가
				visited[minVertex]=true;		// 방문 처리
				result += min;
				if(++cnt==N) break;
				
				// step3 : 트리에 추가된 새로운 정점 기준으로 비트리 정점과의 간선비용 고려
				for(int i=0; i<N; i++) {
					if(!visited[i] && adjMatrix[minVertex][i]!=0) {
						pQueue.offer(new Vertex(i, adjMatrix[minVertex][i]));
					}
				}
			}
			
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<N; j++) System.out.print(adjMatrix[i][j] + " ");
//				System.out.println();
//			}
			System.out.println("#" + t + " " + (long)result);
		}

	}

}
