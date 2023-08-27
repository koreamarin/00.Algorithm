package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_03025_돌던지기_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST=new StringTokenizer(br.readLine());
        int R=Integer.parseInt(ST.nextToken()), C=Integer.parseInt(ST.nextToken());
        char[][] map=new char[R][C];
        for(int i=0; i<R; i++) {
            String Line=br.readLine();
            for(int j=0; j<C; j++) map[i][j]=Line.charAt(j);
        }
        int N=Integer.parseInt(br.readLine());
        int[] throwRock=new int[N];
        for(int n=0; n<N; n++) throwRock[n]=Integer.parseInt(br.readLine())-1;
        for(int turn=0; turn<N; turn++) {
            int c=throwRock[turn];                  // 돌을 던진다.
            for(int i=0; ;) {                       // 돌이 한칸씩 내려간다
                if(i==R-1 || map[i+1][c]=='X') {    // 1. 돌이 다 내려오거나 2. 돌이 벽을 만나면 멈춘다.
                    map[i][c]='O';
                    break;
                }
                else if(map[i+1][c]=='O') {         // 3. 돌이 돌을 만나면
                    if(0<c && map[i][c-1]=='.' && map[i+1][c-1]=='.') {         // 2-1. 돌이 돌을 만나면 왼쪽이랑 왼쪽 아래가 비어있는지 확인한다. 비어있다면 그쪽으로 내려간다.
                        i++; c--;
                    }
                    else if(c<C-1 && map[i][c+1]=='.' && map[i+1][c+1]=='.') {  // 2-2. 왼쪽이나 왼쪽 아래가 막혀 있다면 오른쪽이랑 오른쪽 아래가 비어있는지 확인한다. 비어있다면 그쪽으로 내려간다.
                        i++; c++;
                    }
                    else {                                                      // 2-3. 둘 다 해당되지 않는다면 제자리에 멈춘다.
                        map[i][c] = 'O';
                        break;
                    }
                }
                else i++;// 4. 돌이 아무것도 안만난다.
            }
        }
        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) System.out.print(map[i][j]);
            System.out.println();
        }
    }
}
