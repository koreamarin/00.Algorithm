package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01547_공_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        boolean[] cups = {true, false, false};

        int M = Integer.parseInt(ST.nextToken());
        int F;
        int L;

        for (int i = 0; i < M; i++) {
            ST = new StringTokenizer(br.readLine());
            F = Integer.parseInt(ST.nextToken())-1;
            L = Integer.parseInt(ST.nextToken())-1;

            if (cups[F]==true || cups[L]==true) {
                boolean swap = cups[F];
                cups[F] = cups[L];
                cups[L] = swap;
            }
        }
        for(int i=0;i<3;i++) if(cups[i]==true) System.out.println(i+1);
    }

}
