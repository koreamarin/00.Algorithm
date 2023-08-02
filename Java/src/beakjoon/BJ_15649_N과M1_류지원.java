package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M1_류지원 {
	static int N;		// 정수형 멤버변수 N 선언
	static boolean[] isSelected;		// 멤버변수 불린형 배열 isSelected 선언
	static int[] numbers;	// 멤버변수 정수형 배열 numbers 선언
	static int M;	// 멤버변수 정수형 M 선언
	
    public static void main(String args[]) throws IOException {
		// 키보드 입력을 받기위한 BufferedReader 클래스 선언 및 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열을 구분자를 인식하여 자동으로 나눠주는 StringTokenizer 선언 및 키보드로 입력받은 값으로 생성
        StringTokenizer ST = new StringTokenizer(br.readLine());
        N = Integer.parseInt(ST.nextToken());	// StringTokenizer의 첫번째 문자열을 정수형으로바꾼 후 N에 저장
        M = Integer.parseInt(ST.nextToken());	// StringTokenizer의 두번째 문자열을 정수형으로바꾼 후 M에 저장
        
        isSelected = new boolean[N];			// isSelected 배열 크기를 N으로 생성
        numbers = new int[M];					// numbers 배열 크기를 M으로 생성
        NM(0);								// NM함수 실행
    }
    
    public static void NM(int cnt) {	// NM함수는 M개의 숫자 순열조합을 찾아주는 함수이다. cnt는 cnt번째 숫자를 탐색함을 의미한다.
    	if(cnt==M) {	// 기저조건. cnt가 M이면 다 찾은 것이므로 지금까지 찾은 순열조합을 출력 한 후 리턴.
    		for(int i=0;i<M;i++)System.out.print((numbers[i]+1)+" ");	// 지금까지 찾은 순열 조합을 배열에서 출력
    		System.out.println();	// 한칸 띄우는 용도
    		return;	// 리턴
    	}
    	// 유도 파트
    	for(int i=0; i<N; i++) {	// i를 0부터 N까지 sweep하며 반복작업을 하는 함수.
    		if(isSelected[i]==false) {		// isSelected[i]가 false라면 i는 이전에 사용하지 않은 정수이므로 구현부 실행
    			numbers[cnt]=i;			// numbers[cnt]에 i를 입력
    			isSelected[i]=true;		// isSelected[i]에 true 입력하여 사용하는  번호임을 표시
				NM(cnt+1);			// cnt에 1을 추가하여 NM을 호출함으로서 다음 자리수를 찾는 재귀 시작
    			isSelected[i]=false;	// 현재 자리수에 대한 모든 순열조합을 찾았다면 다음 번호로 넘어가기 위해 현재 자리수는 사용하지 않는 다는 뜻으로
										// false를 입력
    		}
    	}
    }
}
