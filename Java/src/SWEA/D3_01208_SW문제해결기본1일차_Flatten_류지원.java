package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_01208_SW문제해결기본1일차_Flatten_류지원 {
    public static void main(String[] args) throws IOException {
        // 키보드로 입력을 받기위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열의 구분자를 자동으로 인식하여 나누어주는 StringTokennizer 생성
        StringTokenizer ST;
        // 테스트케이스 10번을 수행할 반복문 실행
        for(int t=0;t<10;t++) {
            // N을 키보드로부터 입력받음
            int N=Integer.parseInt(br.readLine());
            // ST변수에 키보드로부터 입력받은 문자열 저장
            ST=new StringTokenizer(br.readLine());
            int[] arr=new int[100]; // 100개의 정수형 변수 선언 및 생성
            // 0부터 100까지 sweep하는 반복문 실행. 0~100까지 StringTokenizer에 들어있는 문자열 순차적으로 저장.
            for(int i=0;i<100;i++) arr[i]=Integer.parseInt(ST.nextToken());
            // 0부터 N까지 sweep 하는 반복문 실행.
            for(int i=0;i<N;i++) {
                int[] idx=Idx(arr); // idx선언 및 최소값을 가진 원소번호, 최대값을 가진 원소번호를 가진 배열을 반환하는 함수 실행 및 저장.
                arr[idx[0]]--;      // 최대값에 1 감소
                arr[idx[1]]++;      // 최소값에 1 증가
            }
            int[] idx=Idx(arr);     // 최대값을 가진 원소번호와 최소값을 가진 원소번호 추출
            int sub = arr[idx[0]]-arr[idx[1]];  // 최대값에서 최소값 빼서 sub에 저장

            System.out.println("#"+(t+1)+" "+sub);  // 출력
        }
    }
    public static int[] Idx(int[] arr) {    // 최대값을 가진 원소번호와 최소값을 가진 원소번호를 배열의 형태로 반환하는 함수.
        int MaxIdx=0;       // 최대값을 가진 원소번호를 저장할 변수
        int MinIdx=0;       // 최소값을 가진 원소번호를 저장할 변수
        int MaxValue=0;     // 최대값을 저장할 변수
        int MinValue=100;   // 최소값을 저장할 변수
        for(int i=0;i<100;i++) {        // 0~100까지 sweep하는 반복문
            if(arr[i]>MaxValue) {       // 만약 배열의 해당 원소값이 MaxValue보다 크다면 실행하는 조건문
                MaxValue=arr[i];        // Maxvalue에 해당 원소값 저장
                MaxIdx=i;               // MaxIdx에 해당 원소번호 저장.
            }
            if(arr[i]<MinValue) {       // 만약 배열의 해당 원소값이 MinValue보다 작다면 실행하는 조건문
                MinValue=arr[i];        // Minvalue에 해당 원소값 저장
                MinIdx=i;               // MinIdx에 해당 원소번호 저장.
            }
        }
        int[] Idx = {MaxIdx, MinIdx};   // Idx라는 이차원배열 선언 및 최대값을 가진 원소번호와 최소값을 가진 원소번호를 담아 저장.
        return Idx;                     // Idx 반환.
    }
}
