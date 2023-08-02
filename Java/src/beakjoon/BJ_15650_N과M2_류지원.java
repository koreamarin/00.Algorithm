package beakjoon;
/**
 * @author 류지원
 * 문제 : BEAKJOON 156500 N과 M(2)
 *
 * 풀이 방식 :
 * 결과에 1,2가 있다면 2,1이 출력되지 않는 것으로 보아 순서에 의미가 없는 조합문제이다.
 * 따라서 앞에서 찾은 숫자보다 뒤에서 찾은 숫자가 클 경우에만 출력하는 코드를 구성하였다.
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N과M2_류지원 {
	static int N;			// 정수형 멤버변수 N 선언
	static int[] numbers;	// 멤버변수 정수형 배열 numbers 선언
	static int M;			// 멤버변수 정수형 M 선언
	static StringBuilder SB;	// 스트링 빌더 SB 선언
	
    public static void main(String args[]) throws IOException {
		// 키보드 입력을 받기위한 BufferedReader 클래스 선언 및 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 문자열을 구분자를 인식하여 자동으로 나눠주는 StringTokenizer 선언 및 키보드로 입력받은 값으로 생성
        StringTokenizer ST = new StringTokenizer(br.readLine());
        N = Integer.parseInt(ST.nextToken());	// StringTokenizer의 첫번째 문자열을 정수형으로바꾼 후 N에 저장
        M = Integer.parseInt(ST.nextToken());	// StringTokenizer의 두번째 문자열을 정수형으로바꾼 후 M에 저장
        numbers = new int[M];		// numbers 배열 크기를 M으로 생성
        SB=new StringBuilder();		// isSelected 배열 크기를 N으로 생성
        NM(0);					// 조합을 나열할 수 있는 함수 실행
        System.out.println(SB);		// 스트링빌더에 담긴 문자열 출력
    }
    
    public static void NM(int cnt) {	// NM함수는 M개의 숫자 조합 번호들을 찾아주는 함수이다. cnt는 cnt번째 숫자를 탐색함을 의미한다.
    	if(cnt==M) {	// 기저조건. cnt가 M이면 다 찾은 것이므로 지금까지 찾은 순열조합을 출력 한 후 리턴.
    		for(int i=0;i<M;i++) SB.append((numbers[i]+1)+" ");	// 지금까지 찾은 조합 번호를 배열에서 출력
    		SB.append("\n");	// 한칸 띄우는 용도
    		return;	// 리턴
    	}
		// 유도 파트
    	for(int i=cnt; i<N; i++) {	// i를 cnt부터 N까지 sweep하며 반복작업을 하는 함수.
			// cnt가 0이거나, numbers[cnt-1]이 i보다 작다면,
			// 즉, 이전자릿수의 숫자가 현재 찾는 자리의 참조하고 있는 숫자 i보다 작다면
			// 이 조건문을 실행
    		if(cnt==0 || numbers[cnt-1]<i) {
				numbers[cnt]=i;		// numbers[cnt]에 i를 저장
				NM(cnt+1);		// cnt에 1을 추가하여 NM메서드 실행. 재귀.
    		}
		}
    }
}
