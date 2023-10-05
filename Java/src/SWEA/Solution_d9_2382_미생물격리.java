package a1005.add;

import java.io.*;
import java.util.*;

public class Solution_d9_2382_미생물격리 {
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_2382.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
	    int T=Integer.parseInt(br.readLine());		
		for(int tc=1; tc<=T; tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken()); //한 변의 셀의 개수
			int M=Integer.parseInt(st.nextToken()); //격리 시간
			int K=Integer.parseInt(st.nextToken()); //미생물 군집의 개수
			int[][] list=new int[K+1][5];//K+1: 0초기값이라 제외
			for(int k=1; k<=K; k++){     //세로0,가로1,미생물수2,이동방향3,max미생물수4
				st=new StringTokenizer(br.readLine()," ");
				list[k]=new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),
						          Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0};
			}
			//for(int[] a:list) System.out.println(Arrays.toString(a));
			for(int t=0; t<M; t++){
				int[][] map=new int[N][N];
				for(int k=1; k<=K; k++){
					int[] a=list[k];//세로0,가로1,미생물수2,이동방향3,max미생물수4
					if(a==null) continue;
					switch(a[3]){//이동방향3
						case 1: a[0]--; break;//상1 
						case 2: a[0]++; break;//하2
						case 3: a[1]--; break;//좌3
						case 4: a[1]++; break;//우4
					}
					if(a[0]==0||a[0]==N-1 || a[1]==0||a[1]==N-1){//가장자리의 빨간 셀은 약품이 칠해져 있는 셀
						a[2]/=2;//미생물수2
						a[3]=(a[3]==2||a[3]==4)? a[3]-1:a[3]+1;//이동방향3 하2||우4? -1:+1 반대방향
						continue;
					}
					a[4]=a[2];//max미생물수4=미생물수2 백업
					if(map[a[0]][a[1]]==0){//셀에 최초로 도착한 군집일 경우
						map[a[0]][a[1]]=k;
					}else{                 //셀에 이전에 도착한 군집이 있는 경우
						int p=map[a[0]][a[1]];//이전에 도착한 군집번호 p, 현재 도착한 군집번호 k
						int[] b=list[p];      //이전에 도착한 군집   b[], 현재 도착한 군집   a[]
						b[2]+=a[2];//미생물수2 누적
						if(b[4]<a[2]){
							b[4]=a[2];
							b[3]=a[3];//이동방향3 max미생물수 방향
						}
						list[k]=null;
					}
				}
			}
			int sum=0;
			for(int[] a:list) if(a!=null) sum+=a[2]; //미생물수2
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
	    }
	    System.out.print(sb.toString());
	    br.close();
	}
}