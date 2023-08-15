package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_02630_색종이만들기 {
    static int[][] arr; static int N; static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        for(int i=0; i<N; i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) arr[i][j]=Integer.parseInt(ST.nextToken());
        }


        divider(arr, N);
        System.out.println(count);
    }

    public static int divider(int[][] arr, int S) {
        if(S==2) {
            if(arr[0][0]==0 && arr[0][1]==0 && arr[1][0]==0 && arr[1][1]==0) return 0;
            else if(arr[0][0]==1 && arr[0][1]==1 && arr[1][0]==1 && arr[1][1]==1) return 1;
            else count++;
            return 2;
        }

        int HS=S/2;
        int[][] LTarr=new int[HS][HS];
        int[][] RTarr=new int[HS][HS];
        int[][] LBarr=new int[HS][HS];
        int[][] RBarr=new int[HS][HS];
        for(int i=0; i<HS; i++) {
            LTarr[i]=Arrays.copyOfRange(arr[i], 0, HS);
            RTarr[i]=Arrays.copyOfRange(arr[i], HS,S);
            LBarr[i]=Arrays.copyOfRange(arr[i+HS], 0, HS);
            RBarr[i]=Arrays.copyOfRange(arr[i+HS], HS,S);
        }

        int N1 = divider(LTarr, HS);
        int N2 = divider(RTarr, HS);
        int N3 = divider(LBarr, HS);
        int N4 = divider(RBarr, HS);

        if (N1==0 && N2==0 && N3==0 && N4==0) return 0;
        else if (N1==1 && N2==1 && N3==1 && N4==1) return 1;
        else count++;
        return 2;
    }
}
