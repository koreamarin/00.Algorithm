package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 11536KB
 * 시간 : 76ms
 * 풀이방법 :
 * 분할 정복을 사용하였다.
 * 다만, 배열을 사용하면 메모리초과, 브루트포스를 하면 시간초과가 걸리므로
 * 아래적힌바와 같이 배열을 사용하지않고 분할정복을 해나가며 풀이했다.
 * 가야하는 쪽이 1,2,3,4사분면 중에 어디인지를 판단 후, count를 한번에 더하는 방식을 사용하였다.
 */

public class BJ_01074_Z_류지원 {
	static int count=0; static int row; static int col;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(ST.nextToken());
        row = Integer.parseInt(ST.nextToken());
        col = Integer.parseInt(ST.nextToken());
        int S = (int)Math.pow(2, N);    // 크기
        counter(0, 0, S);       // 분할정복 시작
        System.out.println(count);      // 카운트 출력
    }

    public static void counter(int r, int c, int S) {       // 매개변수 r은 행의 시작점 위치, c은 열의 시작점 위치, S는 참조하고 있는 공간의 크기
        // 기저조건. 계산 없음
        if (S==1) return; 

        // 유도파트
        int HS=S/2;                         // 참조하고 있는 공간의 절반 크기
        int Sqr=HS*HS;                      // sqr는 count에 더해야하는 수를 계산하기 위한 용도
        int NR=r+HS; int NC=c+HS;           // 새로 참조해야하는 공간의 행,열을 계산하기 위한 용도.

        if(NR>row && NC>col) {              // 최종목적지가 참조하고 있는 공간의 2사분면에 있다면
            counter(r,c,HS);                // 2사분면에 해당하는 위치로 이동, 참조하고 있는 크기가 절반이 되므로 HS를 넣음. 시작위치는 변하지 않으므로 r,c 그대로 넣음.
        }
        else if(NR>row && NC<=col) {        // 최종목적지가 참조하고 있는 공간의 1사분면에 있다면
            count+=Sqr;                     // 1사분면에 이동하기 전, 1사분면으로 시작위치로 이동했을시의 count 수를 더함.
            counter(r,NC,HS);               // 1사분면에 해당하는 위치로 이동, 참조하고 있는 크기가 절반이 되므로 HS를 넣음. 시작위치는 열만 변하므로 NC를 넣음.
        }
        else if(NR<=row && NC>col) {        // 최종목적지가 참조하고 있는 공간의 3사분면에 있다면
            count+=Sqr*2;                   // 3사분면에 이동하기 전, 3사분면으로 시작위치로 이동했을시의 count 수를 더함.
            counter(NR, c, HS);             // 3사분면에 해당하는 위치로 이동, 참조하고 있는 크기가 절반이 되므로 HS를 넣음. 시작위치는 행만 변하므로 NR를 넣음.
        }
        else if(NR<=row && NC<=col) {       // 최종목적지가 참조하고 있는 공간의 4사분면에 있다면
            count+=Sqr*3;                   // 4사분면에 이동하기 전, 4사분면으로 시작위치로 이동했을시의 count 수를 더함.
            counter(NR, NC, HS);            // 4사분면에 해당하는 위치로 이동, 참조하고 있는 크기가 절반이 되므로 HS를 넣음. 시작위치는 행과 열이 변하므로 NR, NC를 넣음.
        }
    }
}
