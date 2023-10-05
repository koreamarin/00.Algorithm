package BasicStructure;

import java.io.*;
import java.util.*;

public class Subs {
	static int N=4,/*R=3,*/C=0;
	static int[] a={1,2,3,4}/*,b=new int[R]*/;
	static boolean[] v=new boolean[N];
	
	static void subs(int cnt){
		if(cnt==N){
			//System.out.println(Arrays.toString(v)); C++;
			for(int i=0; i<N; i++) System.out.print(v[i]? a[i]:"x");
			System.out.println(); C++;
			return;
		}
		v[cnt]=true;
		subs(cnt+1);
		v[cnt]=false;
		subs(cnt+1);
	}
	static void subs(int cnt,int sum){
		if(cnt==N){
			System.out.println("sum="+sum); C++;
			return;
		}
		subs(cnt+1,sum+a[cnt]);
		subs(cnt+1,sum);
	}
	public static void main(String[] args) throws Exception{
		C=0;
		//subs(0);
		subs(0,0);
		System.out.println(C);
	}
}
