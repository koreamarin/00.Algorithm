package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 시간 : 
 * 메모리 : 
 * 풀이방법 : 
 *
 */
public class BJ_01967_트리의지름_류지원_실패 {
	static List<Node> leafNodeList = new ArrayList<Node>();
	static int[] wightMap;
	static Node[] nodeArr; 
	
	public static class Node {
		Node parent;
		int value;
		int edge;
		int level;
		List<Node> childList = new ArrayList<Node>();
		
		public Node(Node parent, int value, int edge, int level, Node child) {
			this.parent = parent;
			this.value = value;
			this.edge = edge;
			this.level = level;
			if(child!=null) childList.add(child);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		wightMap = new int[N];
		nodeArr = new Node[N];
		
		Node head = new Node(null, 1, 0, 1, null);
		nodeArr[0]=head;
		
		for(int n=0; n<N-1; n++) {
			ST = new StringTokenizer(br.readLine());
			int parentValue = Integer.parseInt(ST.nextToken());
			int childValue = Integer.parseInt(ST.nextToken());
			int edge = Integer.parseInt(ST.nextToken());
			
			Node newNode = new Node(null, childValue, edge, 0, null);
			nodeArr[childValue-1]=newNode;
		
			insertNode(head, newNode, parentValue, 1, edge);
		}
		
//		for(Node node : nodeArr) {
//			System.out.println(node.value);
//		}
		
		leafNodeList.add(nodeArr[0]);
		searchLeaf(head);	// 단말노드 찾는 함수
		
		int maxWeight = 0;
		
//		 2개의 단말노드의 거리를 찾기 위해서는 최소공통조상을 먼저 찾는다.
//		 그리고 각 단말노드에서 최소공통조상까지의 간선합을 구하여 합하면 된다.
		for(int s1=0; s1<leafNodeList.size()-1; s1++) {
			for(int s2=s1+1; s2<leafNodeList.size(); s2++) {
				Node leafNode1 = leafNodeList.get(s1);
				Node leafNode2 = leafNodeList.get(s2);
				
				int LCA = LCA(leafNode1, leafNode2);
				int weight1 = wightMap[leafNode1.value-1];
				int weight2 = wightMap[leafNode2.value-1];
				
				int subWeight = wightMap[LCA-1] * 2;
				
				maxWeight = Math.max(maxWeight, weight1 + weight2 - subWeight);
			}
		}
		
		System.out.println(maxWeight);
	}
	
	
	public static int LCA(Node node1, Node node2) {
		System.out.println(node1.value + " " + node2.value);
		if(node1.level
				>
		node2.level) 	{
			
			return LCA(node1.parent, node2);
		}
			
		else if(node1.level<node2.level) 		return LCA(node1, node2.parent);
		else if(node1.level==node2.level) {
			if(node1.value!=node2.value) 		return LCA(node1.parent, node2.parent);
			else if(node1.value==node2.value) 	return node1.value;
		}
		return 0;
	}
	
	public static void searchLeaf(Node node) {
		if(node.childList.size()==0) {
			leafNodeList.add(node);
			return;
		}
		for(Node childNode : node.childList) searchLeaf(childNode);
	}
	
	
	public static void insertNode(Node node, Node childNode, int parentValue, int level, int totalEdge) {
		if(node.value==parentValue) {
			childNode.parent = node;
			childNode.level = level;
			
			node.childList.add(childNode);
			wightMap[childNode.value-1]=totalEdge;
		}
		else {
			for(Node node1 : node.childList) {
				insertNode(node1, childNode, parentValue, level+1, totalEdge+node1.edge);
			}
		}
	}

}
