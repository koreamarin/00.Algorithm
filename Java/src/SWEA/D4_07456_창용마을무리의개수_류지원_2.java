package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D4_07456_창용마을무리의개수_류지원_2 {
	static int[] parents;

	public static void make(int N) {
		parents = new int[N];
		for(int i=0; i<N; i++) parents[i]=i;
	}
	
	public static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a]=find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a), bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			ST = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(ST.nextToken());	// 사람의 수
			int M=Integer.parseInt(ST.nextToken());	// 관계 수
			make(N);
			for(int m=0; m<M; m++) {
				ST=new StringTokenizer(br.readLine());
				int A=Integer.parseInt(ST.nextToken())-1, B=Integer.parseInt(ST.nextToken())-1;
				union(A,B);
			}
			Set<Integer> set = new HashSet<>();
			for(int i=0; i<N; i++) set.add(find(parents[i]));
			System.out.println("#" + t + " " + set.size());
		}
	}
}
