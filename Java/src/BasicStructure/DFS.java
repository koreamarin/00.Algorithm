package BasicStructure;

import java.io.*;
import java.util.*;

/**
 * DFS 기본 구조
 * 상우하좌 순서대로 깊이우선하여 이동
 */

public class DFS {
	static int[] di={-1,0,1,0};//상우하좌
	static int[] dj={0,1,0,-1};
	static int N=5, C=0;
	static int[][] a;
	static boolean[][] v;
	
	static void dfs(int i,int j){
		v[i][j]=true;
		a[i][j]=C++;
		for(int[] b:a) System.out.println(Arrays.toString(b)); System.out.println();
		for(int d=0; d<4; d++){		// 운용조건인 동시에 기저조건
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj]){
				dfs(ni,nj);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		a=new int[N][N];
		v=new boolean[N][N];
		C=1;
		dfs(N/2,N/2);
	}
}
