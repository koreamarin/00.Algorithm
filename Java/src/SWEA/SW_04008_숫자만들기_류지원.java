package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 
 * 시간 : 
 * 풀이방법 :
 * 1. 4칙연산을 Permutation하여 연산을 수행한 후 최대값 최소값을 찾는다.
 */

public class SW_04008_숫자만들기_류지원 {
	static int N, min, max;
	static char[] Chick4;
	static int[] numbers, cards;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			N = Integer.parseInt(br.readLine());	// 숫자의 개수
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			ST = new StringTokenizer(br.readLine());
			
			isSelected = new boolean[N-1];
			numbers = new int[N-1];
			Chick4 = new char[N-1];
			int m=0;
			for(int i=0; i<4; i++) {
				int n =Integer.parseInt(ST.nextToken());
				for(int j=0; j<n; j++) {
					if(i==0) Chick4[m++]='+';
					else if(i==1) Chick4[m++]='-';
					else if(i==2) Chick4[m++]='*';
					else if(i==3) Chick4[m++]='/';
				}
			}
			
			ST = new StringTokenizer(br.readLine());
			cards = new int[N];								// 숫자 순서대로 배열
			for(int i=0; i<N; i++) cards[i]=Integer.parseInt(ST.nextToken());
			
			permutation(0);
			
			System.out.println("#" + t + " " + (max - min));
		}
		
	}
	
	public static void permutation(int cnt) {
		// 기저조건
		if(cnt == N-1) {
			int L = cards[0];
			
			for(int i=0; i<N-1; i++) {
				if(Chick4[numbers[i]]=='+') 		L += cards[i+1];
				else if(Chick4[numbers[i]]=='-') 	L -= cards[i+1];
				else if(Chick4[numbers[i]]=='*')	L *= cards[i+1];
				else if(Chick4[numbers[i]]=='/') 	L /= cards[i+1];
			}
			
			min = Math.min(min, L);
			max = Math.max(max, L);
			
//			System.out.print(cards[0] + " ");
//			for(int i=0; i<N-1; i++) {
//				System.out.print(Chick4[numbers[i]] + " ");
//				System.out.print(cards[i+1] + " ");
//			}
//			System.out.println("= " + L);
			
			return;
		}
		
		// 운용조건
		for(int i=0; i<N-1; i++) {
			if(isSelected[i]==false) {
				isSelected[i]=true;
				numbers[cnt]=i;
				permutation(cnt+1);
				isSelected[i]=false;
			}
		}
		
	}

}
