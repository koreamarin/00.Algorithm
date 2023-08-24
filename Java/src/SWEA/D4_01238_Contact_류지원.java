package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 18676kb
 * 실행시간 : 129ms
 * 
 * 풀이방법 :
 * 가장 깊은곳의 가장 큰 노드를 찾아야하므로 depth를 구분하기 위해서는 bfs를 이용한 그래프 탐색이 유리하여 이 방식을 사용하였다.
 *
 */

public class D4_01238_Contact_류지원 {
	static Node[] adjList;
	
	static public class Node{		// 노드 정보를 저장하기 위한 클래스
		int vertex; Node next;
		Node(int vertex, Node next) {
			this.vertex=vertex;
			this.next=next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		for(int t=1; t<11; t++) {
			ST=new StringTokenizer(br.readLine());
			int L=Integer.parseInt(ST.nextToken()), sttNode=Integer.parseInt(ST.nextToken());
			adjList=new Node[101];
			ST=new StringTokenizer(br.readLine());
			for(int l=0; l<L/2; l++) {
				int from = Integer.parseInt(ST.nextToken()), to = Integer.parseInt(ST.nextToken());
				adjList[from]=new Node(to, adjList[from]);
			}
			
			ArrayDeque<Integer> queue=new ArrayDeque<>();
			boolean[] visited = new boolean[101];
			
			queue.offer(sttNode);
			visited[sttNode]=true;
			int max=0;
			ArrayList<Integer> list=new ArrayList<>();
			
			while(!queue.isEmpty()) {		// BFS
				int size=queue.size();		// BFS를 실행하는데 각 depth를 구분하기 위해 size별로 나눔
				max = 0;

				for(int i=0; i<size; i++) {	// BFS를 실행하는데 각 depth마다 구분하기 위함
					int current = queue.poll();
					for(Node temp=adjList[current]; temp!=null; temp=temp.next) {
						if(!visited[temp.vertex]) {
							queue.offer(temp.vertex);
							visited[temp.vertex]=true;
							max=Math.max(max, temp.vertex);
						}
					}
				}
				list.add(max);
			}
			System.out.println("#"+t+" " + list.get(list.size()-2));
		}

	}

}
