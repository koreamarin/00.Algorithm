package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_01228_SW문제해결기본8일차암호문1_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        StringBuilder SB;
        for(int t=1; t<11; t++) {   // 테스트 케이스 10번 반복
            SB = new StringBuilder();   // 스트링 빌더 선언 및 생성
            // 테케 첫째줄, 원본 암호문의 길이
            int N=Integer.parseInt(br.readLine());

            // 테케 둘째줄, 원본 암호문
            ArrayList<Integer> list = new ArrayList<>();    // 정수형을 받는 리스트 선언 및 생성
            ST=new StringTokenizer(br.readLine());          // 스트링토크나이저로 키보드 입력 받기
            for(int i=0;i<N;i++) list.add(Integer.parseInt(ST.nextToken()));    // 리스트에 스트링토크나이저에 있는 문자열을 정수형으로 바꿔 입력

            // 테케 셋째줄, 명령어의 개수.
            N=Integer.parseInt(br.readLine());  // 키보드 입력 받아서 N에 입력

            // 테케 넷째줄, 명령어
            ST=new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {    // 명령어 개수만큼 반복
                ST.nextToken();
                int x = Integer.parseInt(ST.nextToken());   // 리스트에 삽입할 인덱스 번호
                int y = Integer.parseInt(ST.nextToken());   // 리스트에 삽입할 숫자 개수
                // y번 반복. 리스트의 x+j번 인덱스에 키보드로 입력받은 값 삽입
                for (int j = 0; j < y; j++) list.add(x + j, Integer.parseInt(ST.nextToken()));
            }
            SB.append("#" + t + " ");   
            for(int i=0; i<10; i++) SB.append(list.get(i) + " ");
            System.out.println(SB); // 스트링 빌더 출력
        }
    }
}
