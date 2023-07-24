package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01703_생장점_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        while(true) {
            ST = new StringTokenizer(br.readLine());
            int r = 1;
            int a = Integer.parseInt(ST.nextToken());
            if(a==0) break;
            for(int i=0; i<a; i++) {
                int N = Integer.parseInt(ST.nextToken());
                int M = Integer.parseInt(ST.nextToken());
                r=(r*N)-M;
            }
            System.out.println(r);
        }
    }
}
