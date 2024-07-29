package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01991_트리순회_류지원 {
	static Node head = new Node('A', null, null);
	
	public static class Node{
		char value;
		Node left;
		Node right;
		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			ST=new StringTokenizer(br.readLine());
			char value = ST.nextToken().charAt(0);
			char left = ST.nextToken().charAt(0);
			char right = ST.nextToken().charAt(0);
			insertNode(head, value, left, right);
		}
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
		System.out.println();
	}
	
	public static boolean insertNode(Node node, char value, char left, char right) {
		if(node.value==value) {	// 기저조건
			node.left = left == '.' ? null : new Node(left, null, null);
			node.right = right == '.' ? null : new Node(right, null, null);
			return true;
		}
		// 유도파트
		if(node.left!=null && insertNode(node.left,  value, left, right)) 		return true;
		else if(node.right!=null && insertNode(node.right, value, left, right))	return true;
		return false;
	}
	
	private static void preOrder(Node node) {	// 전위순회
		System.out.print(node.value);
		if(node.left!=null) preOrder(node.left);
		if(node.right!=null) preOrder(node.right);
	}
	
	private static void inOrder(Node node) {	// 중위순회
		if(node.left!=null) inOrder(node.left);
		System.out.print(node.value);
		if(node.right!=null) inOrder(node.right);
	}
	
	private static void postOrder(Node node) {	// 후위순회
		if(node.left!=null) postOrder(node.left);
		if(node.right!=null) postOrder(node.right);
		System.out.print(node.value);
	}
}
