package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_01717_집합의표현_류지원2 {
	static int[] parents;
	private static void make(int N) {
		parents = new int[N+1];
		for(int n=1; n<N+1; n++) parents[n]=n;
	}
	private static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aBoss = find(a);
		int bBoss = find(b);
		if(aBoss==bBoss) return false;
		parents[bBoss]=aBoss;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(ST.nextToken()), M = Integer.parseInt(ST.nextToken());
		make(N);
		for(int m=0; m<M; m++) {
			ST = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(ST.nextToken()), a = Integer.parseInt(ST.nextToken()), b = Integer.parseInt(ST.nextToken());
			if(p==0) union(a,b);
			else System.out.println( find(a)==find(b) ? "YES" : "NO");
		}
	}
}