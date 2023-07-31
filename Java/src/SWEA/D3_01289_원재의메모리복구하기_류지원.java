package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** @author 류지원
 * 	<pre>
 *		원메모리값을 입력받고, 똑같은 크기의 배열을 만든 후,
 *		값을 바꾼 횟수를 세가면서 원메모리값과 같게 만들어 나간다.
 * 	</pre>
 */
public class D3_01289_원재의메모리복구하기_류지원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테스트 케이스 개수 T 선언 및 저장. 입력받고 Int형으로 변환.
		int T = Integer.parseInt(br.readLine());

		// 테스트케이스 T만큼 반복
		for(int t=0;t<T;t++) {
			String orgMmyStr = br.readLine();	// 원상태 메모리값 입력받기.
			int orgMmyNum=orgMmyStr.length();	// 원상태 메모리값 bit 수 저장.
			int[] orgMmy = new int[orgMmyNum];	// 원상태 메모리값 bit 수를 가진 배열생성
			int[] Mmy = new int[orgMmyNum];		// 원상태 메모리값 bit 수를 가진 배열생성
			int sum=0;							// 변환횟수를 저장할 s변수 선언 및 0저장.
			for(int i=0; i<orgMmyNum;i++) {		// orgMmy배열에 원상태 메모리값 저장. Mmy에는 모두 0을 저장.
				orgMmy[i]=Integer.parseInt(String.valueOf(orgMmyStr.charAt(i)));
				Mmy[i]=0;
			}
			for(int i=0; i<orgMmyNum;i++) {		// 메모리크기만큼 반복문 실행
				if(orgMmy[i]!=Mmy[i]){			// 원 메모리와 현재 메모리의 값이 다를떄
					sum++;						// 변환횟수 1추가.
					// 현재 메모리의 현재 인덱스와 그 뒤의 값을 모두 현재 참조하고 있는 원 메모리인덱스 값으로 설정.
					for(int j=i; j<orgMmyNum; j++) Mmy[j]=orgMmy[i];
				}
			}

			System.out.println("#" + (t+1) + " " + sum);	// 테스트 횟수와 메뫼리 변환횟수 sum 출력
		}
	}
}
