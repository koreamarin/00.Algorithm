package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13458_시험_감독_류지원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer ST;
        
        int N=Integer.parseInt(br.readLine());
        ST = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) A[i]=Integer.parseInt(ST.nextToken());
        ST = new StringTokenizer(br.readLine());
		int B=Integer.parseInt(ST.nextToken());
		int C=Integer.parseInt(ST.nextToken());
		
		System.out.println(N);
		for(int i=0; i<N; i++) System.out.println(A[i]);
		System.out.println(B);
		System.out.println(C);
	}

}
