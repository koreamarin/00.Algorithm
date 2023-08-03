package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_02961_도영이가만든맛있는음식_류지원 {
	static boolean[] isSelected;	// 어떤 소스를 선택했는지 체크기 위한 boolean 배열 선언
	static int[] SSEUN;				// 쓴맛정도를 저장할 배열 선언
	static int[] SIN;				// 신맛 정도를 저장할 배열 선언
	static int N;					// 소스의 개수를 저장할 정수형변수 선언
	static int min;					// 소스 조합시 신맛과 쓴맛의 가장 작은 값을 저장할 정수형 변수 선언

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열을 구분자를 인식하여 자동으로 나눠주는 StringTokenizer 선언 및 키보드로 입력받은 값으로 생성
		StringTokenizer ST;
		N = Integer.parseInt(br.readLine());	// 키보드로부터 입력받은 문자열을 정수로 바꿔 N에 입력
		SIN = new int[N];		// 신맛 정도를 저장할 배열을 N의 크기로 생성
		SSEUN = new int[N];		// 쓴맛 정도를 저장할 배열을 N의 크기로 생성
		isSelected = new boolean[N];	// 어떤 소스를 선택했는지 체크기 위한 boolean 배열을 N의 크기로 생성
		min = Integer.MAX_VALUE;	// min의 값에 정수형 변수에 저장할 수 있는 최댓값을 입력
		
		
		for(int n=0; n<N; n++) {	// 문자열을 입력받아 정수형으로 바꿔 쓴맛과 신맛 배열에 순차적으로 입력하기 위한 0~N까지 sweep하는 반복문
			ST = new StringTokenizer(br.readLine());	// StringTokenizer 객체 생성 및 키보드로 입력받은 값 입력.
			SIN[n] = Integer.parseInt(ST.nextToken());	// 신맛 배열에 StringTokenizer의 첫번째 문자열 입력
			SSEUN[n] = Integer.parseInt(ST.nextToken());	// 쓴맛 배열에 StringTokenizer의 두번째 문자열 입력
		}
		if(N>1) {	// N이 1이상일 때에만 조건문 실행하여 재귀 실행
			JJAPAGEATI(0);	// 재귀 시작
		}
		else if(N==1) {	// N이 1일 때에는 무조건 해당원소를 골라야하므로 재귀를 실행하지 않고 아래 구현부 바로 실행
			min = SIN[0]-SSEUN[0];	// min에 입력받은 신맛과 쓴맛의 차이를 입력
			if (min<0) min*=-1;		// min이 음수일 경우 양수로 변환
		}
		System.out.println(min);		// min값 출력
	}
	
	
	
	// 부분집합을 활용한 min값 구하는 함수
	public static void JJAPAGEATI(int cnt) {
		if(cnt==N) {	// 기저조건. cnt가 N일 경우 실행
			int SINSUM = 1;	// 신맛은 서로 곱해야 하므로 처음 값이 0이면 계속 곱해도 0이 되기때문에 1로 입력
			int SSEINSUM = 0;	// 쓴맛은 서로 더해야하므로 값을 0으로 지정
			int sub=0;			// 신맛과 쓴맛의 조합의 차를 저장할 정수형 변수
			
			for(int n=0; n<N; n++) {	// 모든 원소가 선택되지 않을 경우는 쓴맛과 신맛의 조합을 계산하지 않고 리턴하려는 목적의 반복문
				if(isSelected[n]) break;	// isSelected[n]이 하나라도 true인 경우에는 반복문 종료
				else if(isSelected[n]==false) {	// isSelected[n]이 false일 경우에는 다음 반복을 실행하여 계속 검증 시행
					if(n==N-1) return;		// 모든 isSelected가 false일 경우 아래 계산을 시행하지 않고 메서드 종료.
				}
			}
			
			for(int n=0; n<N; n++) {		// 선택된 재료의 쓴맛과 신맛의 곱, 합을 계산해줄 반복문
				if(isSelected[n]) {			// isSelected[n]이 true일 경우, 즉 재료가 선택되었을 경우
					SINSUM *= SIN[n];		// 신맛을 곱함
					SSEINSUM += SSEUN[n];	// 쓴맛을 더함
				}
			}
			sub = SINSUM - SSEINSUM;		// 신맛과 쓴맛의 차를 sub변수에 저장
			if (sub<0) sub*=-1;				// sub 가 음수일경우 양수로 변환
			if (min>sub) min=sub;			// min값이 sub보다 클 경우 min값을 sub값으로 저장
			return;							// 메서드 종료.
		}
		
		isSelected[cnt] = true;				// isSelected[cnt]에 true 값을 넣어줌. 즉, 재료 선택
		JJAPAGEATI(cnt+1);					// 현재 재료는 사용하기로 선택한 상태로 다음 재료를 선택할지 안할지에 대한 재귀메서드 실행
		isSelected[cnt] = false;			// isSelected[cnt]에 false 값을 넣어줌. 즉, 재료 선택
		JJAPAGEATI(cnt+1);					// 현재 재료는 사용안하기로 선택한 상태로 다음 재료를 선택할지 안할지에 대한 재귀메서드 실행
	}

}
