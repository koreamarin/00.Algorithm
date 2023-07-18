package beakjoon;
/**
 * @author 류지원
 * 
 * 문제 : SWEA 1959. 두 개의 숫자열
 * 
 * 해결방법
 * Ai와 Bj를 배열로 각각 받은 후, 더 작은 배열을
 * 움직이면서 각각 곱하여, 곱했을때 나오는 수들을 다른 R배열에 저장한다.
 * 그 후, R배열에서 가장 큰 수를 찾아 출력한다.
 */
import java.util.Scanner;

public class SWEA01959 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int S = (M>N) ? M-N+1 :N-M+1;
			
			int[] A = new int [N];
			int[] B = new int [M];
			int[] R = new int [S];
			
			for (int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			
			for (int j=0; j<M; j++) {
				B[j] = sc.nextInt();
			}
			
			for (int i=0; i<N; i++) {
				for (int)
			}

			
		}

	}

}
