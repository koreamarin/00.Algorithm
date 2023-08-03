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
			switch(DNAArr[i])  {
				case 'A' : UsedChar[0]++; break;
				case 'C' : UsedChar[1]++; break;
				case 'G' : UsedChar[2]++; break;
				case 'T' : UsedChar[3]++; break;
			}
		}
		
		// 초기 탐색 조건을 만족하는지 확인.
		int sum=0;
		if(PWValid(UsedChar, charNum)) sum++;
		
		for(int i=1; i<S-P+1; i++) {			
			switch(DNAArr[i-1])  {
				case 'A' : UsedChar[0]--; break;
				case 'C' : UsedChar[1]--; break;
				case 'G' : UsedChar[2]--; break;
				case 'T' : UsedChar[3]--; break;
			}			
			switch(DNAArr[i+P-1])  {
				case 'A' : UsedChar[0]++; break;
				case 'C' : UsedChar[1]++; break;
				case 'G' : UsedChar[2]++; break;
				case 'T' : UsedChar[3]++; break;
			}
			if(PWValid(UsedChar, charNum)) sum++;
		}
		System.out.println(sum);
	}
	
	public static boolean PWValid(int[] UsedChar, int[] charNum) {
		for(int i=0; i<4; i++) if(UsedChar[i]<charNum[i]) return false;
		return true;
	}

}
