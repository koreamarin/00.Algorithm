package other;

/**
 * @author 류지원
 * 문제 : 마이쮸 누가 가져갈까
 *
 *
 * key는 줄이고 value는 받아야 하는 개수이다.
 * 
 * 1. deq의 출력을 key로 하고, key의 value만큼 뺀다.			-> mychu.get(deq.getLast())
 * 2. deq를 출력하고 다시 넣어 줄세운다.		.				-> deq.addFirst(deq.removeLast());
 * 3. 새로 들어온 번호에 deq.addFirst(n+1) 한다.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class 마지막마이쮸누가가져갈까_류지원 {

	public static void main(String[] args) {
		int N=20;				// 마이쮸의 개수
		// 몇번의 사람이 몇개의 마이쮸를 가져갈지 key와 value를 저장한 해쉬맵
		// key가 사람의 번호, value는 다음번에 마이쮸를 가져갈 개수이다.
		HashMap<Integer,Integer> mychu = new HashMap<>();
		Deque<Integer> deq =  new ArrayDeque<>();	// 큐를 사용하여 마이쮸를 가져갈 사람들을 나열
		
		mychu.put(1, 1);	// 초기값으로 1번사람에게 1개의 마이쮸를 가져가야함을 등록
		deq.addFirst(1);	// 초기값으로 que에 1번사람을 세움.
		int n=0;	// n은 마이쮸를 가져갈 사람의 번호.
		while(N>0) { // N이 0 초과일때만, 즉 N이 0이하가 될때까지 마이쮸 나눠주기를 반복함.
			n = deq.getLast();	// n은 마이쮸를 받아갈 사람의 번호. 큐에서 마이쮸를 받을 사람을 출력한다.
			N-=mychu.get(n);					// 마이쮸를 나눠줌. 마이쮸를 받을 사람에게 그 사람이 받아가야할 개수를 마이쮸개수(N)에서 뺀다.
			mychu.put(n, mychu.get(n)+1);		// 현재 받은 사람이 다음번에는 현재 받은 개수에 1개를 더 받아가야함을 해쉬맵에 새로 설정한다.
			mychu.put(deq.size()+1, 1);			// 현재 기다리던 사람들수에 +1 번호를 가진 사람의 마이쮸 받아야할 개수를 추가한다.
			
			deq.addFirst(deq.removeLast()); 	// 현재 받은 사람을 맨 뒤의 que로 넣는다.
			deq.addFirst(deq.size()+1);			// 현재 기다리던 사람들수에 +1 번호를 가진 사람을 que에 추가한다.
		}
		System.out.println(n);	// 반복문을 빠져나오면 마이쮸를 다 준 것이므로, 마지막으로 마이쮸를 줬던 사람의 번호 n을 출력한다.
	}
}
