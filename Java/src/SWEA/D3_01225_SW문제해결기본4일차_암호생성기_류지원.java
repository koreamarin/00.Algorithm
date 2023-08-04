package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class D3_01225_SW문제해결기본4일차_암호생성기_류지원 {
	public static void main(String[] args) throws IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;	// 정수형 변수 N을 선언하고 키보드 입력문자열을 정수형으로 변환하여 N에 입력
		for(int t=1; t<11; t++) {		// 테스트케이스 10번 반복 실행
			br.readLine();				// 키보드 입력받기. 입력받은값은 따로 저장하지않고 버림.
			ST = new StringTokenizer(br.readLine());	// 키보드 2번쨰 입력받아 StringTokenizer에 추가.
			
			Deque<Integer> deq = new ArrayDeque<>();	// deque 선언 및 생성.
			for(int i=0; i<8; i++) deq.addLast(Integer.parseInt(ST.nextToken()));	// deque에 StringTokenizer로부터 문자열을 정수형으로 바꿔 입력
			
			int n=1;	// 정수형 변수 n 선언 및 1 입력
			int A=0;
			while(true) {	// 무한 반복문
				A = deq.removeFirst()-n;	// 큐의 맨 앞 숫자 삭제 및 입력하고 -1한 값을 A에 넣기
				if (A<=0) {	// A가 0이하라면 실행
					deq.addLast(0);	// 큐의 마지막에 0을 추가
					break;			// 반복문 종료.
				}
				else if (A>0) {	// A가 0 초과이면 실행
					deq.addLast(A);	// 큐의 마지막에 A를 추가
					n=(n%5)+1;		// n을 5로 나눈 나머지에 1추가한값을 n에 입력
				}
			}
			System.out.print("#" + t +" ");	// 테이스케이스 출력
			// 큐 값 출력
			for(int i=0; i<8; i++) System.out.print(deq.removeFirst()+" ");
			System.out.println();	// 한줄 띄우는 용도
		}
	}
}
