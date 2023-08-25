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
 * 배열 슬라이딩 방식을 이용하여 한칸씩 이동하며 초밥의 개수를 카운팅하였다.
 * 하지만 99%에서 실패하였고, 아직 이유를 찾지 못하였다.
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
        int count = 0;
        int[] visit = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (visit[belt[i]]== 0) count++;
            visit[belt[i]]++;
        }
        int check = count;
        for (int i = 1; i < N; i++) {
            if (check <= count) {
                check = count;
                if (visit[c] == 0) check++;
            }
            visit[belt[i - 1]]--;
            if (visit[belt[i-1]] == 0) count--;
            if (visit[belt[(i+k-1)%N]]==0) count++;
            visit[belt[(i+k-1) % N]]++;
        }
        System.out.print(check);
    }
}
