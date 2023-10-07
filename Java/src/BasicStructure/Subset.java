package BasicStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * 부분집합 기본 구조
 * 선택됐는지 아닌지를 체킹하기 위햔 boolean[] isSelected를 사용해야함.
 */
public class Subset {
	static int N;
	static boolean[] isSelected;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		isSelected=new boolean[N];
		
		System.out.println("부분집합");
		subset(0);
	}
	
	public static void subset(int cnt) {
		// 기저조건
		if(cnt==N) {
			System.out.println(Arrays.toString(isSelected));
			return;
		}
		
		// 운용조건
		isSelected[cnt]=false;
		subset(cnt+1);
		isSelected[cnt]=true;
		subset(cnt+1);
	}

}
