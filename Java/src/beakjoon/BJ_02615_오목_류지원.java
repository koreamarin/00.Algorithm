package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_02615_오목_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int[][] arr = new int[19][19];
        for(int i=0;i<19;i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0;j<19;j++) arr[i][j]=Integer.parseInt(ST.nextToken());
        }
        // 바둑판을 sweep하며 검은돌, 흰돌을 찾음
        for(int i=0;i<19;i++) {
            for(int j=0;j<19;j++) {
                if(arr[i][j]>0) {
                    if(OverallVerification(i, j, arr)) {
                        System.out.println(arr[i][j]+"\n"+(i+1)+" "+(j+1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static boolean OverallVerification(int i,int j, int[][] arr){
        if (R_Verification(i, j, arr) ||
            B_Verification(i, j, arr) ||
            RB_Verification(i, j, arr) ||
            RT_Verification(i, j, arr)) {
            return true;
        }
        return false;
    }
    public static boolean R_Verification(int i,int j, int[][] arr) {
        int A=arr[i][j];
        if(j+4<19) {
            if (arr[i][j+1]==A && arr[i][j+2]==A && arr[i][j+3]==A && arr[i][j+4]==A) {
                if ((j+5<19 && arr[i][j+5]==A) || (j>0 && arr[i][j-1]==A)) return false;
                return true;
            }
        }
        return false;
    }
    public static boolean B_Verification(int i,int j, int[][] arr) {
        int A=arr[i][j];
        if(i+4<19) {
            if (arr[i + 1][j] == A && arr[i + 2][j] == A && arr[i + 3][j] == A && arr[i + 4][j] == A) {
                if ((i+5<19 && arr[i+5][j]==A) || (i > 0 && arr[i - 1][j] == A)) return false;
                return true;
            }
        }
        return false;
    }
    public static boolean RB_Verification(int i,int j, int[][] arr) {
        int A=arr[i][j];
        if(j+4<19 && i+4<19) {
            if (arr[i + 1][j + 1] == A && arr[i + 2][j + 2] == A && arr[i + 3][j + 3] == A && arr[i + 4][j + 4] == A) {
                if ((i+5<19 && j+5<19 && arr[i + 5][j + 5] == A) || (i > 0 && j>0 && arr[i - 1][j - 1] == A))
                    return false;
                return true;
            }
        }
        return false;
    }
    public static boolean RT_Verification(int i,int j, int[][] arr) {
        int A=arr[i][j];
        if(j+4<19 && i-4>=0) {
            if (arr[i - 1][j + 1] == A && arr[i - 2][j + 2] == A && arr[i - 3][j + 3] == A && arr[i - 4][j + 4] == A) {
                if ((i-5>=0 && j+5<19 && arr[i - 5][j + 5] == A) || (i < 18 && j>0 && arr[i + 1][j-1] == A))
                    return false;
                return true;
            }
        }
        return false;
    }
}
