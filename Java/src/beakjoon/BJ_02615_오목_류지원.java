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
        // 입력받은 배열 출력
        for(int i=0;i<19;i++) System.out.println(Arrays.toString(arr[i]));

        // 바둑판을 sweep하며 검은돌, 흰돌을 찾음
        for(int i=0;i<19;i++) {
            for(int j=0;j<19;j++) {
                int arrValue = arr[i][j];
                if(arrValue==1 || arrValue==2) {
                    if (OverallVerification(i, j, arr)) System.out.println(arrValue+"\n"+i+" "+j);
                }
            }
        }
    }

    public static boolean OverallVerification(int i,int j, int[][] arr){
        if (R_Verification(i, j, arr)) return true;
        else if (B_Verification(i, j, arr)) return true;
        else if (RB_Verification(i, j, arr)) return true;
        else if (RT_Verification(i, j, arr)) return true;
        return false;
    }
    public static boolean R_Verification(int i,int j, int[][] arr) {
        int A=arr[i][j];
        if(arr[i][j+1]==A && arr[i][j+2]==A && arr[i][j+3]==A && arr[i][j+4]==A) {
            if(arr[i][j+5]==A) return false;
            return true;
        }
        return false;
    }
    public static boolean B_Verification(int i,int j, int[][] arr) {

        return false;
    }
    public static boolean RB_Verification(int i,int j, int[][] arr) {

        return false;
    }
    public static boolean RT_Verification(int r,int c, int[][] arr) {
        // 6개는 아닌지 확인해야함
        return false;
    }
}
