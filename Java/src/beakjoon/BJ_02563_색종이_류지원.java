package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 11576KB
 * 수행시간 : 76ms
 * 풀이방법 :
 * 1. 100*100 boolean 배열을 만든다.
 * 2. 색종이의 면적에 해당하는 부분이 false라면 true로 만들고 sum 변수에 1을 추가한다.
 * 3. 모든 색종이에 위와 같은 계산을 수행 후 sum을 출력한다.
 */

public class BJ_02563_색종이_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        int N=Integer.parseInt(br.readLine());
        int sum=0;
        boolean[][] arr=new boolean[100][100];  // 100*100 도화지.
        for(int n=0;n<N; n++) { // 색종이의 개수만큼 반복
            ST=new StringTokenizer(br.readLine());  // 색종이의 위치값 받기
            int row=Integer.parseInt(ST.nextToken())-1; // 색종이모서리의 x좌표
            int column=Integer.parseInt(ST.nextToken())-1;  // 색종이 모서리의 y좌표
            for(int i=row;i<row+10; i++) {  // 색종이모서리, 즉 시작지점에서 x좌표축으로 10을 더한만큼 반복
                for(int j=column;j<column+10;j++) { // 색종이 모서리, 즉 시작지점에서 y좌표축으로 10을 더한만큼 반복
                    if(arr[i][j]==false) {  // 색종이가 덮은 지점의 상태가 false이라면
                        arr[i][j]=true;     // 그 지점을 true로 변환
                        sum++;              // sum에 1 추가
                    }
                }
            }
        }
        System.out.println(sum);        // sum 출력
    }
}
