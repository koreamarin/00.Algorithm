package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 류지원
 * 문제 : BEAKJOON 2023 신기한소수
 * 메모리 : 11548KB
 * 시간 : 80ms
 * 풀이방식 :
 * 소수를 판별하는 메서드를 만들고,
 * 앞자리부터 10^n으로 나눠서 소수가 아니라면
 * 그 나눠진 수에 1을 더한 후 10^n을 다시 곱하여
 * 소수가 아닌 숫자들은 크게 건너뛰게끔 설계하였다.
 *
 */

public class BJ_02023_신기한소수_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int stp=(int)Math.pow(10, N), stt=stp/10;
        loop :
        for(int i=stt; i<stp;) {
            for(int j=N-1; j>=0; j--) {
                int dem = (int) Math.pow(10,j);
                int Num = i/dem;
                if(!decimalDiscriminator(Num)) {    // 소수가 아니면
                    i=(Num+1)*dem;      // Num에 1을 더하고 그 값에 dem을 곱하여 i를 크게 건너 뜀
                    continue loop;      // loop로 continue 이동.
                }
            }
            System.out.println(i++);
        }
    }
    public static boolean decimalDiscriminator(int Num) {   // 소수를 판별하는 메서드. 소수이면 true, 아니면 false 반환.
        if(Num==1) return false;
        for(int i=2; i<(int)Math.sqrt(Num)+1; i++) if(Num%i==0) return false;
        return true;
    }
}
