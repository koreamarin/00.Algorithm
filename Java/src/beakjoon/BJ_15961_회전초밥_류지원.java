package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 :
 * 시간 :
 * 풀이 방식 :
 *
 *
 */
public class BJ_15961_회전초밥_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;

        ST=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(ST.nextToken());     // 벨트에 놓인 접시의 수
        int d=Integer.parseInt(ST.nextToken());     // 초밥의 가짓수
        int k=Integer.parseInt(ST.nextToken());     // 연속해서 먹어야할 접시의 수
        int c=Integer.parseInt(ST.nextToken());     // 쿠폰 번호

        int[] belt=new int[N];
        for(int n=0;n<N; n++) belt[n]=Integer.parseInt(br.readLine());
        int[] visited = new int[d+1];
        int ans=0;
        int total=0;
        for (int i = 0; i < k; i++) {
            if(visited[belt[i]] ==0) total++;
            visited[belt[i]]++;
        }
        ans = total;
        for (int i = 1; i < N; i++) {
            if(ans<=total) {
                if(visited[c]==0) ans = total+1;
                else ans = total;
            }
            visited[belt[i-1]]--;
            if(visited[belt[i-1]]==0)total--;
            if(visited[belt[(i+k-1)%N]]==0)total++;
            visited[belt[(i+k-1)%N]]++;
        }
        System.out.print(ans);
    }
}
