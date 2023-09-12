package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

import beakjoon.BJ_14567_선수과목_류지원.Node;

public class BJ_18352_특정거리의도시찾기_류지원 {

	static class Node {
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(ST.nextToken());		// 도시의 개수
		int M=Integer.parseInt(ST.nextToken());		// 도로의 개수
		int K=Integer.parseInt(ST.nextToken());		// 거리 정보
		int X=Integer.parseInt(ST.nextToken());		// 출발 도시의 번호
		
		Node[] adjList= new Node[N];
		
		for(int i=0; i<M; i++) {			// adjList 배열의 각 Node에 간선정보 입력하는 반복문
			ST=new StringTokenizer(br.readLine());
			int from = Integer.parseInt(ST.nextToken())-1;
			int to = Integer.parseInt(ST.nextToken())-1;
			adjList[from] = new Node(to, adjList[from]);
		}
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(X-1);
		int cnt=1;
		while(!queue.isEmpty()) {
			int size=queue.size();
				while(size>0) {
				int current = queue.poll();
				for(Node temp=adjList[current]; temp != null; temp = temp.next) {
					queue.offer(temp.vertex);
				}
				
			}
			
		}
		
	}
 
}
