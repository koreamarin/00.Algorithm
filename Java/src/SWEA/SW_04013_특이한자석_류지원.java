package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 19104 kb
 * 시간 : 108ms
 * 풀이방법 :
 * 어떤 자석을 직접 돌리면, 그 주변 자석들은 직접돌린자석의 반대방향으로 돌아간다. 그 이후의 자석들도 이웃한 돌아가는 자석의 반대방향으로 돌아간다.
 * 어떤 하나의 자석을 돌렸을 때, 이웃한 자석들이 모두 반대방향으로 돌아가는 메서드를 생성하였다.
 * 하지만, 서로 자성의 극이 반대가 아닐때에는 돌아가지 않아야 한다.
 * 서로 극이 반대인지를 판단하기 위해 valid 메서드를 생성하였고, 극성이 반대일 때에만 valid 메서드가 true를 반환하여
 * 이웃한 톱니가 돌아가게끔 하였다.
 * Ratation 함수는 톱니를 돌리는 메서드이다.
 * 또한, 이웃한 톱니를 돌려주는 역할을 재귀적으로 수행하는데, valid가 true를 반환할때에만 이웃한 톱니를 돌려준다.
 */
public class SW_04013_특이한자석_류지원 {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<T+1; t++) {
            int K=Integer.parseInt(br.readLine());  // 자석 회전 횟수 K
            arr=new int[4][8];              // 자석 NS 형태 배열
            for(int i=0; i<4; i++) {
                ST=new StringTokenizer(br.readLine());
                for(int j=0; j<8; j++) arr[i][j]=Integer.parseInt(ST.nextToken());      // 자석 형태 입력받기
            }
            int[][] RTTInfo=new int[K][2];      // 어떤 자석을 어떻게 회전시킬건지를 저장할 배열
            for(int i=0; i<K; i++) {
                ST=new StringTokenizer(br.readLine());
                for(int j=0; j<2; j++) RTTInfo[i][j]=Integer.parseInt(ST.nextToken());  // 어떤 자석을 어떻게 회전시킬건지를 입력받음.
            }
            for(int k=0; k<K; k++) Rotation(RTTInfo[k][0]-1, RTTInfo[k][1], 0);     // 회전시키기, RTTInfo[k][0]번 톱니를 RTTInfo[k][1] 방향으로 돌림
            int sum=0;       // 점수가 몇점인지 저장할 변수
            for(int i=0; i<4; i++) if(arr[i][0] == 1) sum += Math.pow(2,i);     // 점수 계산
            System.out.println("#" + t + " " + sum);
        }
    }
    public static boolean vaild(int f, int b, int R) {          // 돌리지 안돌릴지 검증하는 함수. 두개의 자석의 극이 같다면 돌리지 않는다.
        if(f<b && (arr[f][2+R] != arr[b][6])) return true;
        else if(f>b && (arr[f][6+R] != arr[b][2])) return true;
        return false;
    }
    public static void Rotation(int i, int R, int direction) {       // 자석을 돌리는 메서드
        switch (R) {        // 시계방향으로 돌림
            case 1 : {
                int save = arr[i][7];
                for (int j = 7; j > 0; j--) arr[i][j] = arr[i][j - 1];
                arr[i][0] = save;
                break;
            }
            case -1 : {      // 반시계방향으로 돌림
                int save = arr[i][0];
                for (int j = 0; j < 7; j++) arr[i][j] = arr[i][j + 1];
                arr[i][7] = save;
                break;
            }
        }
        if(direction>=0 && i+1 <  4 && vaild(i, i+1, R)) Rotation(i+1,R*-1,  1);      // 톱니 배열을 벗어나지 않고, 다음 톱니를 돌려도 된다면, i+1번째 톱니를 현재 톱니 반대방향으로 돌림.
        if(direction<=0 && i-1 >= 0 && vaild(i, i-1, R)) Rotation(i-1,R*-1, -1);      // 톱니 배열을 벗어나지 않고, 이전 톱니를 돌려도 된다면, i-1번째 톱니를 현재 톱니 반대방향으로 돌림.
    }
}
