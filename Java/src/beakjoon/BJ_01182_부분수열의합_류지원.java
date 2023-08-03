package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01182_부분수열의합_류지원 {
    static int N;
    static int S;
    static int[] arr;
    static boolean[] isSelected;
    static int amt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        ST = new StringTokenizer(br.readLine());
        N = Integer.parseInt(ST.nextToken());
        S = Integer.parseInt(ST.nextToken());

        isSelected = new boolean[N];

        arr = new int[N];
        ST = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i]=Integer.parseInt(ST.nextToken());

        suyulhap(0);
        System.out.println(amt);
    }
    public static void suyulhap(int cnt) {
        if(cnt==N) {
            int sum=0;

            for(int n=0; n<N; n++) {	// 모든 원소가 선택되지 않을 경우는 쓴맛과 신맛의 조합을 계산하지 않고 리턴하려는 목적의 반복문
                if(isSelected[n]) break;	// isSelected[n]이 하나라도 true인 경우에는 반복문 종료
                else if(isSelected[n]==false) {	// isSelected[n]이 false일 경우에는 다음 반복을 실행하여 계속 검증 시행
                    if(n==N-1) return;		// 모든 isSelected가 false일 경우 아래 계산을 시행하지 않고 메서드 종료.
                }
            }

            for(int i=0; i<N; i++) if(isSelected[i]) sum+=arr[i];
            if(sum==S) amt++;
            return;
        }

        isSelected[cnt]=true;
        suyulhap(cnt+1);
        isSelected[cnt]=false;
        suyulhap(cnt+1);
    }
}
