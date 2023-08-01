package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1208_SW문제해결기본1일차_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        for(int t=0;t<10;t++) {
            int N=Integer.parseInt(br.readLine());
            ST=new StringTokenizer(br.readLine());
            int[] arr=new int[100];
            for(int i=0;i<100;i++) arr[i]=Integer.parseInt(ST.nextToken());

            for(int i=0;i<N;i++) {
                int[] idx=Idx(arr);

                arr[idx[0]]--;
                arr[idx[1]]++;
            }
            int[] idx=Idx(arr);
            int sub = arr[idx[0]]-arr[idx[1]];

            System.out.println("#"+(t+1)+" "+sub);
        }
    }
    public static int[] Idx(int[] arr) {
        int MaxIdx=0;
        int MinIdx=0;
        int MaxValue=0;
        int MinValue=100;
        for(int i=0;i<100;i++) {
            if(arr[i]>MaxValue) {
                MaxValue=arr[i];
                MaxIdx=i;
            }
            if(arr[i]<MinValue) {
                MinValue=arr[i];
                MinIdx=i;
            }
        }
        int[] Idx = {MaxIdx, MinIdx};
        return Idx;
    }
}
