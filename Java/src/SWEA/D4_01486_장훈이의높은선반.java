package SWEA;

import java.io.*;
import java.util.*;

public class D4_01486_장훈이의높은선반{
	static int N,B,min,H[];
	
	static void subs(int cnt,int sum){
		if(sum>=B){
			min=Math.min(min,sum-B);
			return;
		}
		if(cnt==N) return;
		
		subs(cnt+1,sum+H[cnt]);
		subs(cnt+1,sum);
	}
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d4_1486.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());		
		for(int tc=1; tc<=T; tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			H=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) H[i]=Integer.parseInt(st.nextToken());
			min=Integer.MAX_VALUE;
			subs(0,0);
			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
