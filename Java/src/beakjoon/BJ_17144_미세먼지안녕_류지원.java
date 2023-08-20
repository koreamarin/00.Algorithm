package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 39297kb
 * 시간 : 388ms
 * 풀이방법 :
 * 단순 구현하였다. 확산시키고, 배열돌리기로 순환시켰다.
 */

public class BJ_17144_미세먼지안녕_류지원 {
    static int R, C; static int[][] Room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());
        R=Integer.parseInt(ST.nextToken()); C=Integer.parseInt(ST.nextToken()); int T=Integer.parseInt(ST.nextToken());
        Room=new int[R][C];
        for(int i=0; i<R; i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) Room[i][j]=Integer.parseInt(ST.nextToken());
        }
        // T 1씩 증가 반복문
        for(int t=0; t<T; t++) {
            diffuse(Room);      // 확산
            circulation(Room);  // 공기청정기 순환
        }
        int sum=0;
        for(int i=0; i<R; i++) for(int j=0; j<C; j++) if(Room[i][j]>0) sum+=Room[i][j];
        System.out.println(sum);
    }
    public static void diffuse(int[][] Room) {
        int[][] diffusedRoom=new int[R][C];
        int[] dr={-1, 1, 0, 0};     // 위, 아래,, 왼쪽, 오른쪽
        int[] dc={0, 0, -1, 1};     // 위, 아래,, 왼쪽, 오른쪽
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(Room[i][j]!=0) {  // 미세먼지가 있는 곳이라면, 또는 공기청정기가 있는 곳이면 실행
                    int diffusible = 0;
                    for(int n=0; n<4; n++) {
                        if(0<=i+dr[n] && i+dr[n]<R && 0<=j+dc[n] && j+dc[n]<C && 0<=Room[i+dr[n]][j+dc[n]]) { // 상하좌우 확산 가능하면 확산 1 추가, 공기청정기를 만나거나 배열밖이면 확산불가.
                            diffusible+=1;          //확산 가능하면 확산 1 추가
                            diffusedRoom[i+dr[n]][j+dc[n]]+=Room[i][j]/5;       // 확산가능하므로 어느정도 확산수치 계산.
                        }
                    }
                    diffusedRoom[i][j]+=Room[i][j]-(Room[i][j]/5)*diffusible;       // 가운데 확산수치 계산
                }
            }
        }
        for(int i=0; i<R; i++) Room[i]=Arrays.copyOf(diffusedRoom[i], C);
    }
    public static void circulation(int[][] Room) {
        int airCleanerI=0, airCleanerJ=0;
        Loop :
        for(int i=0; i<R; i++) {                // 공기청정기 위치 찾기. 0부터 -1을 찾을때까지  sweep
            for(int j=0; j<C; j++) {
                if(Room[i][j]==-1) {
                    airCleanerI=i;
                    airCleanerJ=j;
                    break Loop;
                }
            }
        }
        // 공기청정기 위쪽 반시계방향으로 돌리기
        for(int i=airCleanerI-1; i>0; i--) Room[i][0]=Room[i-1][0];             // 1열 위치 바꾸기
        for(int j=0; j<C-1; j++) Room[0][j]=Room[0][j+1];                       // 1행 위치 바꾸기
        for(int i=0; i<airCleanerI; i++) Room[i][C-1] = Room[i+1][C-1];         // C-1열 위치 바꾸기
        for(int j=C-1; j>1; j--) Room[airCleanerI][j] = Room[airCleanerI][j-1]; // 공기청정기 행 위치 바꾸기
        Room[airCleanerI][airCleanerJ+1]=0;

        // 공기청정기 위치 다음 행부터 끝까지 시계방향으로 배열 돌리기, 공기청정기 오른쪽으로는 0이 나옴, 공기청정기 위치는 항상 -1로 고정
        for(int i=airCleanerI+2; i<R-1; i++) Room[i][0]=Room[i+1][0];               // 1열 위치 바꾸기
        for(int j=0; j<C-1; j++) Room[R-1][j]=Room[R-1][j+1];                       // R-1행 위치 바꾸기
        for(int i=R-1; i>airCleanerI+1; i--) Room[i][C-1]=Room[i-1][C-1];           // C-1열 위치 바꾸기
        for(int j=C-1; j>1; j--) Room[airCleanerI+1][j]=Room[airCleanerI+1][j-1];   // 공기청정기 다음행 위치 바꾸기
        Room[airCleanerI+1][airCleanerJ+1]=0;
    }
}
