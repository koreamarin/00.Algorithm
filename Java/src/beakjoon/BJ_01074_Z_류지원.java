package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01074_Z_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(ST.nextToken())+1;
        int r = Integer.parseInt(ST.nextToken());
        int c = Integer.parseInt(ST.nextToken());
        int S = (int)Math.pow(2, N);
        int[][] arr = new int[S][S];

        counter(arr, N, 0);
        System.out.println(S);


    }

    public static void counter(int[][] arr, int N, int count) {
        N=N/2;
        int[][] LTArr=new int[N][N];
        int[][] RTArr=new int[N][N];
        int[][] LBArr=new int[N][N];
        int[][] RBArr=new int[N][N];
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) {
            LTArr[i][j]=arr[i][j];
            RTArr[i][j]=arr[i][j+N];
            LBArr[i][j]=arr[i+N][j];
            RBArr[i][j]=arr[i+N][j+N];
        }
        if(N==1) {
            LTArr[0][0] = count++;
            RTArr[0][0] = count++;
            LBArr[0][0] = count++;
            RBArr[0][0] = count++;
            arr[N-1][N-1]=LTArr[0][0];
            arr[N-1][N]=RTArr[0][0];
            arr[N][N-1]=LBArr[0][0];
            arr[N][N]=RBArr[0][0];
        }

        counter(LTArr, N, count);    // 왼위
        counter(RTArr, N, count);    // 오위
        counter(LBArr, N, count);    // 왼아
        counter(RBArr, N, count);    // 오아


    }
}
