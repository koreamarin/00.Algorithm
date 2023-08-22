package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 
 * @author 류지원
 * 메모리 : 12520kb
 * 시간 : 160ms
 * 
 * 풀이방법 : 
 * 4개의 간선으로 한번도 방문하지 않은 원소 5개를 방문하면 되므로
 * 인접리스트로 구현한 그래프와 dfs, 방문을 체크하는 배열을 이용하였다.
 * 인접행렬을 이용했을 때에는 시간초과가 났다.
 *
 */

public class BJ_13023_ABCDE_류지원 {
	static boolean[] isSelected; static Node[] adjList;
	
	static class Node {		// 인접리스트를 구현하기 위한 인접원소를 저장하기위한 클래스.
		int vertex; Node next;
		Node(int vertex, Node next) {	// 생성자
			this.vertex=vertex;
			this.next=next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken());
		int M=Integer.parseInt(ST.nextToken());
		
		isSelected=new boolean[N];	// 원소들의 방문 체크하는 배열
		adjList=new Node[N];
		
		for(int m=0; m<M; m++) {
			ST=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(ST.nextToken());
			int to=Integer.parseInt(ST.nextToken());
			adjList[from]=new Node(to, adjList[from]);	// 간선정보를 저장.
			adjList[to]=new Node(from, adjList[to]);	// 간선정보 저장
		}
		
		for(int i=0; i<N; i++) {
			if(dfs(0, i)) {			// 0번 원소부터 N번 원소까지 DFS 시작.
				System.out.print(1);	// dfs메서드에서 true가 반환되면 조건을 만족한 것이므로 1 출력
				return;					// 출력후에 시스템 종료를 위해 return
			}
		}
		System.out.print(0);			// 앞단에서 원소들을 sweep 하며 dfs를 했는데, 조건을 만족하지 못했다면 0을 출력
	}
	
	public static boolean dfs(int cnt, int o) {
		if (cnt==5) return true;	// 기저조건. cnt가 5가 되면 4개의 간선으로 중복되지않게 5개의 원소를 탐색한 것이므로 true 리턴
		if(!isSelected[o]) {		// 원소를 아직 방문하지 않았을때
			isSelected[o]=true;		// 원소를 방문 한 것으로 true로 값을 바꿈.
			for(Node temp=adjList[o]; temp!=null; temp=temp.next) // 인접리스트로 해당 원소의 인접한 원소들을 뽑아올 목적의 반복문
				if(dfs(cnt+1, temp.vertex)) 	// 뽑아온 인접한 원소를 dfs 실행
					return true;				// 기저조건을 만족하고 true가 반환되면 연쇄적으로 true가 반환되어 dfs를 탈출할때까지 true를 반환함.
			isSelected[o]=false;	// 해당원소의 탐색을 완료하였다면 방문배열에 false를 줌.
		}
		return false;	// 앞단에서 true가 반환되지 않았다면 4개의 간선으로 원소5개 방문을 실패한것으로 false 반환.
	}
}
