package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_01158_요세푸스문제_류지원 {

	public static void main(String[] args) throws IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열을 구분자를 인식하여 자동으로 나눠주는 StringTokenizer 선언 및 키보드로 입력받은 값으로 생성
		StringTokenizer ST = new StringTokenizer(br.readLine());
		// 문자열을 추가하여 한번에 출력하는 기능을 제공해주는 StringBuilder 객체 선언 및 생성
		StringBuilder SB = new StringBuilder();
		int N = Integer.parseInt(ST.nextToken());	// 정수형 변수 N 선언 및 입력받은 첫번째 값 제공
		int K = Integer.parseInt(ST.nextToken());	// 정수형 변수 K 선언 및 입력받은 첫번째 값 제공
		int[] arr = new int[N];		// 1번부터 N번까지 번호를 부여하기 위한 배열 N개 생성
		
		ArrayList<Integer> list = new ArrayList<>();	// 리스트 선언 및 생성
		for(int i=0; i<N; i++) list.add(i+1);	// 리스트에 1번부터 N번까지 입력
		
		int j=K-1;	// j는 K-1로 입력
		int i=0;	// i에 0 부여

		while(list.size()>0) {	// 리스트사이즈가 0이 될때까지 반복문 실행
			// 리스트 j번쨰 인덱스를 제거하고 arr[i]에 제거된 인덱스 값을 입력. 그 후 i에 1을 추가함.
			arr[i++]=list.remove(j);
			// 리스트의 크기가 0이 아니라면 j값을 결정해줌.
			// j+K+1값이 리스트 사이즈보다 크거나 같다면 앞쪽의 연산값을, 아니라면 뒤쪽의 연산값을 j에 입력한다.
			if(list.size()!=0) j=j+K-1>=list.size() ? (j+K-1)%list.size() : j+K-1;
		}

		SB.append("<");	// 출력을 위해 "<" 추가.
		for(int n=0; n<N-1; n++) SB.append(arr[n] + ", "); // 출력을 위해 스트링빌더에 배열의 원소값 추가.
		SB.append(arr[N-1] + ">");	// 출력을 위해 스트링빌더에 ">" 추가
		System.out.println(SB);	// 스트링빌더 출력
	}
}
