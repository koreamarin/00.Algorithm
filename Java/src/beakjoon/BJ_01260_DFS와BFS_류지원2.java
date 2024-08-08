package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/** 
 * @author "Ryu jiwon"
 * 시간 : 260ms
 * 풀이 : 
 * 인접행렬과 인접리스트로 그래프 자료를 저장 후,
 * DFS, BFS탐색함
 */

public class BJ_01260_DFS와BFS_류지원2 {
	static boolean[] isVisitedMatrix;
	static boolean[] isVisitedList;
	static int N, M, V;
	static boolean[][] adjMatrix;
	static List<ArrayList<Integer>> adjList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(ST.nextToken());	// 정점의 개수
		M = Integer.parseInt(ST.nextToken());	// 간선의 개수
		V = Integer.parseInt(ST.nextToken());	// 시작 정점의 번호
		
		// 인접 행렬
		adjMatrix = new boolean[N][N];
		
		// 방문 배열
		isVisitedMatrix = new boolean[N];
		isVisitedList = new boolean[N];
		
		// 인접 리스트
		adjList = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++) adjList.add(new ArrayList<Integer>());
		
		for(int m=0; m<M; m++) {
			ST = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(ST.nextToken());
			int node2 = Integer.parseInt(ST.nextToken());
			
			// 인접행렬에 추가
			adjMatrix[node1-1][node2-1]=true;
			adjMatrix[node2-1][node1-1]=true;
			
			// 인접리스트에 추가
			adjList.get(node1-1).add(node2-1);
			adjList.get(node2-1).add(node1-1);
		}
		
		for(ArrayList<Integer> list : adjList) {	// 인접리스트 정렬
			list.sort(Comparator.naturalOrder());
		}
		
		
		System.out.println("인접행렬");
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				System.out.print(adjMatrix[r][c] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("인접행렬 DFS");
		MatrixDFS(V-1);
		
		Arrays.fill(isVisitedMatrix, false);
		
		System.out.println();
		System.out.println();
		System.out.println("인접행렬 BFS");
		MatrixBFS(V-1);
		
		System.out.println();
		System.out.println();
		System.out.println("인접리스트");
		for(int r=0; r<N; r++) {
			List<Integer> a = adjList.get(r);
			System.out.print(r + " : ");
			for(int c=0; c<a.size(); c++) {
				System.out.print(a.get(c)+ " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("인접리스트 DFS");
		adjListDFS(V-1);
		
		Arrays.fill(isVisitedList, false);
		
		System.out.println();
		System.out.println();
		System.out.println("인접리스트 BFS");
		adjListBFS(V-1);
	}
	
	public static void MatrixDFS(int r) {
		isVisitedMatrix[r]=true;
		System.out.print((r+1)+" ");
		for(int i=0; i<N; i++) {
			if(adjMatrix[r][i] && !isVisitedMatrix[i]) MatrixDFS(i);
		}
	}
	
	public static void MatrixBFS(int r) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(r);
		isVisitedMatrix[r]=true;
		System.out.print((r+1)+" ");
		
		while(!q.isEmpty()) {
			int cnt = q.poll();
			for(int i=0; i<N; i++) {
				if(adjMatrix[cnt][i] && !isVisitedMatrix[i]) {
					isVisitedMatrix[i]=true;
					System.out.print((i+1)+" ");
					q.add(i);
				}
			}
		}
	}
	
	public static void adjListDFS(int r) {
		isVisitedList[r]=true;
		System.out.print((r+1)+" ");
		List<Integer> list = adjList.get(r);
		
		for(int l : list) {
			if(!isVisitedList[l]) 
				adjListDFS(l);
		}
	}
	
	public static void adjListBFS(int r) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(r);
		isVisitedList[r]=true;
		System.out.print((r+1)+" ");
		
		while(!q.isEmpty()) {
			int cnt = q.poll();
			List<Integer> list = adjList.get(cnt);
			
			for(int l : list) {
				if(!isVisitedList[l]) {
					isVisitedList[l]=true;
					System.out.print((l+1)+" ");
					q.add(l);
				}
			}
		}
	}

}