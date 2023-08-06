package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 류지원
 * 문제 : BEAKJOON 2023 신기한소수
 *
 * 풀이 방식 :
 * 1. N+1 자리수까지 소수 배열 만들기
 * 2. 반복문 사용해서 sweep하면서 곱해서 나온 숫자의 배열원소는 true로 바꾸기
 * 3. N자리 구간 탐색하며 소수만 추출하기
 * 4. 추출한 소수들 신기한 소수인지 소수 배열에서 확인하기.
 */

public class BJ_02023_신기한소수_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder SB = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int D = (int) Math.pow(10,N);
        // 1. N+1 자리수까지 소수 배열 만들기
        boolean[] arr = new boolean[D];
        arr[0]=true; arr[1]=true;

        for(int i=2; i<D; i++) for(int n=2; i*n<D; n++) if(!arr[i*n]) arr[i*n]=true;

        for(int i=D/10; i<D; i++) {
            if(!arr[i]) {
                for(int j=0; j<N-1; j++) {
                    if(arr[i/(int)(Math.pow(10,j+1))]) break;
                    else if(j==N-2) SB.append(i+"\n");
                }
            }
        }
        System.out.println(SB);
    }
}
