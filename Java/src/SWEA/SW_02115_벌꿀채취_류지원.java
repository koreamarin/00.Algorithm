package SWEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_02115_벌꿀채취_류지원 {
static int N,M,C,max,hap,a[][];
	
	static void calc(int x,int y,int yM, int c,int cc){
		if(c>C) return; //채취 가능한 꿀의 최대 양
		hap=Math.max(hap,cc);
		for(int j=y; j<yM; j++){
			calc(x,j+1,yM,c+a[x][j],cc+a[x][j]*a[x][j]);
		}
	}
	static void comb(int cnt,int idx,int sum){
		if(cnt==2){
			max=Math.max(max,sum);
			return;
		}
		for(int i=idx; i<N*N; i++){
			int x=i/N;//행row
			int y=i%N;//열col
			if(y>N-M) continue;
			hap=0;
			calc(x,y+0,y+M, 0,0); // i,j+0,j+M, 양,양*양
			comb(cnt+1,i+M,sum+hap);
		}		
	}
	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input_d9_2115.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());		
		for(int tc=1; tc<=T; tc++){
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			a=new int[N][N];
			for(int i=0; i<N; i++){
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++){
					a[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			//for(int[] b:a) System.out.println(Arrays.toString(b));
			max=0;
			comb(0,0,0);//일꾼0,작업위치0,채취양0
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
