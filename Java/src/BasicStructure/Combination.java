package BasicStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 조합 기본 구조
 * 뽑힌 숫자를 저장할 numbers[]를 사용해야함.
 */

public class Combination {
	static int N, R;
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		numbers=new int[R];
		
		combination(0, 0);
	}
	
	public static void combination(int cnt, int start) {
		// 기저조건
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 운용조건
		for(int i=start; i<N; i++) {
			numbers[cnt]=i;
			combination(cnt+1, i+1);
		}
		
	}

}
