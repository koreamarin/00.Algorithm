package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 류지원
 * 메모리 : 11492
 * 시간 : 80ms
 * 풀이방법
 * 7명의 난쟁이를 골아야하며, 순서가 의미가 없으므로 조합문제이다.
 * 재귀를 이용한 조합을 구현하였다.
 */

public class BJ_03040_백설공주와일곱난쟁이_류지원 {	
	static int[] dwarves=new int[9];
	static boolean[] isSelected=new boolean[9];
	static int numbers[]=new int[7];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 난쟁이들 키 입력.
		for(int n=0;n<9;n++) dwarves[n]=Integer.parseInt(br.readLine());
		dwarves7(0);
	}
	
	public static void dwarves7(int cnt) {
		if(cnt == 7) {
			int sum=0;
			for(int i=0; i<7; i++) sum+=numbers[i];
			if(sum==100) for(int i=0; i<7; i++) System.out.println(numbers[i]);
			return;
		}
		for(int i=0; i<9; i++) {
			if(!isSelected[i] && cnt==0||(cnt>0 && numbers[cnt-1]<dwarves[i])) {
				numbers[cnt]=dwarves[i];
				isSelected[i]=true;
				dwarves7(cnt+1);
				isSelected[i]=false;
			}
		}
	}
}
