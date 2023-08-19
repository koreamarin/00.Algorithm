package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * @author 류지원
 * 메모리 : 20140kb
 * 시간 : 106ms
 * 풀이방법 :
 * 나무의 키가 목표치까지 2가 남았다면, 1을 한번도 더하지 않고 기다렸다가 2를 더해야한다.
 * 나무의 키가 목표치까지 1이 남았다면, 1을 더할 수 있을 때, 1을 더한다.
 * 나무의 키가 위의 사항에 해당하지 않는다면 1또는 2를 더할 수 있을때 더한다.
 *
 * 위 조건을 적용하여 풀이하였다.
 */
public class D2_14510_나무높이_류지원 {
    static int targetH; static int N; static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        int T=Integer.parseInt(br.readLine());
        for(int t=1; t<T+1; t++) {
            N = Integer.parseInt(br.readLine());    // N 입력받기
            height = new int[N];                  // 나무들 키 배열 생성
            ST = new StringTokenizer(br.readLine());    // 나무들 키 입력받기
            for (int i=0; i<N; i++) height[i] = Integer.parseInt(ST.nextToken());   // 나무들 키 입력받기
            targetH=0;                              // 가장 높은 나무 할당
            for (int i=0; i<N; i++) if(targetH<height[i]) targetH=height[i];    // 가장 높은 나무 값 갱신.
            int day=0; int plus;
            Arrays.sort(height);
            // 날짜를 1씩 증가시키는 반복문
            while(valid(height)) {   // 모든 height가 targetH와 같아지면 반복문 종료
                // 날짜가 홀수면 1을, 짝수면 2를 더하기
                day+=1;
                plus=((day+1)%2)+1;
                // 메서드에서 height를 sweep하여 나무를 증가시키고, 반환하기.
                heightPlus(plus);
            }
            System.out.println("#"+t+ " " + day);
        }
    }
    public static void heightPlus(int plus) {
        // 메서드에서 height를 sweep하고, 나무를 증가시키면 반환하기. 증가시키지 못했더라도 반환.
        for(int i=N-1; i>=0; i--) {
            if (height[i] + 2 == targetH && plus != 2) continue;    // 나무의 키가 목표치까지 2가 남았는데 2를 더하는 날이 아닐 경우 해당 나무는 패스.
            else if (height[i] + 1 == targetH && plus != 1) continue;   // 나무의 키가 목표치까지 1이 남았는데 1을 더하는 날이 아닐 경우 해당 나무는 패스.
            else if (height[i]+plus <= targetH) {   // 나무의 키에 오늘 자랄 키가 타겟보다 같거나 작을 경우
                height[i] += plus;  // 나무의 키 더하기.
                return;
            }
        }
    }
    public static boolean valid(int[] height) { // 나무의 키가 모두 target만큼 자랐다면 false를 반환, 아직 덜 자랐다면 true를 반환
        for(int i=0; i<N; i++) if(height[i]!=targetH) return true;
        return false;
    }

}
