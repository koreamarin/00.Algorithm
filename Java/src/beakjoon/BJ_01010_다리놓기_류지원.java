package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01010_다리놓기_류지원 {
    static int N;			// 정수형 멤버변수 N 선언
    static int[] numbers;	// 멤버변수 정수형 배열 numbers 선언
    static int M;			// 멤버변수 정수형 M 선언
    static int sum;	            // 멤버변수 정수형 sum 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<T+1; t++) {
            ST = new StringTokenizer(br.readLine());
            M = Integer.parseInt(ST.nextToken());	// StringTokenizer의 첫번째 문자열을 정수형으로바꾼 후 M에 저장
            N = Integer.parseInt(ST.nextToken());	// StringTokenizer의 두번째 문자열을 정수형으로바꾼 후 N에 저장
            numbers = new int[M];		// numbers 배열 크기를 M으로 생성
            sum=0;
            NM(0);					// 조합을 나열할 수 있는 함수 실행
            System.out.println(sum);		// 스트링빌더에 담긴 문자열 출력
        }
    }

    public static void NM(int cnt) {    // NM함수는 M개의 숫자 조합 번호들을 찾아주는 함수이다. cnt는 cnt번째 숫자를 탐색함을 의미한다.
        if (cnt == M) {    // 기저조건. cnt가 M이면 다 찾은 것이므로 지금까지 찾은 순열조합을 출력 한 후 리턴.
            sum++;
            return;    // 리턴
        }
        // 유도 파트
        for (int i = cnt; i < N; i++) {    // i를 cnt부터 N까지 sweep하며 반복작업을 하는 함수.
            // cnt가 0이거나, numbers[cnt-1]이 i보다 작다면,
            // 즉, 이전자릿수의 숫자가 현재 찾는 자리의 참조하고 있는 숫자 i보다 작다면
            // 이 조건문을 실행
            if (cnt == 0 || numbers[cnt - 1] < i) {
                numbers[cnt] = i;        // numbers[cnt]에 i를 저장
                NM(cnt + 1);        // cnt에 1을 추가하여 NM메서드 실행. 재귀.
            }
        }
    }



}
