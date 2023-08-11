package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 
 * 
 * @author 류지원
 * 메모리 : 11492KB
 * 시간 : 76ms
 * 풀이방법 :
 * 그리디 방식으로 풀이하였다.
 * 5Kg으로 주는 것이 더 적은 봉지를 가져가면 되는 방식이므로
 * 5kg의 봉지를 최대한으로 하면서 3으로 나누어 떨어지는지 비교하였고,
 * 나누어 떨어지지 않다면 5kg 봉지를 한개씩 줄여가며 3으로 나누어 떨어지는 지 비교하였다.
 * 
 */

public class BJ_02839_설탕배달_류지원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());	// N 입력받기
		System.out.println(st(N));
	}
	public static int st(int N) {	// N이 5를 가능한 높은 숫자로 나누고, 그 숫자가 3으로 나누어 떨어지는지 확인하는 메서드. 
		for(int i=N/5; i>=0; i--) {
			int A=(i==0)?N:N-(5*i);
			if(A%3==0) return (i)+(A/3);
		}
		return -1;
	}
}
