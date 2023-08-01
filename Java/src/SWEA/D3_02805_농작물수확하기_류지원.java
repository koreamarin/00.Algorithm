package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_02805_농작물수확하기_류지원 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 키보드로 입력을 받기위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열의 구분자를 자동으로 인식하여 나누어주는 StringTokennizer 생성
        StringTokenizer ST;
        // 테스트케이스를 입력받은 T 변수 생성 후 키보드로 입력받기
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++) {	// 테스트케이스만큼 반복하는 반복문 실행
            int N=Integer.parseInt(br.readLine());	// N입력받기
            int[][] arr=new int[N][N];	// N*N 크기의 정수형 이차원 배열 생성
            for(int i=0;i<N;i++) {		// N만큼 반복하는 반복문 실행
                String IN=br.readLine();	// 입력받은 문자열 입력받기
                // 입력받은 문자열을 앞에서부터 한개씩 char형으로 추출함
                // char형의 숫자형태임. '1'의 아스키코드는 49이므로 48을 빼면 정수형 숫자를 얻음;
                for(int j=0;j<N;j++) arr[i][j]=IN.charAt(j)-48;
            }
            int sum=0;	// 농작물 수를 담을 변수 선언 및 0 부여.

            // N이 1일 때 실행. 농작물 하나를 수확.
            if (N==1) sum+=arr[0][0];
                // N이 1이 아닐떄 실행
                // 가운데 줄, 첫줄의 가운데 원소, 마지막줄의 가운데 원소 더하기
                // 가운데 줄을 모두 더할 때 일차원배열의 시작부분과 끝 부분을 매개변수로 하여 시작부분부터 끝부분까지
                // 더해주는 SumLine 메서드를 만들어서 이용함.
            else sum+=SumLine(0,N,arr[N/2])+arr[0][N/2]+arr[N-1][N/2];

            // 나머지 라인의 농작물을 모두 더하기 위해 나머지 라인을 탐색할 반복문 실행
            for(int i=1; i<N/2;i++) {
                // 가운데 라인을 기준으로 위 아래가 대칭이므로 위 아래를 동시에 탐색하며 농작물을 수확하는 코드.
                sum+=SumLine((N/2)-i, (N/2)+i+1, arr[i])+SumLine((N/2)-i, (N/2)+i+1, arr[N-i-1]);
            }
            // 문자열 출력
            System.out.println("#"+t+" "+sum);
        }
    }

    // 일차원 배열의 원하는 부분의 원소를 더해주는 메서드. 시작 원소번호, 끝원소번호, 일치원배열을 매개변수로하며
    // 시작원소번호부터 끝원소번호까지 더한값을 정수형으로 리턴한다.
    public static int SumLine(int stt, int stp, int[] Line) {
        int sum=0;	// 더한값을 저장할 변수 생성 및 선언
        for(;stt<stp;stt++) sum+=Line[stt];	// 시작원소번호부터 끝원소번호까지 탐색하며 더하는과정.
        return sum;	// 원소값 모두 더한 값 리턴.
    }
}
