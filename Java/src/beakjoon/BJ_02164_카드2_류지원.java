package beakjoon;

/**
 * @author 류지원
 * 문제 : BEAKJOON 2164 카드2
 *
 * 메모리 사용량 : 23728kb
 * 처리 시간 : 124ms
 *
 * 풀이 방식 :
 * 요구하는 형식이 que의 방식과 유사하다.
 * que를 사용하여 한번은 출력하고, 한번은 출력한 값을 다시 input하는 방식으로
 * 마지막으로 남을 숫자를 추적한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ_02164_카드2_류지원 {
	public static void main(String[] args) throws IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 정수형 변수 N을 선언하고 키보드 입력문자열을 정수형으로 변환하여 N에 입력
		int N = Integer.parseInt(br.readLine());
		// 원소값으로 정수형변수를 받는 deque를 선언하고 생성
		Deque<Integer> deq = new ArrayDeque<>();
		// 1~N까지 que에 push
		for(int n=1; n<N+1; n++) deq.addFirst(n);
		// N-1번 반복하는 함수
		for(int n=0; n<N-1; n++) {
			deq.pollLast();	// que에서 pop을 함
			deq.addFirst(deq.pollLast());	// que에서 pop을 하고 반환된 값을 다시 추가
		}
		System.out.println(deq.pollLast());	// 마지막에 남은 숫자 출력
	}
}
