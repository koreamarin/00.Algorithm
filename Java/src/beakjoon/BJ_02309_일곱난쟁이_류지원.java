package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author 류지원
 * 메모리 : 11536KB
 * 수행시간: 80ms
 * 풀이 : 조합문제이므로 재귀를 이용한 조합방식으로 7개의 난쟁이를 선택하여 그 키의 합이 100인지 연산한다.
 *
 */

public class BJ_02309_일곱난쟁이_류지원 {
	static int[] dwarves=new int[9];	// 난쟁이 9마리의 키를 저장할 배열
	static int[] numbers=new int[7];	// 선택된 난쟁이 7마리를 저장할 배열
	static boolean[] isSelected=new boolean[9];	// 난쟁이 9마리중 어떤 난쟁이가 선택되었는지 저장할 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 난쟁이들 키 입력.
		for(int n=0;n<9;n++) dwarves[n]=Integer.parseInt(br.readLine());
		dwarves7(0);	// 난쟁이 키 조합 재귀 시작
	}
	
	public static boolean dwarves7(int cnt) {
		if(cnt==7) {// 기저조건
			int sum=0;	// 난쟁이 키의 합을 저장할 변수
			for(int i=0;i<7;i++) sum+=numbers[i];
			int[] R=Arrays.copyOf(numbers, 7);
			Arrays.sort(R);
			if(sum==100) {
				for(int i=0;i<7;i++) {
					System.out.println(R[i]);	// 난쟁이 키가 합이 100일 시 난쟁이키 출력
				}
				return true;	// true를 반환
			}
			return false;	// false를 반환
		}

		// 유도파트
		for(int i=cnt; i<9-6+cnt; i++) {	//
			if(!isSelected[i]) {		// 난쟁이가 선택되지 않았을 시 조건문 실행
				numbers[cnt]=dwarves[i];
				isSelected[i]=true;		// 난쟁이가 선택되었으므로 true로 바꿔주기
				if(dwarves7(cnt+1)) return true;	// true가 반환되었을 시 재귀를 빠져나가기 위해 계속 true를 반환
				isSelected[i]=false;		// 난쟁이 선택이 완료되었으므로 다시 false로 바꿔주기
			}
		}
		return false;	// false 반환.
	}
}
