package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class D4_01218_괄호짝짓기_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<11; t++) {
			int N = Integer.parseInt(br.readLine());
			String G = br.readLine();
			Deque<Character> deq = new ArrayDeque<>();
			deq.clear();
			deq.addFirst(G.charAt(0));
			if (N%2==1) {
				System.out.println("#"+t+" "+0);
			}
			else {
				for(int n=1;n<N;n++) {
					if(deq.peekFirst()=='{' && G.charAt(n)=='}') {
						deq.removeFirst();
					} else if(deq.peekFirst()=='[' && G.charAt(n)==']') {
						deq.removeFirst();
					} else if(deq.peekFirst()=='(' && G.charAt(n)==')') {
						deq.removeFirst();
					} else if(deq.peekFirst()=='<' && G.charAt(n)=='>') {;
						deq.removeFirst();
					} else {
						deq.addFirst(G.charAt(n));
					}
				}
				System.out.println("#"+t+" "+1);
			}
		}
	}

}
