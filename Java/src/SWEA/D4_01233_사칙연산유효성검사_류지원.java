package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * 
 * @author 류지원
 * 메모리 : 19352kb
 * 실행시간 : 111ms
 * 
 * 종단노드는 숫자, 종단 노드가 아닌부분은 연산자여야함을 기준으로
 * 위에 사항에 해당되지 않으면 0을반환, 위의 사항에 해당되면 1을 반환하는 함수를 만듦. 
 *
 */

public class D4_01233_사칙연산유효성검사_류지원 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder SB = new StringBuilder();
		// SB에 테스트 케이스를 결과 문자열을 추가.
		for(int t=1; t<11; t++) SB.append("#" + t + " " + valid() + "\n");
		System.out.print(SB);	// 테스트 케이스 출력
	}
	// 종단노드는 숫자, 종단노드가 아닌 노드는 연산자인지 아닌지 확인하는 메서드.
	public static int valid() throws IOException {
		StringTokenizer ST;
		int N = Integer.parseInt(br.readLine());	// 노드의 개수
		String[] arr = new String[N];	// 문자열을 담을 배열.
		for(int n=0; n<N; n++) arr[n]=br.readLine();	// 각 노드에 값 입력
		for(int n=0; n<N; n++) {	// 노드의 값을 입력받고 값을 탐색하는 반복문
			ST=new StringTokenizer(arr[n]);
			int cnt=ST.countTokens(); ST.nextToken();	// 하위 노드가 있는지 아닌지 확인하는 변수
			if(cnt==4) {	// token의 수가 4라면 하위 노드가 있는것. 하위노드가 있다면 실행
				int b=ST.nextToken().charAt(0); 	// 입력받은 문자열을 문자로 변환하여 아스키코드를 b에 입력
				if(b!=43 && b!=45 && b!=42 && b!=47) return 0;	// -,+,*,/에 해당하는 아스키코드 43,45, 46, 42가 아니라면 0을 반환
			} else {	// 위 조건에 해당되지 않을 때 실행
				int b=ST.nextToken().charAt(0);	// 입력받은 문자열을 문자로 변환하여 아스키코드를 b에 입력
				if(b<48 && b>57) return 0;	// 0~9에 해당하는 아스키코드에 해당하지 않는다면 0을 반환
			}
		}
		return 1;	// 위 반복문에서 0으로 반환되지 않았다면 트리구조는 연산가능한 트리구조이므로 1을 반환
	}
}
