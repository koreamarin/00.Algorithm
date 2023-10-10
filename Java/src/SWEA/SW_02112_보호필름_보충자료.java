package SWEA;

import java.io.*;
import java.util.*;
/**
 * 직접안품. 보충수업자료
 */
public class SW_02112_보호필름_류지원{
	static int D,W,K,min,inject[],map[][];
	
	static boolean check(){
		int cnt=0;
		for(int w=0; w<W; w++){
			cnt=1;
			for(int d=0; d<D-1; d++){
				int curr=inject[d  ]==-1? map[d  ][w]:inject[d  ];
				int next=inject[d+1]==-1? map[d+1][w]:inject[d+1];
				if(curr==next){
					cnt++;
					if(cnt>=K) break;
				}else{
					cnt=1;
				}
			}
			if(cnt<K) return false;
		}
		return true;
	}
	static void subs(int row,int cnt){
		if(cnt>=min) return;
		if(row==D){
			if(check()) min=Math.min(min,cnt);
			return;
		}
		inject[row]=-1;//X
		subs(row+1,cnt);
		inject[row]=0;//A
		subs(row+1,cnt+1);
		inject[row]=1;//B
		subs(row+1,cnt+1);
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_2112.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
        int T=Integer.parseInt(br.readLine());        
        for(int tc=1; tc<=T; tc++){
        	StringTokenizer st=new StringTokenizer(br.readLine()," ");
        	D=Integer.parseInt(st.nextToken());
        	W=Integer.parseInt(st.nextToken());
        	K=Integer.parseInt(st.nextToken());
        	map=new int[D][W];
        	inject=new int[D];//X:-1 A:0 B:1
        	for(int d=0; d<D; d++){
        		st=new StringTokenizer(br.readLine()," ");
        		for(int w=0; w<W; w++){
        			map[d][w]=Integer.parseInt(st.nextToken());
        		}
        	}
        	min=D;
        	subs(0,0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}