package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_04012_요리사_류지원 {
	static int N;
	static boolean[] isSelected;
	static int[] numbers=new int[4];
	static ArrayList<int []> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int t=1;t<T+1; t++) {
			list = new ArrayList<>(); 
			// N입력받기
			N=Integer.parseInt(br.readLine());
			isSelected=new boolean[N];
			int[][] ingredients = new int[N][N];
			// 맛조합 배열 입력받기
			for(int i=0;i<N;i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) ingredients[i][j]=Integer.parseInt(ST.nextToken());
			}
			// 1. 맛 조합 합산 배열 만들기
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					ingredients[i][j]+=ingredients[j][i];
					ingredients[j][i]=ingredients[i][j];
				}
			}
			combination4(0);

			for(int[] i : list) {
				System.out.println(Arrays.toString(i));
			}

		}
	}
	
	public static void combination4(int cnt) {
		if(cnt==4) {
			list.add(Arrays.copyOf(numbers, 4));
			return;
		}
		
		for(int i=cnt; i<N-3+cnt; i++) {
			if(cnt==0 || numbers[cnt-1]<i) {
				numbers[cnt]=i;
				combination4(cnt+1);
			}
		}
	}

}
