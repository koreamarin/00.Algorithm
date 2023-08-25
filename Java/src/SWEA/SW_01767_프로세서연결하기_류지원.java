package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_01767_프로세서연결하기_류지원 {

	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T=Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			N=Integer.parseInt(br.readLine());		// PCB 길이
			int[][] PCB = new int[N][N];			// PCB 위치 정보 배열
			for(int i=0; i<N; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) PCB[i][j]=Integer.parseInt(ST.nextToken());
			}
			
			// dfs를 안 해도 되는 코어칩 세기
			int except=0;
			for(int i=0; i<N; i++) {
				if(PCB[0][i]==1) 	except++;
				if(PCB[N-1][i]==1) 	except++;
			}
			for(int i=1; i<N-1; i++) {
				if(PCB[i][0]==1) 	except++;
				if(PCB[i][N-1]==1)	except++;
			}
			System.out.println(except);
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

	}
	
	
	public static void dfs(int cnt) {
		if(true) {
			
		}
	}

}
