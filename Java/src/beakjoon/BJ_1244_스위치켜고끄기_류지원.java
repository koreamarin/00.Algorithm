package beakjoon;

/**
 * @author 류지원
 * 문제 : BEAKJOON 1244 스위치켜고끄기
 *
 * 메모리 사용량 : 11608kb
 * 처리 시간 : 76ms
 *
 * 풀이 방식 :
 * 스위치 개수와 스위치 초기상태를 입력받고,
 * 남학생의 경우에는 남학생이 받은 번호의 배수에 해당하는 곳의 스위치를 전환,
 * 여학생의 경우에는 여학생이 받은 번호를 기준으로 대칭상태에 놓인 스위치들의 값이 같은 경우에
 * 스위치 상태가 전환되도록 구현한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기_류지원 {
    public static void main(String args[]) throws IOException {
        // 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 구분자로 구분되는 String을 자동으로 나눠주는 StringTokennizer 인스턴스 선언.
        StringTokenizer ST;
        // 스위치 개수를 저장할 변수 선언 및 키보드로 값을 입력받아 저장.
        int SthAmt=Integer.parseInt(br.readLine());
        // 스위치 상태를 저장할 정수형 배열 선언 및 생성
        int[] Sth = new int[SthAmt];
        // 키보드로부터 문자열을 입력받고 StringTokenizer로 저장
        ST=new StringTokenizer(br.readLine());
        // 반복문을 이용하여 0부터 스위치개수까지 sweep 하며 StringTokenizer에 있는 값을 순차적으로
        // 스위치 배열의 원소에 순차적으로 저장.
        for(int i=0;i<SthAmt;i++) Sth[i]=Integer.parseInt(ST.nextToken());
        // 학생수를 입력받을 정수형변수 선언 후 키보드로부터 입력받아 저장.
        int StdNum=Integer.parseInt(br.readLine());
        // 학생수만큼 반복하는 반복문 실행
        for(int i=0;i<StdNum;i++) {
            // 키보드로부터 문자열을 입력받고 StringTokenizer로 저장
            ST=new StringTokenizer(br.readLine());
            // ST에 저장된 첫번쨰 문자열을 정수형으로 전환 후, sx 변수 선언 및 저장.
            int sx=Integer.parseInt(ST.nextToken());
            // sx가 1일경우(남자일경우)
            if(sx==1) {
                // 정수형변수N을 선언 및 ST에 저장된 그 다음 문자열을 정수형으로 변환 후 저장.
                int N=Integer.parseInt(ST.nextToken());
                // N-1부터 스위치개수만큼 sweep 하는 반복문 실행. 그러나 j는 N만큼 증가한다.
                for(int j=N-1;j<SthAmt;j+=N) {
                    // 만약 Sth의 원소번호j가 1이라면 그 자리에 0을 입력
                    if(Sth[j]==1) Sth[j]=0;
                    // 만약 Sth의 원소번호j가 0이라면 그 자리에 1을 입력
                    else Sth[j]=1;
                }
            }
            // sx가 2일경우(여자일경우)
            else if(sx==2) {
                // 정수형변수N을 선언 및 ST에 저장된 그 다음 문자열을 정수형으로 변환 후 저장.
                int N = Integer.parseInt(ST.nextToken());
                int stt = N - 1;    // 정수형 변수 stt를 선언 후 N-1 입력
                int stp = N - 1;    // 정수형 변수 stp를 선언 후 N-1 입력
                // 반복문 실행. 조건은 stt는 0이상이고, stp는 스위치개수 이하이며,
                // Sth[stt]와 Sth[stp]가 같을 때.
                while (0 <= stt && stp < SthAmt && Sth[stt] == Sth[stp]) {
                    // Sth[stt]가 1일 경우에는 Sth[stt]와 Sth[stp]에 0을 입력하고, stt는 1감소, stp는 1증가
                    if (Sth[stt] == 1) Sth[stt--] = --Sth[stp++];
                    // 그 외 경우에는 (Sth[stt]가 0일 경우에는)
                    // Sth[stt]와 Sth[stp]에 1을 입력하고, stt는 1감소, stp는 1증가
                    else Sth[stt--] = ++Sth[stp++];
                }
            }
        }
        // 1부터 스위치개수+1번까지 sweep하는 반복문 실행
        for(int i=1; i<SthAmt+1;i++) {
            // 만약 출력된 개수가 20의 배수라면 출력후 한칸 띄우기
            if(i%20==0) System.out.println(Sth[i-1]);   // Sth[i-1]을 출력
            //  만약 출력된 개수가 20의 배수가 아니라면 한칸 띄우지 않고 출력
            else System.out.print(Sth[i-1]+" "); // Sth[i-1]을 출력
        }
    }
}
