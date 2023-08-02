package SWEA;

/**
 * @author 류지원
 * 문제 : SWEA 1954 달팽이숫자
 * 
 * 메모리 사용량 : 19432kb
 * 처리 시간 : 106ms
 *
 * 풀이 방식 :
 * 배열을 동서남북 순서로 순환하며 1씩 높여가면서 값을 부여한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_01954_달팽이숫자_류지원 {
    public static void main(String[] args) throws IOException {
        // 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트횟수를 저장할 변수 선언 및 키보드로 값을 입력받아 저장.
        int T = Integer.parseInt(br.readLine());
        // 테스트케이스 횟수만큼 반복문 실행
        for(int t=1; t<T+1; t++) {
            // 배열의 크기를 저장할 정수형변수 선언 후 키보드로부터 입력받아 저장.
            int N = Integer.parseInt(br.readLine());
            // N*N크기 정수형 이차원배열 선언 및 생성
            int[][] arr = new int[N][N];

            int R=0;    // 동남서북 방향을 지정해줄 정수형변수 R 생성
            int i=0; int j=0; int k=1;  // 행과 열을 나타내줄 i와 j 생성, 값을 부여해줄 정수형 변수 k 생성
            for(int n=0; n<N*N; n++) {  // N*N-1 횟수를 반복하는 반복문 실행
                if(arr[i][j]==0) {      // 만약 arr[i][j]가 0이라면 실행
                    arr[i][j]=k++;      // arr[i][j]에 k의 값을 부여하고 k값 1 증가.
                    if(R==0) {          // R이 0이라면 동쪽으로 이동하는 조건.
                        if(j+1>=N || arr[i][j+1]!=0) {  // j+1이 N이상이거나 arr[i][j+1]이 0이 아니라면
                            R=1;    // R에 1을 부여하여 다음 반복부터 남쪽으로 이동시킴
                            i++;    // i값 1 증가
                        } else j++; // 위 조건에 해당하지 않으면 j값 1 증가
                    } else if(R==1) {   // R이 1이라면 남쪽으로 이동하는 조건.
                        if(i+1>=N || arr[i+1][j]!=0) {  // i+1이 N이상이거나 arr[i+1][j]이 0이 아니라면
                            R=2;    // R에 2을 부여하여 다음 반복부터 남쪽으로 이동시킴
                            j--;    // j값 1 감소
                        } else i++; // 위 조건에 해당하지 않으면 i값 1 증가
                    } else if(R==2) {   // R이 2이라면 남쪽으로 이동하는 조건.
                        if(j-1<0 || arr[i][j-1]!=0) {   // j-1이 0미만이거나 arr[i][j-1]이 0이 아니라면
                            R=3;    // R에 3을 부여하여 다음 반복부터 서쪽으로 이동시킴
                            i--;    // i값 1 감소
                        } else j--; // 위 조건에 해당하지 않으면 j값 1 감소
                    } else if(R==3) {   // R이 3이라면 북쪽으로 이동하는 조건.
                        if(i-1<0 || arr[i-1][j]!=0) {   // i-1이 0미만이거나 arr[i-1][j]이 0이 아니라면
                            R=0;    // R에 0을 부여하여 다음 반복부터 동쪽으로 이동시킴
                            j++;    // j값 1 증가
                        } else i--; // 위 조건에 해당하지 않으면 i값 1 감소
                    }
                }
            }
            System.out.println("#"+t);  // 테스트케이스 횟수 출력
            for(int r=0;r<N;r++) {      // arr 배열을 출력하는 반복문
                for(int c=0;c<N;c++) {
                    System.out.print(arr[r][c]+" ");
                }
                System.out.println();   // 한칸 띄우기
            }
        }
    }
}