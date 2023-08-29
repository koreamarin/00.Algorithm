package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 시간 :
 * 풀이방법 :
 * BFS로 flood fill을 한 후, 바다와 연결된 곳들을 모두 BFS로 최단거리를 찾아서
 * 다른 섬과 연결되는 다리의 최소길이를 찾을 것이다.
 */

public class BJ_02146_다리만들기_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int N=Integer.parseInt(br.readLine());
        int[][] map=new int[N][N];
        for(int i=0; i<N; i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
//                map[i][j]=
            }
        }



    }
}
