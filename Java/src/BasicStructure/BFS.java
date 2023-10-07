package BasicStructure;

import java.io.*;
import java.util.*;

/**
 * BFS 기본 구조
 * 상우하좌 순서대로 너비우선하여 이동
 */

public class BFS {
	static int[] di={-1,0,1,0};//상우하좌
	static int[] dj={0,1,0,-1};
	static int N=5, C=0;
	static int[][] a;
	static boolean[][] v;
	
	static void bfs(int i,int j){
		Queue<int[]> q=new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		while(!q.isEmpty()){
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];
			
			a[i][j]=C++;
			for(int[] b:a) System.out.println(Arrays.toString(b)); System.out.println();
			for(int d=0; d<4; d++){
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj]){
					v[ni][nj]=true;
					q.offer(new int[]{ni,nj});
				}
			}
		}
	}
	
	static void depthCountBFS(int i,int j){
		Queue<int[]> q=new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		int cnt = 1;
		while(!q.isEmpty()){
			int size = q.size();
			while(size>0) {
				int[] ij=q.poll();
				i=ij[0];
				j=ij[1];
				
				a[i][j]=C++;
				System.out.println(cnt);
				for(int[] b:a) System.out.println(Arrays.toString(b)); System.out.println();
				for(int d=0; d<4; d++){
					int ni=i+di[d];
					int nj=j+dj[d];
					if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj]){
						v[ni][nj]=true;
						q.offer(new int[]{ni,nj});
					}
				}
				size--;
			}
			cnt++;
		}
	}
	
	
	
	public static void main(String[] args) throws Exception{
		a=new int[N][N];
		v=new boolean[N][N];
		C=1;
//		bfs(N/2,N/2);
		depthCountBFS(N/2,N/2);
	}
}
