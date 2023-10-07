package BasicStructure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 순열 기본 구조
 * 중복순열이 아니라면 뽑힌숫자를 다시 뽑지않기위해 boolean[] isSelected를 사용해야함.
 * 뽑힌 숫자를 저장할 int[] numbers를 사용해야함.
 */

public class Permutation {
	static int N, R;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		numbers=new int[R];
		isSelected=new boolean[N];
		
		System.out.println("중복 불가한 순열");
		permutation(0);
		
		System.out.println("\n중복 순열");
		duplicationPermutation(0);
	}
	
	public static void permutation(int cnt) {
		// 기저조건
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 운용조건
		for(int i=0; i<N; i++) {
			if(isSelected[i]==false) {
				numbers[cnt]=i;
				isSelected[i]=true;
				permutation(cnt+1);
				isSelected[i]=false;
			}
		}
	}
	
	public static void duplicationPermutation(int cnt) {
		// 기저조건
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 운용조건
		for(int i=0; i<N; i++) {
			numbers[cnt]=i;
			duplicationPermutation(cnt+1);
		}
	}

}
