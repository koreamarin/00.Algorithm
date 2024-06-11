package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 15772KB
 * 시간 : 124ms
 *
 * 풀이방법 :
 * 분할정복으로 풀이하였다.
 * 만약 탐색하고 있는 색종이의 공간이 모두 같은색이 아니면
 * 1,2,3,4사분면으로 분할해, 나뉜 공간의 색종이가 같은색인지 아닌지
 * 판단하는 재귀함수를 작성하였다.
 * 만약 모든 면이 하나의 색이라면 파란색 또는 하얀색 색종이의 개수를 1씩 올린다.
 */


public class BJ_02630_색종이만들기 {
    static int[][] arr; static int Bcnt=0, Wcnt=0, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        N=Integer.parseInt(br.readLine());
        arr=new int[N][N];
        for(int i=0; i<N; i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) arr[i][j]=Integer.parseInt(ST.nextToken());
        }


        divider(arr);
        System.out.println(Wcnt);
        System.out.println(Bcnt);
    }

    public static void divider(int[][] arr) {
        int S=arr.length;
        int sum=0;
        for(int i=0; i<S; i++) for(int j=0; j<S; j++) sum+=arr[i][j];   // 배열 원소를 다 더해서 어떻게 색종이의 색이 구성되어있는지 판단하기 위함.

        if(sum==0)          Wcnt++;     // 배열 원소의 합이 0이라면 흰 색종이의 개수를 1 올림
        else if(sum==S*S)   Bcnt++;     // 배열 원소의 합이 S*S라면 파란 색종이의 개수를 1 올림
        else {                          // 배열 원소의 합이 위에 해당하지 않으면 파란색종이와 흰 색종이가 섞여있는 경우이므로 분할을 시작함.
            int HS=S/2;
            int[][] LTArr=new int[HS][HS];
            int[][] RTArr=new int[HS][HS];
            int[][] LBArr=new int[HS][HS];
            int[][] RBArr=new int[HS][HS];
            for(int i=0; i<HS; i++) {
                LTArr[i]=Arrays.copyOfRange(arr[i], 0, HS);
                RTArr[i]=Arrays.copyOfRange(arr[i], HS, S);
                LBArr[i]=Arrays.copyOfRange(arr[i+HS], 0, HS);
                RBArr[i]=Arrays.copyOfRange(arr[i+HS], HS, S);
            }
            divider(LTArr);
            divider(RTArr);
            divider(LBArr);
            divider(RBArr);
        }

    }
}
