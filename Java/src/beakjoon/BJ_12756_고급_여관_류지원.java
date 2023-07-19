package beakjoon;

/**
 * @author 류지원
 * 문제 : BEAKJOON 12756 고급 여관
 *
 * 풀이 방식 :
 * 단순 구현 문제이다. 서로의 카드에 생명력에 상대방의 공격력만큼 뺴주고,
 * 0이 이하인지 아닌지 비교하면 승패를 가를 수 있다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12756_고급_여관_류지원 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int A_attack_Point = Integer.parseInt(A.split(" ")[0]);
        int A_defence_Point = Integer.parseInt(A.split(" ")[1]);
        int B_attack_Point = Integer.parseInt(B.split(" ")[0]);
        int B_defence_Point = Integer.parseInt(B.split(" ")[1]);

        while (true) {
            A_defence_Point -= B_attack_Point;
            B_defence_Point -= A_attack_Point;

            if (A_defence_Point <= 0 && B_defence_Point <= 0) {
                System.out.println("DRAW");
                break;
            } else if (A_defence_Point <= 0) {
                System.out.println("PLAYER B");
                break;
            } else if (B_defence_Point <= 0) {
                System.out.println("PLAYER A");
                break;
            }
        }



    }
}
