package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10974_모든순열 {
	static int N;
	static int numbers[];
	static boolean isSelected[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		isSelected = new boolean[N];
		permutation(0);
	}
	public static void permutation(int cnt) {
		if(cnt==N) {
			for(int i=0; i<cnt; i++) System.out.print(numbers[i] + " ");
			System.out.println();
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]==true) continue;
			numbers[cnt] = i+1;
			isSelected[i]=true;
			permutation(cnt+1);
			isSelected[i]=false;
		}
	}
}
