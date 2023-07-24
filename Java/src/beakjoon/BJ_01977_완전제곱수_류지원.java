package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BJ_01977_완전제곱수_류지원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(ST.nextToken());
        ST = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(ST.nextToken());
        ArrayList<Integer> A = new ArrayList();

        for (int i = 1; i < 101; i++) {
            if (N <= i * i && M >= i * i) {
                A.add(i * i);
            }
        }
        int sum = 0;
        for(int i=0; i<A.size(); i++) {
            sum+=A.get(i);
        }

        if (A.size()>0) {
            System.out.println(sum);
            System.out.print(A.get(0));
        } else {
            System.out.print(-1);
        }


    }

}