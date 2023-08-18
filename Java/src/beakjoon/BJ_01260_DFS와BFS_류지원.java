package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_01260_DFS와BFS_류지원 {
	static boolean[][] arr;
	static boolean[] dfsisvalid;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		N=Integer.parseInt(ST.nextToken());	// 노드 개수
		int M=Integer.parseInt(ST.nextToken());	// 간선 개수
		int V=Integer.parseInt(ST.nextToken());	// 시작 노드 번호
		arr=new boolean[N][N];
		dfsisvalid=new boolean[N];
		
		for(int i=0; i<M; i++) {
			ST=new StringTokenizer(br.readLine());
			int N1=Integer.parseInt(ST.nextToken());
			int N2=Integer.parseInt(ST.nextToken());
			arr[N1-1][N2-1]=arr[N2-1][N1-1]=true;
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
		
//		dfs(0, V-1);
//		System.out.println();
		bfs(V-1);
		

	}
	
	public static void bfs(int V) {
		Queue<Integer> Q = new ArrayDeque<>();
		boolean[] isvalid=new boolean[N];
		
		Q.offer(V);
		isvalid[V]=true;
		
		while(!Q.isEmpty()) {
			int C=Q.poll();
			
			System.out.println(C+1);
			
			for(int i=0; i<N; i++) {
				if(arr[V][i] && !isvalid[i]) {
					isvalid[i]=true;
					Q.offer(i);
					
				}
				
			}
			
		}
		
		
		
		
		
	}
	
	public static boolean dfs(int cnt, int V) {
		// 출력
		if(!dfsisvalid[V]) System.out.print(V+1 + " ");
		
		// 유도파트
		dfsisvalid[V]=true;
		for(int i=0; i<N; i++) if(arr[V][i] && !dfsisvalid[i]) if(dfs(cnt+1, i)) return true;
		dfsisvalid[V]=false;

		// 기저조건 : isvalid가 모두 true이면 return true 리턴
		if(N-1==cnt) {
			for(int i=0; i<N; i++) {
				if(dfsisvalid[N-1]) return true;		
			}
		}
		return false;
	}

}
