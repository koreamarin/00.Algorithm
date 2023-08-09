package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class BJ_11286_절댓값힙_류지원 {	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
		PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
		
		for(int n=0; n<N; n++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0) {
				Integer out = priorityQueueLowest.poll();
				if(out==null) {
					System.out.println(0);
				} else {
					System.out.println(out);
				}
			} else priorityQueueLowest.add(input);
		}
		
		System.out.println(priorityQueueLowest.poll());
	}

}
