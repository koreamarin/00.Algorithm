package beakjoon;

import java.io.*;

public class BJ_11729_하노이탑이동순서_류지원 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // 키보드로부터 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // CLI로 출력을 하기 위한 BufferedWriter 객체 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 탑 개수 N 입력받기.
        int N = Integer.parseInt(br.readLine());
        // 이동횟수 cnt, 하노이 함수가 재귀하며 이동횟수를 반환
        int cnt = hanoi(N,1,2,3,0);

        // br에 이동횟수와 개행문자를 입력
        bw.write(String.valueOf(cnt)+"\n");
        // br에 하노이 객체에서 재귀하며 입력되었던 sb에 담긴 문자열 추가입력.
        bw.write(sb.toString());
        // bw를 CLI에 출력하고 스트림을 닫는다.
        bw.close();
    }
    public static int hanoi(int n, int stt, int via, int stp, int cnt) {
        // 재귀하는 즉시 cnt 1증가.
        cnt++;
        // n이 1이라면 다르게 행동
        if (n == 1) {
            // 스타트에 있는 것을 스탑으로 바로 옮기므로 그 문자를 출력
            sb.append(stt + " " + stp + "\n");
            // cnt 반환
            return cnt;
        }
        // 가장 큰 원판을 옮기기 전에 행하는 재귀
        cnt = hanoi(n-1, stt, stp, via, cnt);
        // 가장 큰 원판을 옮기는 라인. 그 이동을 sb에 담음.
        sb.append(stt + " " + stp + "\n");
        // 가장 큰 원판을 옮기고 난 후의 탑을 옮기는 재귀
        cnt = hanoi(n-1, via, stt, stp, cnt);
        // cnt 반환
        return cnt;
    }
}
