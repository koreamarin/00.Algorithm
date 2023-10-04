package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 메모리 : 47396KB
 * 시간 : 516ms
 * 풀이방법 : 
 * 1. 조합으로 팀을 2개로 나눴다.
 * 2. 1번에서 얻은 팀 별로 또 조합하여 팀능력치를 뽑았다.
 */

public class BJ_14889_스타트와링크_류지원 {
	static int N, sum, min=Integer.MAX_VALUE;
	static boolean[] isSelected;
	static int[][] arr;
	static int[] numbers = new int[2];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		N = Integer.parseInt(br.readLine());
		isSelected=new boolean[N];
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			ST = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(ST.nextToken());
			}
		}
		
		combination(0, 0);
		System.out.println(min);
		
	}
	
	// 2개의 팀을 나누는 조합. TeaA와 TeamB의 구성원을 조합함.
	public static void combination(int cnt, int start) {
		// 기저조건
		if(cnt==N/2) {
			List<Integer> TeamA=new ArrayList<Integer>();
			List<Integer> TeamB=new ArrayList<Integer>();
			
			for(int i=0; i<N; i++) {
				if(isSelected[i]) TeamA.add(i+1);
				else TeamB.add(i+1);
			}
			
			sum=0;
			combination2(0,0,TeamA);
			int TeamA_Ability=sum;
			
			sum=0;
			combination2(0,0,TeamB);
			int TeamB_Ability=sum;
			
			min=Math.min(min, Math.abs(TeamA_Ability-TeamB_Ability));
			
			return;
		}
		
		// 운용조건
		for(int i=start; i<N; i++) {
			isSelected[i]=true;
			combination(cnt+1, i+1);
			isSelected[i]=false;
		}
	}
	
	// 만들어진 팀의 팀원들을 다시 조합하여 팀의 능력치를 더하는 조합메서드
	public static void combination2(int cnt, int start, List<Integer> list) {
		// 기저조건
		if(cnt==2) {
			sum += arr[numbers[0]-1][numbers[1]-1] + arr[numbers[1]-1][numbers[0]-1];
			return;
		}
		
		// 운용조건
		for(int i=start; i<N/2; i++) {
			numbers[cnt]=list.get(i);
			combination2(cnt+1, i+1, list);
		}
	}
}
