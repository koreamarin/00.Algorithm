package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_01260_DFS와BFS_류지원 {
	static boolean[] isVisited;
	static List<Integer>[] adjList;
	static int N, M, V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(ST.nextToken());			// 정점의 개수
		M=Integer.parseInt(ST.nextToken());			// 간선의 개수
		V=Integer.parseInt(ST.nextToken())-1;		// 탐색을 시작할 정점 번호
		adjList = new ArrayList[N];
		for(int n=0; n<N; n++) adjList[n]=new ArrayList<>();
		for(int m=0; m<M; m++) {
			ST = new StringTokenizer(br.readLine());
			int stt=Integer.parseInt(ST.nextToken())-1;
			int stp=Integer.parseInt(ST.nextToken())-1;
			adjList[stt].add(stp);
			adjList[stp].add(stt);
		}
		for(int n=0; n<N; n++) adjList[n].sort(Comparator.naturalOrder());

		isVisited=new boolean[N];
		dfs(V);
		System.out.println();
		isVisited=new boolean[N];
		bfs();
		System.out.println();
	}
	
	public static void dfs(int cnt) {
		System.out.print((cnt+1) + " ");
		isVisited[cnt]=true;
		for(int s=0; s<adjList[cnt].size(); s++) {
			int node = adjList[cnt].get(s);
			if(!isVisited[node]) dfs(node);
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();		
		queue.add(V);
		isVisited[V]=true;
		while(!queue.isEmpty()) {
			int crt=queue.poll();
			System.out.print((crt+1) + " ");
			for(Integer node : adjList[crt]) {
				if(!isVisited[node]) {
					isVisited[node]=true;
					queue.add(node);
				}
			}
		}
	}
}
