package SWEA;

import java.io.*;
import java.util.*;

public class SW_04008_숫자만들기_보충자료 {
	static int N,a[],min,max;
	
	static void subs(int cnt,int sum,int add,int sub,int mul,int div){
		if(cnt==N){
			min=Math.min(min,sum);
			max=Math.max(max,sum);
			return;
		}
		if(add>0) subs(cnt+1,sum+a[cnt],add-1,sub,  mul,  div  );
		if(sub>0) subs(cnt+1,sum-a[cnt],add  ,sub-1,mul,  div  );
		if(mul>0) subs(cnt+1,sum*a[cnt],add  ,sub,  mul-1,div  );
		if(div>0) subs(cnt+1,sum/a[cnt],add  ,sub,  mul,  div-1);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4008.txt"));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++){
			N=Integer.parseInt(br.readLine());			
			int[] o=new int[4];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<4; i++) o[i]=Integer.parseInt(st.nextToken());			
			a=new int[N];
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) a[i]=Integer.parseInt(st.nextToken());			
			min=100_000_000; max=-100_000_000;
			subs(1,a[0],o[0],o[1],o[2],o[3]);
	        sb.append("#").append(tc).append(" ").append(max-min).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
