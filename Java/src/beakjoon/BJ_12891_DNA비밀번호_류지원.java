package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12891_DNA비밀번호_류지원 {

	public static void main(String[] args) throws IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열을 구분자를 인식하여 자동으로 나눠주는 StringTokenizer 선언.
		StringTokenizer ST;
		
		// 첫번째 입력 라인 처리
		// 문자열을 구분자를 인식하여 자동으로 나눠주는 StringTokenizer를 생성하여 키보드로 입력받은 값을 매개변수로 넣음.
		ST = new StringTokenizer(br.readLine());	
		int S = Integer.parseInt(ST.nextToken());	// StringTokenizer의 첫번째 문자열을 정수로 바꿔 S에 입력
		int P = Integer.parseInt(ST.nextToken());	// StringTokenizer의 첫번째 문자열을 정수로 바꿔 S에 입력
		
		// 두번째 입력 라인 처리
		String DNA = br.readLine();			// 문자열을 키보드로 입력받아 문자열변수로 선언한 DNA에 입력
		char[] DNAArr = new char[DNA.length()];	// char형 배열 DNAArr를 선언 및 DNA 문자열의 길이만큼 배열 생성.
		for(int i=0;i<DNA.length(); i++) DNAArr[i]=DNA.charAt(i);	// 반복문을 활용하여 DNA문자열에 있는 문자를 순서대로 DNAArr배열에 입력
		
		// 세번째 입력 라인 처리
		int[] charNum = new int[4];	// A,C,G,T의 최소로 사용해야하는 횟수를 저장한 배열
		ST = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++)
			charNum[i]=Integer.parseInt(ST.nextToken());
		
		// 각 문자열 사용횟수 선언 및 초기 값 입력 
		int[] UsedChar = new int[4];	// P의 길이로 만든 비밀번호에 A,C,G,T를 사용한 횟수를 저장한 배열
		for(int i=0; i<P; i++) {
			switch(DNAArr[i])  {		// DNAArr[i]를 참조하여 아래 case를 만족하면 구현부 실행
				case 'A' : UsedChar[0]++; break;	// DNAArr[i]가 A이면 UsedChar[0] 1 증가 및 switch문 종료
				case 'C' : UsedChar[1]++; break;	// DNAArr[i]가 B이면 UsedChar[1] 1 증가 및 switch문 종료
				case 'G' : UsedChar[2]++; break;	// DNAArr[i]가 C이면 UsedChar[2] 1 증가 및 switch문 종료
				case 'T' : UsedChar[3]++; break;	// DNAArr[i]가 D이면 UsedChar[3] 1 증가 및 switch문 종료
			}
		}
		
		// 초기 탐색 조건을 만족하는지 확인.
		int sum=0;									// sum은 비밀번호의 조건을 만족하는 비밀번호를 얼마나 만들 수 있는지 카운팅 숫자를 담을 변수.
		if(PWValid(UsedChar, charNum)) sum++;		// PWValid메서드는 비밀번호의 조건을 만족하면 true를, 만족하지 않으면 false를 반환하여 조건에 만족하면 sum을 1 증가시킴.
		
		for(int i=1; i<S-P+1; i++) {				// 반복문으로 순차적으로 배열의 탐색구간을 sweep할 반복문.
			switch(DNAArr[i-1])  {					// 배열 탐색구간인 window 밖으로 나간 문자의 개수를 1 감소시키는 switch문.
				case 'A' : UsedChar[0]--; break;
				case 'C' : UsedChar[1]--; break;
				case 'G' : UsedChar[2]--; break;
				case 'T' : UsedChar[3]--; break;
			}			
			switch(DNAArr[i+P-1])  {				// 배열 탐색구간인 window 안으로 들어온 문자의 개수를 1 증가시키는 switch문.
				case 'A' : UsedChar[0]++; break;
				case 'C' : UsedChar[1]++; break;
				case 'G' : UsedChar[2]++; break;
				case 'T' : UsedChar[3]++; break;
			}
			// 이동시킨 윈도우의 문자개수를 모두 파악했다면 현재 윈도우에 있는 문자가 비밀번호 조건에 해당되는지 확인.
			if(PWValid(UsedChar, charNum)) sum++;	// 만약 비밀번호 조건 파악하는 메서드가 true를 반환한다면 sum을 1 증가시킴.
		}
		System.out.println(sum);	// sum 출력
	}

	// 매개변수로 탐색하고 있는 구간의 문자 개수와 비밀번호 생성조건 문자개수를 배열로 받는다. 조건에 해당하면 true를 반환. 조건에 해당하지 않으면 false를 반환.
	public static boolean PWValid(int[] UsedChar, int[] charNum) {
		for(int i=0; i<4; i++) if(UsedChar[i]<charNum[i]) return false;
		return true;
	}

}
