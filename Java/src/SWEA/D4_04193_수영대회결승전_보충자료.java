package SWEA;

import java.io.*;
import java.util.*;

/**
 * 보충수업자료
 */

public class D4_04193_수영대회결승전_보충자료{
	static int[] di={-1,0,1,0};//상우하좌
	static int[] dj={0,1,0,-1};
	static int N, a[][], S[], E[];
	static boolean[][] v;
	
	static int bfs(int i,int j){
		int time=0;
		Queue<int[]> q=new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});//시작점
		while(!q.isEmpty()){
			int SIZE=q.size();
			for(int s=0; s<SIZE; s++){
				int[] ij=q.poll();
				i=ij[0];
				j=ij[1];
				if(i==E[0] && j==E[1]) return time;//도착점
				for(int d=0; d<4; d++){
					int ni=i+di[d];
					int nj=j+dj[d];
					if(ni<0||N<=ni || nj<0||N<=nj) continue;//범위
					if(a[ni][nj]==1 || v[ni][nj]) continue;//1장애물, 방문
					if(a[ni][nj]==2){//2소용돌이
						if(time%3==2){//2초후 지나감
							v[ni][nj]=true;
							q.offer(new int[]{ni,nj});
						}else{//나머진 대기
							q.offer(new int[]{i,j});
						}
					}else{//0바다: 지나갈 수 있는 곳
						v[ni][nj]=true;
						q.offer(new int[]{ni,nj});
					}
				}
			}
			time++;
		}
		return -1;
	}
	static int bfs(int i,int j,int time){
		Queue<int[]> q=new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j,time});//시작점
		while(!q.isEmpty()){
			int[] ij=q.poll();
			i=ij[0];
			j=ij[1];
			time=ij[2];
			if(i==E[0] && j==E[1]) return time;//도착점
			for(int d=0; d<4; d++){
				int ni=i+di[d];
				int nj=j+dj[d];
				if(ni<0||N<=ni || nj<0||N<=nj) continue;//범위
				if(a[ni][nj]==1 || v[ni][nj]) continue;//1장애물, 방문
				if(a[ni][nj]==2){//2소용돌이
					if(time%3==2){//2초후 지나감
						v[ni][nj]=true;
						q.offer(new int[]{ni,nj,time+1});
					}else{//나머진 대기
						q.offer(new int[]{i,j,time+1});
					}
				}else{//0바다: 지나갈 수 있는 곳
					v[ni][nj]=true;
					q.offer(new int[]{ni,nj,time+1});
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4193.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=null;
		int T=Integer.parseInt(br.readLine());		
		for(int tc=1; tc<=T; tc++){
			N=Integer.parseInt(br.readLine());
			a=new int[N][N];
			v=new boolean[N][N];
			S=new int[2];
			E=new int[2];
			for(int i=0; i<N; i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++){
					a[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			st=new StringTokenizer(br.readLine()," ");
			S[0]=Integer.parseInt(st.nextToken());
			S[1]=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine()," ");
			E[0]=Integer.parseInt(st.nextToken());
			E[1]=Integer.parseInt(st.nextToken());
			sb.append("#").append(tc).append(" ").append(bfs(S[0],S[1])).append("\n");
			//sb.append("#").append(tc).append(" ").append(bfs(S[0],S[1],0)).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}