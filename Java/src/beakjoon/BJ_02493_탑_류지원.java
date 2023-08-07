package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_02493_탑_류지원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		StringBuilder SB = new StringBuilder();
		
		// 첫째줄 입력
		int N = Integer.parseInt(br.readLine());
		// 둘째줄 입력
		ST = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) list.add(Integer.parseInt(ST.nextToken()));
		// 필요 변수 선언
		Deque<Integer> deq = new ArrayDeque<>();
		// 구현 시작
		// 덱에 첫번째 값 넣기.
		
//		
		
		for(int i=N-1; i>=0; i--) {
			System.out.println(list.get(i));
			deq.addFirst(list.get(i));
			
			for(int A : deq) {
				System.out.println(A)
			}
			
		}
		
		
		
		
		
		System.out.println(SB);
		
		

	}

}
