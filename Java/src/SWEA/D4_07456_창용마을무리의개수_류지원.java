package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 :  25928kb
 * 시간 : 131ms
 * 풀이방법 : 서로소집합을 사용하여 아는사람들끼리 하나의 집합으로 묶었다.
 *
 */

public class D4_07456_창용마을무리의개수_류지원 {
	static int[] parents;
	
	public static void make(int N) {
		parents = new int[N];
		for(int i=0; i<N; i++) parents[i]=i;
	}
	
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;	
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T + 1; t++) {
			ST = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(ST.nextToken());	// 사람 수
			int M = Integer.parseInt(ST.nextToken());	// 관계 수
			
			int[][] info = new int[M][2];
			
			for(int m=0; m<M; m++) {
				ST = new StringTokenizer(br.readLine());
				info[m][0] = Integer.parseInt(ST.nextToken())-1;
				info[m][1] = Integer.parseInt(ST.nextToken())-1;
			}
			
			make(N);
			
			for(int m=0; m<M; m++) {
				union(info[m][0], info[m][1]);
			}
			
			boolean[] count = new boolean[N];
			int cnt=0;
			for(int i=0; i<N; i++) {
				count[find(i)]=true;
			}
			
			for(int i=0; i<N; i++) {
				if(count[i]==true) cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
//	
}
