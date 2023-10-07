package BasicStructure;

import java.util.Arrays;

/**
 * 서로소 집합 기본 구조
 */

public class disjointSet {
	static int[] parents;
	
	public static void make(int N) {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i]=i;
		}
	}
	
	public static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a]=find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) {
		int N = 5;
		make(N);
		
		System.out.println(union(2,1));
		System.out.println(find(1));
		System.out.println(Arrays.toString(parents));
		

	}

}
