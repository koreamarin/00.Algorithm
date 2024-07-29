package beakjoon;

import java.io.*;

public class BJ_05639_이진검색트리 {
	public static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node head = new Node(Integer.parseInt(br.readLine()), null, null);
		String value;
		while((value = br.readLine()) != null && !value.isEmpty())  {
			inputNode(head, Integer.parseInt(value));
		}
		postOrder(head);
	}
	
	public static void inputNode(Node node, int value) {
		if(node.value > value) {
			if(node.left == null) 		node.left = new Node(value, null, null);
			else if(node.left != null) 	inputNode(node.left, value);
		}
		else if(node.value < value) {
			if(node.right == null)		node.right = new Node(value, null, null);
			else if(node.right != null) inputNode(node.right, value);
		}
	}
	
	private static void postOrder(Node node) {
		if(node==null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}
}
