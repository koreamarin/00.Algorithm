package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author 류지원
 * 시간 : 518ms
 * 메모리 : 96980kb
 * 풀이방법 : 
 * 완전탐색으로 진행할 예정이다.
 * 0,0부터 시작하여 열과 행순으로 1씩 증가시키며 그릴수 있는 마름모를 모두 계산한다.
 */

public class SW_02105_디저트카페_류지원 {
	static int[][] map;
	static int desert_max;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			desert_max = -1;
			for(int i=0; i<N; i++) {
				ST=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}
			
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					bruteForce(i, j);	// 모든 마름모별로 다 돌아보기
				}
			}
			
			System.out.println("#" + t + " " + desert_max);
		}
	}
	
	// 모든 마름모별로 다 돌아보는 메서드
	public static void bruteForce(int i, int j) {
//		System.out.println();
//		System.out.println("마름모 시작, 시작 위치 : " + i + " " + j);
		// 오아, 왼위
		for(int l1=N-2; l1>0; l1--) {
			// 왼아, 오위
			loof:
			for(int l2=N-2; l2>0; l2--) { // l2 = 2 => 1
//				System.out.println("l1 : 2" + l1 + " / l2 :2 " + l2);
				int sub = 0;
				int ci=i;
				int cj=j;
				List<Integer> cafeList = new ArrayList<Integer>();
				
				// 오아
				for(int rd=1; rd<=l1; rd++) {
					ci+=1; cj+=1;
					if(!isRange(ci, cj)) {
//						System.out.println("넘음1");
						continue loof;   
					} else if(ate(cafeList, map[ci][cj])) {
//						System.out.println("먹음1");
						continue loof;
					}
					
					sub+=1;
					cafeList.add(map[ci][cj]);
				}
				// 왼아
				for(int ld=1; ld<=l2; ld++) {
					ci+=1; cj-=1;
					if(!isRange(ci, cj)) {
//						System.out.println("넘음2");
						continue loof;
					} else if(ate(cafeList, map[ci][cj])) {
//						System.out.println("먹음2");
						continue loof;
					}
					
					sub+=1;
					cafeList.add(map[ci][cj]);
				}
				// 왼위
				for(int lu=1; lu<=l1; lu++) {
					ci-=1; cj-=1;
					if(!isRange(ci, cj)) {
//						System.out.println("넘음3");
						continue loof;
					} else if(ate(cafeList, map[ci][cj])) {
//						System.out.println("먹음3");
						continue loof;
					}
					
					sub+=1;
					cafeList.add(map[ci][cj]);
				}
				// 오위
				for(int ru=1; ru<=l2; ru++) {
					ci-=1; cj+=1;
					if(!isRange(ci, cj)) {
//						System.out.println("넘음4");
						continue loof;
					} else if(ate(cafeList, map[ci][cj])) {
//						System.out.println("먹음4");
						continue loof;
					}
					
					sub+=1;
					cafeList.add(map[ci][cj]);
				}
//				System.out.println("값: " + sub);
				desert_max = Math.max(desert_max, sub);
			}
		}
	}
	
	public static boolean isRange(int i, int j) {
		if(0>i || N<=i) return false;
		if(0>j || N<=j) return false;
		return true;
	}
	
	public static boolean ate(List<Integer> cafeList, int n) {
		for(int cafe : cafeList) {
			if(cafe==n) return true;
		}
		return false;
	}
}
