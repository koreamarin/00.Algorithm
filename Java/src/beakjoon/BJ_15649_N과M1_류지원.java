package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M1_류지원 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(ST.nextToken());
        int M = Integer.parseInt(ST.nextToken());

        boolean[] arr=new boolean[N];

        asdf(M, N, arr);
    }
    public static void asdf(int M, int N, boolean[] arr) {
        if(M==1) {
            for(int i=0;i<N;i++) {
                if(arr[i]==false) {
                    System.out.println(i+1);
                    return;
                }
            }
        }

        for(int i=0;i<N;i++) {
            if(arr[i]==false) {
                arr[i]=true;
                System.out.print((i+1)+" ");
                asdf(M-1, N, arr);
            }
        }



    }
}
