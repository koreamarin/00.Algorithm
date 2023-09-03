package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 12836KB, 시간 : 136ms
 * 풀이방법 :
 * dfs를 이용하여 순열을 만들어서 사용하였다.
 */

public class BJ_10971_외판원순회2_류지원 {
    static int N;
    static boolean[] isVisited; // 방문했는지 확인하기 위한 배열
    static int[][] adjMatrix;   // 그래프 배열
    static long MIN = Integer.MAX_VALUE;    // 최단거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        N=Integer.parseInt(br.readLine());
        adjMatrix=new int[N][N];
        for(int i=0; i<N; i++) {
            ST=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) adjMatrix[i][j]=Integer.parseInt(ST.nextToken());
        }

        for(int i=0; i<N; i++) {
            isVisited = new boolean[N];     // 새로운 배열 할당
            isVisited[i] = true;            //
            dfs(i, i, 0);              // dfs 실행.
        }
        System.out.println(MIN);
    }

    public static void dfs(int S, int current, int exp){
        if (VisitedCheck()) {               // 전부다 탐색 했는지 확인
            if(adjMatrix[current][S]!=0)    // 처을으로 돌아가는 방법이 있다면 실행
                if(MIN>exp+adjMatrix[current][0]) MIN=exp+adjMatrix[current][0];    // 최소값 갱신.
            return;
        }

        for(int i=1; i<N; i++){
            if (!isVisited[i] && adjMatrix[current][i] != 0) {
                isVisited[i] = true;                // 순열 재귀 전 방문처리
                dfs(S, i, exp + adjMatrix[current][i]); //
                isVisited[i] = false;               // 순열 재귀 후 방문X
            }
        }
    }

    public static boolean VisitedCheck() {  // 전부 방문했는지 확인하는 메서드.
        for (int i = 0; i<N; i++) if (!isVisited[i]) return false;
        return true;
    }
}
