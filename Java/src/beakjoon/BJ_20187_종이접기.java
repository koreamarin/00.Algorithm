package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author "Ryu jiwon"
 * 메모리 : 
 * 시간 : 
 * 풀이방법 : 
 * 
 */


public class BJ_20187_종이접기 {
	static int h, k;
	static char[] fold;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫째줄 입력 받기
		k = Integer.parseInt(br.readLine());
		// 둘째줄 입력 받기
		StringTokenizer ST = new StringTokenizer(br.readLine());
		fold = new char[2*k];
		for(int i=0; i<2*k; i++) fold[i]=ST.nextToken().charAt(0);
		// 셋째줄 입력 받기
		h=Integer.parseInt(br.readLine());
		
		int l = (int) Math.pow(2, k);
		int[][] arr = new int[l][l];
		
		arr = fold(arr, 0, 0, 0, l, l);

	}
	
	public static int[][] fold(int[][] arr, int n, int cr, int cc, int rl, int cl) {
		// 기저조건
		if(n==(2*k)-1) {
			arr[cr][cc]=h;
			if(fold[n]=='U') {
				arr[cr+(rl/2)][cc]=numChange(arr[cr][cc], fold[n]);
			} else if(fold[n]=='D') {
				arr[cr-(rl/2)][cc]=numChange(arr[cr][cc], fold[n]);
			} else if(fold[n]=='L') {
				arr[cr][cc+(cl/2)]=numChange(arr[cr][cc], fold[n]);
			} else if(fold[n]=='R') {
				arr[cr][cc-(cl/2)]=numChange(arr[cr][cc], fold[n]);
			}
			return arr;
		}
		
		// 운용조건
		int[][] nextArr;
		
		if(fold[n]=='U' || fold[n]=='D') {
			nextArr=new int[rl/2][cl];
		} else {
			nextArr=new int[rl][cl/2];
		}
		
		if(fold[n]=='D') {
			cr+=rl/2;
		} else if(fold[n]=='R') {
			cc+=cl/2;
		}
		
		nextArr = fold(nextArr, n+1, cr, cc, rl/2, cl/2);
		
		if(fold[n]=='U') {
			for(int i=0; i<rl/2; i++) {
				arr[cr+i]
			}
		}
		

	}
	
	public static int numChange(int h, char fold) {
		if(fold =='U' || fold == 'D') return (h+2)%4;
		return (h%2==0) ? h+1 : h-1;
	}

}
