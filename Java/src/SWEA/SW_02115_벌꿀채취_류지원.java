package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 류지원
 * 메모리 : 25396KB
 * 실행시간 : 152ms
 * 
 * 풀이방법 : 
 * 1. 일꾼들이 서로 작업할 꿀통이 서로 겹치지 않게 꿀통을 선택하도록 조합으로 구현
 * 
 * 2. 일꾼이 꿀통들을 채취하기 전 바구니보다 크지 않은지 확인
 * 
 * 	2-1. 만약 바구니보다 꿀의 양이 적다면 모든 꿀들을 채취하여 꿀 가격 계산.
 * 
 * 	2-2. 만약 바구니보다 꿀의 양이 크다면 채취한 꿀의 양이 최대한 바구니크기에 근접하도록 꿀통들을 선택하여 채취한 꿀의 가격 계산.
 * 
 * 		2-2-1. 2-2를 구현하기 위해 일꾼이 선택한 꿀통 배열을 넘겨서 부분집합으로 각 꿀통들을 선택하였을때 바구니크기를 넘지않는 최대 채취방법이 무엇인지 탐색.
 * 
 * 3. 2번 작업을 1번에서 찾은 조합대로 계속 탐색 및 가격을 꿀의 가격을 비교하며 최대가 되는 꿀의 가격을 찾아내면 끝
 *
 */


public class SW_02115_벌꿀채취_류지원 {
	static boolean[][] isSelected;
	static int[][] map;
	static int N, M, C, max, honeyPriceMax;
	static boolean[] honeySelected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer ST;
		
		int T = Integer.parseInt(br.readLine());		// 테스트케이스
		
		for(int t=1; t<T+1; t++) {					
			ST = new StringTokenizer(br.readLine());
			N = Integer.parseInt(ST.nextToken());	// 벌통들의 크기
			M = Integer.parseInt(ST.nextToken());	// 선택할 수 있는 벌통의 개수
			C = Integer.parseInt(ST.nextToken());	// 꿀을 채취할 수 있는 최대 양
			max = 0;
			
			// 벌통 이차원 배열
			map = new int[N][N];
			isSelected = new boolean[N][N];
			
			// 벌통의 꿀 보유량 입력받기
			for(int i=0; i<N; i++) {
				ST = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(ST.nextToken());
				}
			}
			
			combination(0, 0, 0);
			System.out.println("#" + t + " " + max);
		}

	}
	
	public static void combination(int cnt, int stti, int sttj) {
		// 기저조건
		if(cnt == 2) {
			int sum=0;
			// 가로 2개가 C를 넘는다면 가로 2개중에 큰것만 계산하기, 그리고 j에 1 더하기
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(isSelected[i][j]) {
						int basket = 0;
						for(int k=0; k<M; k++) {
							basket += map[i][j+k];
						}
						if(basket<=C) {			// 모든 꿀의 양이 바구니용량보다 작을경우
							for(int k=0; k<M; k++) {
								sum += Math.pow(map[i][j+k],2);	// 모든 꿀 채취하여 전부 더하기
							}
						}
						else if(basket>C) {		// 모든 꿀의 양이 바구니용량보다 클 경우
							// 꿀을 가장 많이 채취하는 수를 찾아야 함.
							honeyPriceMax = 0;
							// map[i][j] ~ map[i][j+M-1]까지에서 부분집합해서 C를 넘지않으면  MAX에 추가
							honeySelected = new boolean[M];
							subset(0, Arrays.copyOfRange(map[i], j, j+M));
							
							sum += honeyPriceMax;
							
						}
						
						j+=(M-1);

					}
				}
			}
			max=Math.max(max, sum);
			return;
		}
		
		// 운용조건
		for(int i=stti; i<N; i++) {
			if(i==stti) {
				for(int j=sttj; j<N-M+1; j++) {
					if(isSelected[i][j]==false) {
						for(int k=0; k<M; k++) {
							isSelected[i][j+k]=true;
						}
						combination(cnt+1, i, j);
						for(int k=0; k<M; k++) {
							isSelected[i][j+k]=false;
						}
					}
				}
			}
			else {
				for(int j=0; j<N-M+1; j++) {
					if(isSelected[i][j]==false) {
						for(int k=0; k<M; k++) {
							isSelected[i][j+k]=true;
						}
						combination(cnt+1, i, j);
						for(int k=0; k<M; k++) {
							isSelected[i][j+k]=false;
						}
					}
				}
			}
		}
		
		
		
	}
	
	public static void subset(int cnt, int[] honeyLine) {
		// 기저조건
		if(cnt==M) {
			int sum=0;
			int price = 0;
			for(int i=0; i<M; i++) {
				if(honeySelected[i]) {
					sum+=honeyLine[i];
					price += Math.pow(honeyLine[i], 2);
					if(sum>C) {
						return;
					}
				}
			}
			honeyPriceMax = Math.max(honeyPriceMax, price);
			
			return;
		}
		
		// 운용조건
		honeySelected[cnt]=true;
		subset(cnt+1, honeyLine);
		honeySelected[cnt]=false;
		subset(cnt+1, honeyLine);
		
	}

}
