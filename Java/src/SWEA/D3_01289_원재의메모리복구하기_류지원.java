package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_01289_원재의메모리복구하기_류지원 {
	static int [] orgMmy;
	static int orgMmyNum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String orgMmyStr = br.readLine();
			orgMmyNum=orgMmyStr.length();
			orgMmy = new int[orgMmyNum];
			for(int i=0; i<orgMmyNum;i++) orgMmy[i]=Integer.parseInt(String.valueOf(orgMmyStr.charAt(i)));
			
			int sum = changeNum(0);
			System.out.println("#" + (t+1) + " " + sum);
		}
	}
	public static int changeNum(int n) {
		int sum=0;
		
		
		int[] Mmy=orgMmy;
		
		
		
		
		 
		
		
		if(orgMmyNum==n+1) { return sum; }
		return sum+changeNum(n);
	}
}
