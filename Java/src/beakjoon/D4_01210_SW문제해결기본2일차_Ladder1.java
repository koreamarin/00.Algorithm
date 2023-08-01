package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_01210_SW문제해결기본2일차_Ladder1 {
    public static void main(String[] args) throws IOException {
        // 키보드로 입력을 받기위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열의 구분자를 자동으로 인식하여 나누어주는 StringTokennizer 생성
        StringTokenizer ST;


        for(int t=1;t<11;t++) {		// 테스트케이스만큼 반복하는 반복문 실행
            // 테스트케이스를 입력받은 T 변수 생성 후 키보드로 입력받기
            int T=Integer.parseInt(br.readLine());
            // 100*100 배열 선언 및 생성
            int[][] arr = new int[100][100];
            for(int i=0;i<100;i++) {	// 100번의 반복문 실행
                ST=new StringTokenizer(br.readLine());	// 키보드로부터 한줄씩 입력받음

                // ST에 100개의 문자열토큰이 있으므로 100번의 반복문 실행. 배열의 0,0번부터 sweep하며 ST에 들어있는 문자열토큰을 하나씩 배열의 원소에 부여
                for(int j=0;j<100;j++) arr[i][j]=Integer.parseInt(ST.nextToken());
            }

            int j=0;		// 2가 있는 원소번호를 넣기위한 용도.
            // 100번째 있는 배열을 sweep하며 값이 2인 곳을 찾고, 값이 2라면 j에 해당원소값 i를 넣음.
            for(int i=0;i<100;i++) if(arr[99][i]==2) {j=i; break;}

            // 2 있는 인덱스부터 위로 올라가면서 옆에 1이 있으면 옆으로 이동, 옆에 없으면 위쪽으로만 이동.
            int i=98;
            while(i!=0) {
                if(j>=1 && arr[i][j-1]==1) {	/** 왼쪽이 0일때까지 계속 왼쪽으로 이동 */
                    while(j>=1 &&arr[i][j-1]==1) {
                        j--;
                    }
                    i--;
                }
                else if(j<=98 && arr[i][j+1]==1)	{/** 오른쪽이 0일때까지 계속 오른쪽으로 이동*/
                    while(j<=98 && arr[i][j+1]==1) {
                        j++;
                    }
                    i--;
                }
                else i--;
            }
            System.out.println("#" + T + " " + j);
        }
    }
}
