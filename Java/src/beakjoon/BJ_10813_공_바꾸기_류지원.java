package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10813_공_바꾸기_류지원 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(ST.nextToken());
        int M = Integer.parseInt(ST.nextToken());

        int[] basket = new int[N];

        for (int i=1; i<=N; i++) {
            basket[i-1] = i;
        }

        int f = 0;
        int l = 0;
        int swap=0;
        for (int i = 0; i < M; i++) {
            ST = new StringTokenizer(br.readLine());
            f = Integer.parseInt(ST.nextToken());
            l = Integer.parseInt(ST.nextToken());

            swap = basket[f-1];
            basket[f-1] = basket[l-1];
            basket[l-1] = swap;
        }

        for(int n=0; n<N; n++) {
            System.out.print(basket[n] + " ");
        }
    }

}
