package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @author 류지원
 * 시간 : 
 * 메모리 : 
 * 풀이방법 : 
 * 1. Core의 개수를 센다.
 * 2. Core를 내림차순으로 sweep하면서, 코어가 m개만큼 연결되어 있다고 가정하고, 연결된 core가 무엇인지를 고른다. 
 * 3. 연결됐다고 가정하는 Core의 배선을 DFS로 사방으로 돌려보며 연결이 되는지 찾는다.
 * 3. 연결이 됐다면, 연결이 된 Core의 개수(m)를 기록하고, 계속 배선 DFS를 돌려서 가장 짧은 배선방법이 있는지 찾는다. 가장 짧은 배선방법이 정답이다.
 * 4. 연결이 안됐다면, 다음 Core가 연결됐다고 가정하는 다음 순서 과정을 진행한다.
 */

public class SW_01767_프로세서연결하기_류지원 {
	static int N;		// 배열의 크기
	static int PN;		// 프로세서의 개수
	static int R;		// 고른 프로세서의 개수
	static int[] numbers;
	static int[][] PcLo;	// 프로세서의 위치를 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			N = Integer.parseInt(br.readLine());	// 배열의 크기
			PN = 0;
			int[][] map = new int[N][N];
			int crtNum;
			for(int i=0; i<N; i++) {				// 배열 입력 받기
				ST = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					crtNum=Integer.parseInt(ST.nextToken());
					map[i][j]=crtNum;
					if(crtNum==1) {
						 if(i!=0 && i!=N-1 && j!=0 && j!=N-1) {
							 PcLo[PN][0] = i;
							 PcLo[PN][1] = j;
							 PN++; 
						 }
					}
				}
			}
			for(int i=0; i<)
			
			
			// 연결된 코어 고르기.
			for(R=PN; R>0; R--) {
				numbers=new int[R];
				combination(0,0);
			}
			
			

			
			System.out.println("#" + t + " ");
			
			
		}

	}
	
	public static void combination(int cnt, int start) {
		// 기저조건
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));			
			return;
		}
		
		// 운용조건
		for(int i=start; i<PN; i++) {
			numbers[cnt]=i;
			combination(cnt+1, i+1);
		}
	}
	
	public static void 
	
	
	
	
	

}
