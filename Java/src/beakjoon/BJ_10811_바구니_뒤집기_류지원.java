package beakjoon;

/**
 * @author 류지원
 * 문제 : BEAKJOON 10811 바구니 뒤집기
 *
 * 풀이 방식 :
 * 배열을 만들어서 순서에 맞는 숫자를 입력한 뒤에
 * 역순으로 바꿔야 하는 구역을 copyofrange로 따로 뺴놓고
 * 맞춰 껴 놓는다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class BJ_10811_바구니_뒤집기_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(ST.nextToken());
        int M = Integer.parseInt(ST.nextToken());
        int[] basket = new int[N];

        for(int i=0;i<N;i++) basket[i]=i+1;

        int f = 0;
        int l = 0;

        for (int i=0; i<M; i++) {
            ST = new StringTokenizer(br.readLine());
            f = Integer.parseInt(ST.nextToken());
            l = Integer.parseInt(ST.nextToken());
            int[] A = Arrays.copyOfRange(basket, f-1, l);
            for(int j=0; j<l-f+1; j++) basket[f+j-1]=A[l-f-j];
        }

        for(int i=0;i<N;i++) System.out.print(basket[i] + " ");
    }
}
