package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링_류지원 {
	static int N;
	static boolean[] isSelected;
	static int[] numbers;
	
	
	public static class Node{
		int vertex; Node next;
		Node(int vertex, Node next) {
			this.vertex=vertex;
			this.next=next;
		}
		@Override
		public String toString() {
			return "Node[vertex=" + vertex + ", next=" + next + "]";
		}
	}	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		N=Integer.parseInt(br.readLine());		// 구역의 개수
		int[] AreaPopulationArr=new int[N];		// 각 구역의 인구수 배열 
		ST=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) AreaPopulationArr[i]=Integer.parseInt(ST.nextToken());
		Node[] adjList = new Node[N];			// 노드정보, 노드가 연결된 다른 노드가 담겨있는 인접리스트.
		for(int i=0; i<N; i++) {
			ST=new StringTokenizer(br.readLine());
			int adjNodeNum = Integer.parseInt(ST.nextToken());
			for(int n=0; n<adjNodeNum; n++) adjList[i]=new Node(Integer.parseInt(ST.nextToken()), adjList[i]);
		}
		
		// 부분집합
		isSelected=new boolean[N];
		numbers=new int[N/2];
		subset(0);
		

	}
	
	public static void subset(int cnt) {
		if(cnt==N) {
			int T=0, F=0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) T++;
				else F++;
			}
			if(T==0 || F==0) return;
			
			int[] subset1=new int[T], subset2=new int[F];
			for(int i=0, n1=0, n2=0; i<N; i++) {
				if(isSelected[i]) subset1[n1++]=i;
				else subset2[n2++]=i;
			}
			// 조합1를 dfs하여 조합1에 해당하는 원소를 모두 탐색했는지 확인.
			// 조합2를 dfs하여 조합2에 해당하는 원소를 모두 탐색했는지 확인.

			System.out.println(Arrays.toString(subset1)+ "\t" + Arrays.toString(subset2));
			return;
		}
		
		isSelected[cnt]=true;
		subset(cnt+1);
		isSelected[cnt]=false;
		subset(cnt+1);
		
	}
	

	
}
