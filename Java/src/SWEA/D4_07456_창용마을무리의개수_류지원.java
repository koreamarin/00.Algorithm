package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_07456_창용마을무리의개수_류지원 {
	static int[] parents;
	
	static int find(int a){ 
		if(a==parents[a]) return a;
		return parents[a]=find(parents[a]);
	}
	static boolean union(int a, int b) {
		int rootA=find(a);
		int rootB=find(b);
		if(rootA==rootB) return false;
		parents[rootB]=rootA;
		return true;
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("sadf.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder SB = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			StringTokenizer ST = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(ST.nextToken());
			int M = Integer.parseInt(ST.nextToken());
			parents=new int[N+1];
			
			for(int i=1; i<N+1; i++) parents[i]=i;
			int cnt=N;
			for(int i=0; i<M; i++) {
				ST=new StringTokenizer(br.readLine());
				if(union(Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken()))) cnt--;
			}
			SB.append("#"+ t + " " + cnt + "\n");
		}
		System.out.print(SB.toString());
	}
}
