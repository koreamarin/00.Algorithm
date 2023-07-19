package beakjoon;

/**
 * @author 류지원
 * 문제 : BEAKJOON 10810 공넣기
 *
 * 풀이 방식 :
 * 단순 구현 문제이다. 배열읆 만든 뒤 주어진 번호에 해당하는 배열의 범위에
 * 주어진 숫자를 넣으면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10810_공_넣기_류지원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(ST.nextToken());
        int M = Integer.parseInt(ST.nextToken());

        int[]  basket= new int[N];

        int stt = 0;
        int stp = 0;
        int num = 0;

        for(int i=0; i<M; i++) {

            ST = new StringTokenizer(br.readLine());
            stt = Integer.parseInt(ST.nextToken());
            stp = Integer.parseInt(ST.nextToken());
            num = Integer.parseInt(ST.nextToken());

            for(int j=stt; j<=stp; j++) {
                basket[j-1] = num;
            }
        }
        for(int n=0; n<basket.length; n++) {
            System.out.print(basket[n] + " ");
        }
    }
}
