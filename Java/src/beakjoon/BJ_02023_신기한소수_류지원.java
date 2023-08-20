package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 류지원
 * 문제 : BEAKJOON 2023 신기한소수
 *
 * 풀이 방식 :
 * 짝수가 들어가는 것들은 전부 제외 한다.
 * 각 자리수로 나눈 몫을 소수인지 검증한다.
 *
 */

public class BJ_02023_신기한소수_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder SB = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<Math.pow(10, N); i++) {
            for(int j=0; j<N; j++) {
                if(i%2==0) continue;
//                else if((i/10)) {}
            }

        }

    }

}
